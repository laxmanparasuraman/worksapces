//import React from 'react'  rfce react fuctions compomrmtd

export default function card(propss) {// props,{imgurl
  console.log("props called")
  console.log(propss)
  return ( 
    <div className="card" style={{width: "18rem"}}>
  <img src={propss.details.picture?.large} class="card-img-top" alt="..." style={{width: "250px"}}/>
  <div className="card-body">
    <h5 class="card-title">{propss.details.name?.first}</h5>
    <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" className="btn btn-primary">Go somewhere</a>
  </div>
</div>
  )
}
