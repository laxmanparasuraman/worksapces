//import React from 'react'

function DestructureProps({ title, ...props }) {
  return (
    <div>
        <h1>{title}</h1>
        <p>{props.description}</p>
      </div>
  )
}

export default DestructureProps


  