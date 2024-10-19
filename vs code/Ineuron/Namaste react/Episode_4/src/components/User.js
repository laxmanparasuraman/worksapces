import { useState } from "react"

const User=({name})=>{

    const[count,setcount]=useState(0)
        return(
        <div className="user-card">
            <h1 className="user-text" onClick={()=>setcount(count+1)}>count = {count}</h1>
            
            <h1 className="user-text">Name :{name}</h1>
            <h1 >Email :plaxman@mail.in</h1>
            <h1 className="user-text">Location:Kumbakonam</h1>


        </div>
    )
}
export default User