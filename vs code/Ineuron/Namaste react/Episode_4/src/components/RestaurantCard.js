import { CDN_URL } from '../utils/constants';
import React from 'react';
const RestaurantCard=(props)=>{
    // console.log("props here")
    // console.log(props)
    const { restaurantData } = props;
    //console.log("resData")
    //console.log(restaurantData)
     
  
      
      
      const{cloudinaryImageId,
        name,
        areaName,
        avgRating,
        cuisines,
        costForTwo,
        deliveryTime,}=restaurantData?.info || restaurantData;//restaurantData?.info;
         //   console.log("laxman")
       // console.log(RestaurantCard)
       // console.log("zoho "+"/"+name+"/"+areaName+"/"+ cuisines+"/"+costForTwo +"/"+deliveryTime)
       
        const styleCard={
          backgroundColor:"#f0f0f0",
      }
      return(
          <div className="res-card  h-[600px]   m-4 p-4 w-[300px]  hover:bg-blue-950" style={styleCard}> 
             <img  className="res-logo
            h-[300px] w-full object-cover  rounded-l-2xl "
             alt ="res logo"
             src={//"https://images.pexels.com/photos/13268478/pexels-photo-13268478.jpeg?auto=compress&cs=tinysrgb&w=600"
               //"https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/" +
               CDN_URL+cloudinaryImageId
            }/>
             
              <h3 className=" font-bold p-4 text-lg text-yellow-800 ">{name}</h3>
              <h4 className="text-md p-2">{cuisines}</h4>
              <p className="location">{areaName}</p>
              <h4 className="text-md p-2">{costForTwo} </h4>
              <h4 className="text-md p-2">{deliveryTime} Minutes</h4>
              <h3 className="text-md p-2">{avgRating} stars</h3>
          {/*    <h4>4.4 stars</h4>
             <h4>38 minutes</h4>
 */}           
   
          </div>

      )
  }


 export const withPromotedLabel=(RestaurantCard)=>{
    return(props)=>{
      return(
        <div>
          <label className='absolute'> Open</label>
          <RestaurantCard {...props}/>
        </div>

      )

    }
  }
  export default RestaurantCard