require("./config/database").connect()
const  express=require("express")
const jwt=require("jsonwebtoken")
const bcrypt =require("bcryptjs")
var cookieParser = require('cookie-parsers')

// import model -user
const User=require("./model/user")
const user = require("./model/user")
const app=express()

app.use(express.json())
app.use(express.urlencoded({ extended: true })) // for parsing application/x-www-form-urlencoded
app.use(cookieParser())

app.get("/",(req,res)=>{
    res.send("hello auth system")
})

app.post("/register",async(req,res)=>{
    
     try {
        // collect all information 
        const{firstname,lastname,email,password}=req.body
// vaildate the data. if exits 
if(!(firstname&&lastname&&email&&password)){
res.status(402).send("all fiels are required")

}
// check if user exists already

const existinguser = await User.findOne({email})

if(existinguser){
    res.status(401).send("user already exists")
}
// encrpt the user
const myencrptPassword=await bcrypt.hash(password,10)

//create anew entry in database
const User =await User.create({
    firstname,
    lastname,
    email,
    password:myencrptPassword
})


const token=jwt.sign({
    _id:User._id,email

},'shhhh',{expiresIn:'32h'})

user.token = token

user.password = undefined

res.status(201).json(user)//send({user,token})


     } catch (error) {
        console.log(error)
        console.log("error is response routes")
        
     }    
    console.log(req.body)// has to be com
    
})

app.post("/login",async(req,res)=>{

try {
    
//collcte information form frontend 

const{email,password}=req.body

// validate
if(!(email&&password)){
    res.status(401).send("all fiels are required email and password are requres")

}
// check user in database
const user=await User.findOne({email})
// if user does not exist in database - assignments
// match the password
if(user&&(await bcrypt.compare(password,user.password))){
    // generate token
    const token=jwt.sign({
        _id:user._id,email
    },'shhhhh',{expiresIn:'2h'})

    // in case we want to send a user need to make sure that we delete pasword
    user.password = undefined
    user.token=token


    const options={
        expires:new Date(Date.now() + 3*24*60*60*1000)
        httpOnly:true
 
    }
    
    res.status(200).cookie("token",token,options).json({
        success:true,
        token,
        user

    }

    )
}
// create token and send

res.sendStatus(400).send("email or password  is incorrect")



} catch (error) {
    
}

})


app.get("/dashboard",(req,res)=>{
    console.log(req.cookies)
    const token = req.cookies
    /*  const {token} = req.cookies also this the above is object destruting google to know mwre  */

    if(!token){
        return res.status(401).send("unauthorized")
    }
    //verify token = token

    try {
        

        const decode=jwt.verify(token,"shhhhh")
        console.log(decode)
        req.user = decode
        
        // extract  id from token and query the db (it will be done in later on mege=a project)

    } 
        
        catch (error) {
        
    }


})

