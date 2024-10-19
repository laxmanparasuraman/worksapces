import React, { useEffect, useState } from 'react'
import Shimmer from './Shimmer'
import { useParams } from 'react-router-dom'
import useRestaurantMenu from '../utils/useRestaurantMenu'
import RestaurtantCategory from './RestaurtantCategory'

const RestaurantMenu = () => {

  
 /* useEffect(() =>{
    fetchMenu()

},[]) */ 
const [showIndex,setShowIndex]=useState(null)

const param=useParams()
console.log("param", param)
const {resId}=useParams()
console.log("resID: ",resId)

const resInfo=useRestaurantMenu(resId)

console.log("resInfo ",resInfo)
//useRestaurantMenu

/* const fetchMenu = async () => {
    const data=await fetch(
        "https://www.swiggy.com/dapi/menu/pl?page-type=REGULAR_MENU&complete-menu=true&lat=12.9715987&lng=77.5945627&restaurantId="+resId+"&catalog_qa=undefined&submitAction=ENTER"
        // "https://www.swiggy.com/dapi/menu/pl?page-type=REGULAR_MENU&complete-menu=true&lat=12.9715987&lng=77.5945627&restaurantId="+resId+"&catalog_qa=undefined&submitAction=ENTER"

    )
    const json= await data.json()
    console.log("json in fetch data ")
    console.log(json)
    console.log(json.data.cards[2].card.card.info)
    /setresInfo(json.data)
    setresInfo(json.data)
    /setresInfo(json.data.cards[2].card.card.info)
} */
if(resInfo==null)return <Shimmer/>


   console.log("use state  resinfo ",resInfo)
   // destructuring
  //const {name,cuisines}=resInfo.data.cards[2].card.card.info
  const {name,cuisines}=resInfo.cards[2].card.card.info
 console.log("name  cus",name,cuisines)
  const itemCards=resInfo.cards[4].groupedCard.cardGroupMap.REGULAR.cards[3].card.card?.itemCards
 console.log(itemCards)
  
 const category=resInfo.cards[4].groupedCard.cardGroupMap.REGULAR.cards.filter((c)=>
    c.card.card?.["@type"]==="type.googleapis.com/swiggy.presentation.food.v2.ItemCategory"
 
) 
console.log("resInfo.cards[4].groupedCard.cardGroupMap.REGULAR.cards" ,resInfo.cards[4].groupedCard.cardGroupMap.REGULAR.cards)
console.log("category",category)
const dummyDataPropsDrilling="dummyDataPropsDr"
 return (
    <div className='text-center'>
            <div>
    {/*<div className='menu '>
        <h1>{name}</h1>
        <h2>{cuisines.join(" , ")}</h2> 
        <ul>
            {itemCards?.map((item)=>{
               return <li key={item?.card?.info?.id} >{item?.card?.info?.name} - {" Rs . "+ item.card.info.price/100||item.card.info.defaultprice}</li>
            })}
            
            {/* <li>{itemCards[0].card.info.name}</li>
            <li>{itemCards[1].card.info.name}</li>
            <li>{itemCards[2].card.info.name}</li> /}
             
        </ul>

    </div>*/}
            </div>
     <h1 className='font-bold my-6 text-2xl'>{name}</h1>
     <p className='font-bold text-lg'>
        {cuisines.join(",")}
     </p>  
           {/* category accordiaian  */}
           {category.map((c,index)=><RestaurtantCategory
            key ={c?.card?.card.title}
            data ={c?.card?.card}
            showItem={index===showIndex? true:false}
            setShowIndex={(i)=>setShowIndex(i)}
            index={index}
            useContext={dummyDataPropsDrilling}/>)
            }
    </div>
  )
}

export default RestaurantMenu