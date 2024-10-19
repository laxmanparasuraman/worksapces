import React from 'react'
import { useRouteError } from 'react-router-dom'

const Error = () => {
    const err= useRouteError()
    console.log(err)
  return (
    <div> 
        <p>loki</p>
        <p>404  Error</p>
        <h1>  error here </h1>
        <h1> {err.data}</h1>
       
    </div>
  )
}

export default Error