const mongoose = require('mongoose');

const MONGODB_URL=""
  const connect=()=>{
    mongoose.connect(MONGODB_URL,{
        useNewUrlParser:true,
        useUnifiedTopology:true
    })
    .then(()=>console.log("db connect"))
    .catch((err)=>{
        console.log("db connction failed")
        console.log(err)
        process.exit()

    })



}

module.exports = connect