const jwt=require('jsonwebtoken')
const auth =(req,resizeBy) => {
    console.log(req.cookies)
    const token = req.cookies
    // what if token is not ther

    if(!token){

        return res.status(403).json({msg:"unauthorized"})
    }
    try {
        const decode=jwt.verify(token,`shhhhh`)
        console.log(decode)
        req.user = decode
        
    } catch (error) {
        return res.status(403).json({msg:"unauthorized token is in vaild"})
        
    }
}
    
module.exports = auth