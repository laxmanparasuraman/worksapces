require("dotenv").config()
const express=require('express')
const user=require('./model/user')
const abc=express()
abc.get("/",(req,res)=>{
    res.send("<h1>welcome to ineuron</h1>")
})
abc.post("/signup",(req,res)=>{
    const {firstname,lastname,email,password}=req.body
    if(!(email&&password&&firstname&&lastname)){
        res.status(400).send("all field are required")
    }

    const extuser=user.findone(email)
    if(extuser){
        res.status(400).send("user already exits")
    }
})


module.exports=abc


console.log("check")