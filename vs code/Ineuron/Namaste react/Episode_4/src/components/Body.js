import RestaurantCard ,{withPromotedLabel}from "./RestaurantCard"
import{ useContext, useState} from "react"
import {useEffect} from "react"
// restaurantList from "../utils/mockData"
import Shimmer from "./Shimmer"
import UserContext from "../utils/UserContext"
import { Link } from "react-router-dom"
import useOnlineStatus from "../utils/useOnlineStatus"


let listjson=[]
const Body=()=>{   
              const { loggedInUser, setUserInfo} = useContext(UserContext);
  


 const onlineStatus=useOnlineStatus()
  console.log("online status ",onlineStatus)
  if(!onlineStatus){
    return(
<h1>Loading... laxman wait</h1>
    )
  }

   console.log("begin")
  // const [ListOfRestaurants]=useState(...listOfRestaurants)

//   const [ListOfRestaurants]=useState(  [
//     {info: {
//       id: "10894",
//       name: "Pizza Hut",
//       cloudinaryImageId: "2b4f62d606d1b2bfba9ba9e5386fabb7",
//       locality: "2nd Stage",
//       areaName: "BTM Layout",
//       costForTwo: "₹350 for two",
//       cuisines: ["Pizzas"],
//       avgRating: 4.5,
//       parentId: "721",
//       avgRatingString: "4.1",
//       totalRatingsString: "10K+",
//       deliveryTime: 31,
//     },
//   }, 
//   {info: {
//     id: "10894",
//     name: "Pizza Hut",
//     cloudinaryImageId: "2b4f62d606d1b2bfba9ba9e5386fabb7",
//     locality: "2nd Stage",
//     areaName: "BTM Layout",
//     costForTwo: "₹350 for two",
//     cuisines: ["Pizzas"],
//     avgRating: 3.8,
//     parentId: "721",
//     avgRatingString: "4.1",
//     totalRatingsString: "10K+",
//     deliveryTime: 31,
//   },
// }

//   ]
//  )
  let listOfRestaurants=[
   {info: {
      id: "10894",
      name: "Pizza Hut",
      cloudinaryImageId: "2b4f62d606d1b2bfba9ba9e5386fabb7",
      locality: "2nd Stage",
      areaName: "BTM Layout",
      costForTwo: "₹350 for two",
      cuisines: ["Pizzas"],
      avgRating: 4.5,
      parentId: "721",
      avgRatingString: "4.1",
      totalRatingsString: "10K+",
      deliveryTime: 31,
    },
  }, 
  {info: {
    id: "10894",
    name: "Pizza Hut",
    cloudinaryImageId: "2b4f62d606d1b2bfba9ba9e5386fabb7",
    locality: "2nd Stage",
    areaName: "BTM Layout",
    costForTwo: "₹350 for two",
    cuisines: ["Pizzas"],
    avgRating: 3.8,
    parentId: "721",
    avgRatingString: "4.1",
    totalRatingsString: "10K+",
    deliveryTime: 31,
  },
}
    ]
    const [ListOfRestaurants,setListOfRestaurants]=useState(
[])
      // const fetchData = async () => {
      //   const data = await fetch( 
      //     //"https://cors-anywhere.herokuapp.com/https://www.swiggy.com/dapi/restaurants/list/v5?lat=27.8973944&lng=78.0880129&page_type=DESKTOP_WEB_LISTING"

      //      "https://www.swiggy.com/dapi/restaurants/list/v5?lat=27.8973944&lng=78.0880129&page_type=DESKTOP_WEB_LISTING"
      //   );
      //   const json = await data.json();
      //   console.log("json here");
      //   console.log(json)
      //  // setRestaurants(json?.data?.cards || []); // Assuming the restaurants are inside the 'cards' field
      // };
      //  useEffect(()=>{
      //   console.log("lax in use effect")
      //   fetchData()
      //   console.log("after use efftct")
      // },[])

      const fetchData = async () => {
        try {
          const response = await fetch(
          //"  https://www.swiggy.com/dapi/restaurants/list/v5?lat=12.9715987&lng=77.5945627&is-seo-homepage-enabled=true&page_type=DESKTOP_WEB_LISTING"
          "https://www.swiggy.com/dapi/restaurants/list/v5?lat=12.9715987&lng=77.5945627&is-seo-homepage-enabled=true&page_type=DESKTOP_WEB_LISTING"
             //"https://www.swiggy.com/dapi/restaurants/list/v5?lat=27.8973944&lng=78.0880129&page_type=DESKTOP_WEB_LISTING"
            // Uncomment the line below to test with a CORS proxy
            // "https://cors-anywhere.herokuapp.com/https://www.swiggy.com/dapi/restaurants/list/v5?lat=27.8973944&lng=78.0880129&page_type=DESKTOP_WEB_LISTING"
          );
    
          // Check if the response is okay (status in the range 200-299)
          if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
          }
    
          const json = await response.json();
          console.log("json here from fetch function", json);
      //    setListOfRestaurants(json.data.cards[2].data.data.cards)
      console.log("loki here")
      //console.log(json.data.card.card.gridElements.infoWithStyle.restaurants)
      console.log("first")
      //console.log(json.data.cards[1].card.card.gridElements.infoWithStyle.restaurants)  
        //listjson= json.data.cards[4].card.card.gridElements.infoWithStyle.restaurants
      //listjson1=listjson
      
      console.log(listjson)
     // setListOfRestaurants(listjson) 
      listjson=json.data.cards[1].card.card.gridElements.infoWithStyle.restaurants
      console.log(listjson)
      setListOfRestaurants(listjson)

      //console.log(json.data.cards[2].data.data.cards) 
          console.log("after set restaurants")
          // setRestaurants(json?.data?.cards || []); // Assuming the restaurants are inside the 'cards' field
    
        } catch (error) {
          console.error("Error fetching data:", error);
        }
      };
    
      useEffect(() => {
        console.log("lax in use effect");
        fetchData();
        console.log("after use effect");
      }, []);
    
      console.log("body render" )
      console.log(listjson)
  
      const[searchText,setsearchText]=useState("")

      if(ListOfRestaurants.length==0){
        return(
          <div>
            <Shimmer/>
             {/* <h1>  Loading...   laxman wait</h1> */}
            </div>
        )
      }
      


      const  RestaurantCardPromoted=withPromotedLabel(RestaurantCard)
      /* 
        just to know useState

        const arr=useState(restaurantList)
        const[listOfRestaurants,setListOfRestaurants]=arr
        //
        const listOfRestaurants=arr[0]
        const setListofRestaurants=arr[1]
      */
    return(
        <div className="body  justify-center">

          <div className="filter  flex">
              <div className="search m-4 p-4">
                <input type="text" placeholder="Search for restaurants"  className="search-box  border border-solid border-black" value={searchText} 
                 onChange={(e)=>{

                  console.log(e.target.value)
                  setsearchText(e.target.value)
                  
                  const filteredList=listjson.filter(
                    (res)=>res.info.name.toLowerCase().includes(e.target.value.toLowerCase())
                  )
                  if(filteredList.length==0){
                    obj={info:{
                      name: "no results",
                      id: 001,
                    }
                      
                    }
                    setListOfRestaurants([obj])
                    //return<h1>No restauratns</h1>
                  }
                 else{setListOfRestaurants(filteredList)}  

                  console.log("listjson in body filter")
                  console.log(listjson)

                  const filteredList1= listjson.filter(
                    (res)=>res.info.name.toLowerCase().includes(e.target.value.toLowerCase())
                  )

                  
                  console.log("filterLiat1 here ")

                  console.log(filteredList1)
                    // ListOfRestaurants= ListOfRestaurants.filter((res)=>res.info.name.toLowerCase().includes(e.target.value.toLowerCase()))
                    //  console.log(ListOfRestaurants)
                  //console.log(e.target.value)
                  //console.log(filteredList)

                 }}
                 />
              <button
              className=" px-4 py-2 bg-green-100 m-4"
              
              >Search</button>
              <input type="text" placeholder="use context" value={loggedInUser} onChange={(e)=>setUserInfo(e.target.value)}/>
              </div>
              <div className="search m-4 p-4">
              <button  className="filter-btn  justify-items-center   m-4 px-4 py-2  bg-green-500 rounded-lg" 
              onClick={()=>{
                console.log("clicked")
                const filteredList=restaurantList.filter(
                  (res)=>res.info.avgRating>4.5
                )
                setListOfRestaurants(filteredList) 
 
                // ListOfRestaurants= ListOfRestaurants.filter((res)=>res.info.avgRating>4)
                //  console.log(ListOfRestaurants)
              }}>Top Rated Restaurat</button>
            </div>
               
          </div>
            {/*  <div className="search">Search</div>*/}
            
            <div className="res-container  flex flex-wrap  justify-center">
             
            {ListOfRestaurants.map((restaurant) => (
          <Link to={"/restaurants/"+restaurant.info.id}
             key={restaurant.info.id}
           > 

{restaurant.info.isOpen?(<RestaurantCardPromoted restaurantData={restaurant}/>):(<RestaurantCard
          restaurantData={restaurant}
          />)}
          
          </Link>
        ))}
              {/* {
                restaurantList.map((res) =>(
                   <RestaurantCard   key={res.info.id} resData={res}/>)

                
              )} */}
          
<div>
  {/*                 <RestaurantCard  
                resName="Meghana Foods"
                cuisine="Biryani, North Indian, Asian"
                 />
                
                <RestaurantCard 
                resName="KFC" 
                cuisine="Burger,Fast Food"
                />
 */} 
 </div>            
                
             
           
                {/* 33 */}
            </div>

        </div>

    )
}
export default Body 
/*  
{
  "id": "3478898",
  "imageId": "MERCHANDISING_BANNERS/IMAGES/MERCH/2024/10/9/e533c57f-312d-4afd-a4d8-0cf8e866239e_Image20241008221057172.png",
  "action": {
    "link": "https://www.swiggy.com/collections/129839?collection_id=129839&header_title=Vrat+Specials&tags=layout_crazydeal_dosas&type=rcv2",
    "text": "Navratri Specials",
    "type": "WEBLINK"
  },
  "entityType": "BANNER",
  "accessibility": {
    "altText": "restaurants curated festival",
    "altTextCta": "open"
  },
  "entityId": "swiggy://collectionV2?collection_id=129839&tags=layout_crazydeal_dosas&header_title=Vrat%20Specials",
  "frequencyCapping": {
    
  },
  "externalMarketing": {
    
  },
  "description": "Navratri Specials"
},
  "info": [
                  {
                    "id": "3478898",
                    "imageId": "MERCHANDISING_BANNERS/IMAGES/MERCH/2024/10/9/e533c57f-312d-4afd-a4d8-0cf8e866239e_Image20241008221057172.png",
                    "action": {
                      "link": "https://www.swiggy.com/collections/129839?collection_id=129839&header_title=Vrat+Specials&tags=layout_crazydeal_dosas&type=rcv2",
                      "text": "Navratri Specials",
                      "type": "WEBLINK"
                    },
                    "entityType": "BANNER",
                    "accessibility": {
                      "altText": "restaurants curated festival",
                      "altTextCta": "open"
                    },
                    "entityId": "swiggy://collectionV2?collection_id=129839&tags=layout_crazydeal_dosas&header_title=Vrat%20Specials",
                    "frequencyCapping": {
                      
                    },
                    "externalMarketing": {
                      
                    },
                    "description": "Navratri Specials"
                  },
                  {
                    "id": "750579",
                    "imageId": "MERCHANDISING_BANNERS/IMAGES/MERCH/2024/7/2/6ef07bda-b707-48ea-9b14-2594071593d1_Pizzas.png",
                    "action": {
                      "link": "https://www.swiggy.com/collections/83631?collection_id=83631&search_context=pizza&tags=layout_CCS_Pizza&type=rcv2",
                      "text": "Pizzas",
                      "type": "WEBLINK"
                    },
                    "entityType": "BANNER",
                    "accessibility": {
                      "altText": "restaurants curated for pizza",
                      "altTextCta": "open"
                    },
                    "entityId": "swiggy://collectionV2?collection_id=83631&tags=layout_CCS_Pizza&search_context=pizza",
                    "frequencyCapping": {
                      
                    },
                    "externalMarketing": {
                      
                    },
                    "description": "Pizzas"
                  },
                  {
                    "id": "750589",
                    "imageId": "MERCHANDISING_BANNERS/IMAGES/MERCH/2024/7/2/8f508de7-e0ac-4ba8-b54d-def9db98959e_burger.png",
                    "action": {
                      "link": "https://www.swiggy.com/collections/83637?collection_id=83637&search_context=burger&tags=layout_CCS_Burger&type=rcv2",
                      "text": "Burgers",
                      "type": "WEBLINK"
                    },
                    "entityType": "BANNER",
                    "accessibility": {
                      "altText": "restaurants curated for burger",
                      "altTextCta": "open"
                    },
                    "entityId": "swiggy://collectionV2?collection_id=83637&tags=layout_CCS_Burger&search_context=burger",
                    "frequencyCapping": {
                      
                    },
                    "externalMarketing": {
                      
                    },
                    "description": "Burgers"
                  },
                  {
                    "id": "750591",
                    "imageId": "MERCHANDISING_BANNERS/IMAGES/MERCH/2024/7/2/6ef07bda-b707-48ea-9b14-2594071593d1_Biryani.png",
                    "action": {
                      "link": "https://www.swiggy.com/collections/83639?collection_id=83639&search_context=biryani&tags=layout_CCS_Biryani&type=rcv2",
                      "text": "Biryani",
                      "type": "WEBLINK"
                    },
                    "entityType": "BANNER",
                    "accessibility": {
                      "altText": "restaurants curated for biryani",
                      "altTextCta": "open"
                    },
                    "entityId": "swiggy://collectionV2?collection_id=83639&tags=layout_CCS_Biryani&search_context=biryani",
                    "frequencyCapping": {
                      
                    },
                    "externalMarketing": {
                      
                    },
                    "description": "Biryani"
                  },
                  {
                    "id": "750222",
                    "imageId": "MERCHANDISING_BANNERS/IMAGES/MERCH/2024/7/17/58760e8e-324f-479e-88fa-31800120ea38_Rolls1.png",
                    "action": {
                      "link": "https://www.swiggy.com/collections/83669?collection_id=83669&tags=layout_CCS_Rolls&type=rcv2",
                      "text": "Rolls",
                      "type": "WEBLINK"
                    },
                    "entityType": "BANNER",
                    "accessibility": {
                      "altText": "restaurants curated for roll",
                      "altTextCta": "open"
                    },
                    "entityId": "swiggy://collectionV2?collection_id=83669&tags=layout_CCS_Rolls",
                    "frequencyCapping": {
                      
                    },
                    "externalMarketing": {
                      
                    },
                    "description": "Rolls"
                  },
                  {
                    "id": "749772",
                    "imageId": "MERCHANDISING_BANNERS/IMAGES/MERCH/2024/7/2/6ef07bda-b707-48ea-9b14-2594071593d1_Noodles.png",
                    "action": {
                      "link": "https://www.swiggy.com/collections/80463?collection_id=80463&tags=layout_BAU_Contextual%2Cnoodles&type=rcv2",
                      "text": "Noodles",
                      "type": "WEBLINK"
                    },
                    "entityType": "BANNER",
                    "accessibility": {
                      "altText": "restaurant curated for noodles",
                      "altTextCta": "open"
                    },
                    "entityId": "80463",
                    "frequencyCapping": {
                      
                    },
                    "externalMarketing": {
                      
                    },
                    "description": "Noodles"
                  },
                  {
                    "id": "750216",
                    "imageId": "MERCHANDISING_BANNERS/IMAGES/MERCH/2024/7/2/8f508de7-e0ac-4ba8-b54d-def9db98959e_Pav Bhaji.png",
                    "action": {
                      "link": "https://www.swiggy.com/collections/80362?collection_id=80362&tags=layout_PavBhaji_Contextual&type=rcv2",
                      "text": "Pav Bhaji",
                      "type": "WEBLINK"
                    },
                    "entityType": "BANNER",
                    "accessibility": {
                      "altText": "restaurant curated for pav bhaji",
                      "altTextCta": "open"
                    },
                    "entityId": "swiggy://collectionV2?collection_id=80362&tags=layout_PavBhaji_Contextual",
                    "frequencyCapping": {
                      
                    },
                    "externalMarketing": {
                      
                    },
                    "description": "Pav Bhaji"
                  },
                  {
                    "id": "750571",
                    "imageId": "MERCHANDISING_BANNERS/IMAGES/MERCH/2024/7/2/8f508de7-e0ac-4ba8-b54d-def9db98959e_Pure Veg.png",
                    "action": {
                      "link": "https://www.swiggy.com/collections/80435?collection_id=80435&tags=layout_CCS_PureVeg&type=rcv2",
                      "text": "Pure Veg",
                      "type": "WEBLINK"
                    },
                    "entityType": "BANNER",
                    "accessibility": {
                      "altText": "restaurants curated for veg",
                      "altTextCta": "open"
                    },
                    "entityId": "swiggy://collectionV2?collection_id=80435&tags=layout_CCS_PureVeg",
                    "frequencyCapping": {
                      
                    },
                    "externalMarketing": {
                      
                    },
                    "description": "Pure Veg"
                  },
                  {
                    "id": "749876",
                    "imageId": "MERCHANDISING_BANNERS/IMAGES/MERCH/2024/7/2/8f508de7-e0ac-4ba8-b54d-def9db98959e_chole bhature.png",
                    "action": {
                      "link": "https://www.swiggy.com/collections/80382?collection_id=80382&tags=layout_CCS_CholeBhature&type=rcv2",
                      "text": "Chole Bhature",
                      "type": "WEBLINK"
                    },
                    "entityType": "BANNER",
                    "accessibility": {
                      "altText": "restaurant curated for chhole bhatoore",
                      "altTextCta": "open"
                    },
                    "entityId": "swiggy://collectionV2?collection_id=80382&tags=layout_CCS_CholeBhature",
                    "frequencyCapping": {
                      
                    },
                    "externalMarketing": {
                      
                    },
                    "description": "Chole Bhature"
                  },
                  {
                    "id": "749762",
                    "imageId": "MERCHANDISING_BANNERS/IMAGES/MERCH/2024/7/2/3f2c40d3-96c7-44ce-8b35-aef6ea746cdc_lassi.png",
                    "action": {
                      "link": "https://www.swiggy.com/collections/80458?collection_id=80458&tags=layout_BAU_Contextual%2Classi&type=rcv2",
                      "text": "Lassi",
                      "type": "WEBLINK"
                    },
                    "entityType": "BANNER",
                    "accessibility": {
                      "altText": "restaurant curated for lassi",
                      "altTextCta": "open"
                    },
                    "entityId": "80458",
                    "frequencyCapping": {
                      
                    },
                    "externalMarketing": {
                      
                    },
                    "description": "Lassi"
                  },
                  {
                    "id": "749984",
                    "imageId": "MERCHANDISING_BANNERS/IMAGES/MERCH/2024/7/2/8f508de7-e0ac-4ba8-b54d-def9db98959e_coffee.png",
                    "action": {
                      "link": "https://www.swiggy.com/collections/83659?collection_id=83659&tags=layout_CCS_Coffee&type=rcv2",
                      "text": "Coffee",
                      "type": "WEBLINK"
                    },
                    "entityType": "BANNER",
                    "accessibility": {
                      "altText": "restaurants curated for coffee",
                      "altTextCta": "open"
                    },
                    "entityId": "swiggy://collectionV2?collection_id=83659&tags=layout_CCS_Coffee",
                    "frequencyCapping": {
                      
                    },
                    "externalMarketing": {
                      
                    },
                    "description": "Coffee"
                  },
                  {
                    "id": "750107",
                    "imageId": "MERCHANDISING_BANNERS/IMAGES/MERCH/2024/7/2/6ef07bda-b707-48ea-9b14-2594071593d1_Desserts.png",
                    "action": {
                      "link": "https://www.swiggy.com/collections/83661?collection_id=83661&search_context=desserts&tags=layout_CCS_Desserts&type=rcv2",
                      "text": "Dessert",
                      "type": "WEBLINK"
                    },
                    "entityType": "BANNER",
                    "accessibility": {
                      "altText": "restaurant curated for dessert",
                      "altTextCta": "open"
                    },
                    "entityId": "swiggy://collectionV2?collection_id=83661&tags=layout_CCS_Desserts&search_context=desserts",
                    "frequencyCapping": {
                      
                    },
                    "externalMarketing": {
                      
                    },
                    "description": "Dessert"
                  },
                  {
                    "id": "749786",
                    "imageId": "MERCHANDISING_BANNERS/IMAGES/MERCH/2024/7/2/6ef07bda-b707-48ea-9b14-2594071593d1_Omelette.png",
                    "action": {
                      "link": "https://www.swiggy.com/collections/80467?collection_id=80467&tags=layout_BAU_Contextual%2Comelette&type=rcv2",
                      "text": "Omelette",
                      "type": "WEBLINK"
                    },
                    "entityType": "BANNER",
                    "accessibility": {
                      "altText": "restaurant curated for omelette",
                      "altTextCta": "open"
                    },
                    "entityId": "80467",
                    "frequencyCapping": {
                      
                    },
                    "externalMarketing": {
                      
                    },
                    "description": "Omelette"
                  },
                  {
                    "id": "750234",
                    "imageId": "MERCHANDISING_BANNERS/IMAGES/MERCH/2024/7/2/6ef07bda-b707-48ea-9b14-2594071593d1_Poori.png",
                    "action": {
                      "link": "https://www.swiggy.com/collections/80377?collection_id=80377&tags=layout_BAU_Contextual%2Cpoori&type=rcv2",
                      "text": "Poori",
                      "type": "WEBLINK"
                    },
                    "entityType": "BANNER",
                    "accessibility": {
                      "altText": "restaurant curated for poori",
                      "altTextCta": "open"
                    },
                    "entityId": "80377",
                    "frequencyCapping": {
                      
                    },
                    "externalMarketing": {
                      
                    },
                    "description": "Poori"
                  },
                  {
                    "id": "750079",
                    "imageId": "MERCHANDISING_BANNERS/IMAGES/MERCH/2024/7/2/8f508de7-e0ac-4ba8-b54d-def9db98959e_cutlet.png",
                    "action": {
                      "link": "https://www.swiggy.com/collections/80414?collection_id=80414&tags=layout_BAU_Contextual%2Ccutlet&type=rcv2",
                      "text": "Cutlet",
                      "type": "WEBLINK"
                    },
                    "entityType": "BANNER",
                    "accessibility": {
                      "altText": "restaurant curated for cutlet",
                      "altTextCta": "open"
                    },
                    "entityId": "80414",
                    "frequencyCapping": {
                      
                    },
                    "externalMarketing": {
                      
                    },
                    "description": "Cutlet"
                  }
                ],


*/ 