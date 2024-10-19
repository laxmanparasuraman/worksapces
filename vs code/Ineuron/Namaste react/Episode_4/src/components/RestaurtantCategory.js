import React, { useEffect, useState } from 'react'
import ItemList from './ItemList'

const RestaurtantCategory = ({data,showItem,setShowIndex,index}) => {
    console.log("data",data)

     //const[showItem,setShowItem] =useState()
   //  showItem= useState[0]
   //const  setShowItem=useState[1]
   
   const handleClick = () => {
      //setShowIteam(!showIteam)
      if(showItem){
        showItem=!showItem
        setShowIndex(null)
        
      }else{

        setShowIndex(index)
      }
     // setShowItem(!showItem)
      //setShowIndex(!showIndex)
       console.log("clicked")
        // your code here to handle click event on the category title
 

    } 
  return (
    <div>
        <div className="w-6/12 mx-auto my-4 bg-gray-200 shadow-lg p-4 ">
          <div  className='flex justify-between'
          onClick={handleClick}>
          <span>{data.title} ({data.itemCards.length})</span>     
          <span className='text-2xl'>+</span>
          </div>
         {showItem&& <ItemList items={data.itemCards}
         //useContext={dummyDataPropsDrilling}
         />}
         </div>
        
    </div>
  )
}

export default RestaurtantCategory