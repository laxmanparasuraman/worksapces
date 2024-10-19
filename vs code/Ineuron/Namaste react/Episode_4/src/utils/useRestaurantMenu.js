import React, { useEffect } from 'react'
import { useState } from 'react'
const useRestaurantMenu = (resId) => {
    // Fetch the restaurant menu data from an API
    // Implement caching and error handling logic
    // Return the restaurant menu data as a state variable
//   return (
//     <div>useRestaurantMenu</div>
//   )

const [resInfo,setResInfo]=useState(null)
useEffect(()=>{
    fetchMenu()
},[])
//let resInfo=null
const fetchMenu = async () => {
    const data=await fetch(
        "https://www.swiggy.com/dapi/menu/pl?page-type=REGULAR_MENU&complete-menu=true&lat=12.9715987&lng=77.5945627&restaurantId="+resId+"&catalog_qa=undefined&submitAction=ENTER"
     //   "https://www.swiggy.com/dapi/menu/pl?page-type=REGULAR_MENU&complete-menu=true&lat=12.9715987&lng=77.5945627&restaurantId="+resId+"&catalog_qa=undefined&submitAction=ENTER"
        //"https://www.swiggy.com/dapi/menu/pl?page-type=REGULAR_MENU&complete-menu=true&lat=12.9715987&lng=77.5945627&restaurantId="+resId+"&catalog_qa=undefined&submitAction=ENTER"
        // "https://www.swiggy.com/dapi/menu/pl?page-type=REGULAR_MENU&complete-menu=true&lat=12.9715987&lng=77.5945627&restaurantId="+resId+"&catalog_qa=undefined&submitAction=ENTER"

    )
    const json= await data.json()
    //resInfo=json
    console.log("json in fetch data in userestaurant hooks  json data ", json)
    setResInfo(json.data)
    // console.log(json)
   console.log("json from hoks ",resInfo)


}
return  resInfo
}

export default useRestaurantMenu