const app=require("./app")
const {port}=process.env
//process.env.port
app.listen(4000,()=>"server is running at 4000")