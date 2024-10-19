import React, { useEffect } from 'react'
import Header from './Header'

const Contact = () => {
  useEffect(() =>{
 console.log("use effect")
  })

  return (
    <div>
        
        {/* <Header/> */
        console.log("contact render")}
        <h1>Contact</h1>
        
    </div>
  )
}

export default Contact