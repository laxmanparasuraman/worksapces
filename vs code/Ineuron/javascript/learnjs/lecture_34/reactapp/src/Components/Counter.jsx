//import React from 'react'

import { useState } from "react"



const Counter = () => {
  const [Count, Setcount]=useState(0)// syntax   const [Variable, function()]=useState


  function  decrease(){
    Setcount(Count-1)
    
  }
  

  return (
  <div style={{ justifyContent: "center"  , display: "flex" }}>
    <div style={{color:"red" }}>Counter Value # {Count} </div>
    <button> Reset Counter</button>
    <button onClick={()=>(Count>10? "": Setcount(Count+1))}> Increase value</button>
    <button onClick={decrease}>Decrease Counter </button>
  </div>
  )

}
/* ()=>Setcount(Count-1) */
export default Counter
/* 
mklink  */