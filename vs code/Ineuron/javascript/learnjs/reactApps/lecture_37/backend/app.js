const express = require('express')
const app=express()
const port =3000

app.get('/',(req,res)=>{
    res.send("hello word express")
})

app.get('/laxman',(req,res)=>{
    res.send("social media")
})
app.get('/features',(req,res)=>{
    res.send("A tes runnenr")
})



app.listen(port,()=>{
    console.log("example app listening   , i ma able to listen ib this "
        ,`${port}`
    )
})