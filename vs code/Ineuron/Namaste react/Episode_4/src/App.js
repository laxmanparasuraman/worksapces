import React, { lazy, Suspense, useEffect, useState,useContext } from 'react';
import ReactDOM from 'react-dom/client';
 import Header from './components/Header';
import Body from './components/Body';
import { createBrowserRouter ,Outlet,RouterProvider} from 'react-router-dom';
import About from './components/About'; 
import Contact from './components/Contact';
import Error from './components/Error';
import RestaurantMenu from './components/RestaurantMenu';
import UserContext from './utils/UserContext';
//import Grocery from './components/Grocery';
const root=ReactDOM.createRoot(document.getElementById("root"))

/* 
 chunking 
 code spliting
 Dynamic Bundling
 lay loading
 on demandloading
 dynamic import
*/
const Grocery=lazy(()=> import("./components/Grocery"))

// const styleCard={
//     backgroundColor:"#f0f0f0",
// }
// const RestaurantCard=(props)=>{
//   console.log("props here")
//   console.log(props)
//   const { restaurantData } = props;
//   console.log("resData")
//   console.log(restaurantData)
   

    
    
//     const{cloudinaryImageId,
//       name,
//       areaName,
//       avgRating,
//       cuisines,
//       costForTwo,
//       deliveryTime,}=restaurantData?.info;
    
//     return(
//         <div className="res-card" style={styleCard}> 
//            <img  className="res-logo"
//            alt ="res logo"
//            src={
//             "https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/" +
//             cloudinaryImageId
//           }/>
           
//             <h3>{name}</h3>
//             <h4>{cuisines}</h4>
//             <p className="location">{areaName}</p>
//             <h4>{costForTwo}</h4>
//             <h4>{deliveryTime} mins</h4>
//             <h3>{avgRating}</h3>
//            <h4>4.4 stars</h4>
//            <h4>38 minutes</h4>
         
//         </div>
//     )
// }
/*   it is copied for ref */
// const RestaurantCardl= (props) => {
//   const { restaurantData } = props;

//   const {
//     cloudinaryImageId,
//     name,
//     areaName,
//     avgRating,
//     cuisines,
//     costForTwo,
//     deliveryTime,
//   } = restaurantData?.info;

//   return (
//     <div className="restaurant-card">
//       <img
//         src={
//           "https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/" +
//           cloudinaryImageId
//         }
//         alt={name}
//         className="restaurant-logo"
//       />
//       <div className="restaurant-details">
//         <h3 className="restaurant-name">
//           {name.slice(0, 22)}
//           {name.length > 22 ? "..." : ""}
//         </h3>
//         <div className="esa-rating">
//           <h4 className="rating">
//             <MdStarRate className="rating-logo" />
//             <span>{avgRating}</span>
//           </h4>
//           <h4>{costForTwo}</h4>
//           <h4>{deliveryTime} mins</h4>
//         </div>
//         <p className="cousine">
//           {cuisines.join(", ").slice(0, 30)}
//           {cuisines.join(", ").length > 30 ? "..." : ""}
//         </p>
//         <p className="location">{areaName}</p>
//       </div>
//     </div>
//   );
// };



// const restaurantList = [
//   {
//     info: {
//       id: "10894",
//       name: "Pizza Hut",
//       cloudinaryImageId: "2b4f62d606d1b2bfba9ba9e5386fabb7",
//       locality: "2nd Stage",
//       areaName: "BTM Layout",
//       costForTwo: "₹350 for two",
//       cuisines: ["Pizzas"],
//       avgRating: 4.1,
//       parentId: "721",
//       avgRatingString: "4.1",
//       totalRatingsString: "10K+",
//       deliveryTime: 31,
//     },
//   },
//   {
//     info: {
//       id: "211192",
//       name: "La Pino'z Pizza",
//       cloudinaryImageId: "lczhp9lptdzbqn09nfns",
//       locality: "2nd Stage",
//       areaName: "BTM Layout",
//       costForTwo: "₹250 for two",
//       cuisines: ["Pizzas", "Pastas", "Italian", "Desserts", "Beverages"],
//       avgRating: 4,
//       parentId: "4961",
//       avgRatingString: "4.0",
//       totalRatingsString: "10K+",
//       deliveryTime: 28,
//     },
//   },
//   {
//     info: {
//       id: "477963",
//       name: "The Belgian Waffle Co.",
//       cloudinaryImageId: "5116a385bac0548e06c33c08350fbf11",
//       locality: "2nd Stage",
//       areaName: "BTM 2nd Stage",
//       costForTwo: "₹200 for two",
//       cuisines: ["Waffle", "Desserts", "Ice Cream"],
//       avgRating: 4.3,
//       veg: true,
//       parentId: "2233",
//       avgRatingString: "4.3",
//       totalRatingsString: "1K+",
//       deliveryTime: 32,
//     },
//   },
//   {
//     info: {
//       id: "23683",
//       name: "McDonald's",
//       cloudinaryImageId:
//         "RX_THUMBNAIL/IMAGES/VENDOR/2024/4/1/1c999aef-c166-496d-a9f1-8508e83e6d5a_23683.jpg",
//       locality: "2nd Stage",
//       areaName: "Btm Layout",
//       costForTwo: "₹400 for two",
//       cuisines: ["Burgers", "Beverages", "Cafe", "Desserts"],
//       avgRating: 4.2,
//       parentId: "630",
//       avgRatingString: "4.2",
//       totalRatingsString: "10K+",
//       deliveryTime: 28,
//     },
//   },
//   {
//     info: {
//       id: "255038",
//       name: "Andhra Gunpowder",
//       cloudinaryImageId: "e996wruqpmrrrqglp7hs",
//       locality: "NS Palya",
//       areaName: "Btm Layout",
//       costForTwo: "₹350 for two",
//       cuisines: ["Andhra", "Biryani", "South Indian"],
//       avgRating: 4.3,
//       parentId: "10496",
//       avgRatingString: "4.3",
//       totalRatingsString: "5K+",
//       deliveryTime: 29,
//     },
//   },
//   {
//     info: {
//       id: "240178",
//       name: "Leon's - Burgers & Wings (Leon Grill)",
//       cloudinaryImageId:
//         "RX_THUMBNAIL/IMAGES/VENDOR/2024/5/2/4c1e29e2-fecf-41b6-8b21-5a58338247fe_240178.jpg",
//       locality: "Indiranagar",
//       areaName: "JP Nagar",
//       costForTwo: "₹300 for two",
//       cuisines: ["American", "Snacks", "Turkish", "Portuguese", "Continental"],
//       avgRating: 4.3,
//       parentId: "371281",
//       avgRatingString: "4.3",
//       totalRatingsString: "10K+",
//       deliveryTime: 39,
//     },
//   },
//   {
//     info: {
//       id: "290271",
//       name: "Thalairaj Biryani",
//       cloudinaryImageId: "qf8lwn0ehi8sgvjvsi2l",
//       locality: "5th Phase",
//       areaName: "JP Nagar",
//       costForTwo: "₹300 for two",
//       cuisines: [
//         "Andhra",
//         "Biryani",
//         "Hyderabadi",
//         "South Indian",
//         "Indian",
//         "Beverages",
//       ],
//       avgRating: 4.2,
//       parentId: "433875",
//       avgRatingString: "4.2",
//       totalRatingsString: "1K+",
//       deliveryTime: 35,
//     },
//   },
//   {
//     info: {
//       id: "17312",
//       name: "KFC",
//       cloudinaryImageId:
//         "RX_THUMBNAIL/IMAGES/VENDOR/2024/4/17/768a43ed-602d-4e08-b6ab-a2bf8f7d3e33_17312.JPG",
//       locality: "4th Phase",
//       areaName: "JP Nagar",
//       costForTwo: "₹400 for two",
//       cuisines: ["Burgers", "Fast Food", "Rolls & Wraps"],
//       avgRating: 4.1,
//       parentId: "547",
//       avgRatingString: "4.1",
//       totalRatingsString: "10K+",
//       deliveryTime: 27,
//     },
//   },
//   {
//     info: {
//       id: "49704",
//       name: "California Burrito",
//       cloudinaryImageId: "p57honbbzdgf7tyt2vay",
//       locality: "5th Phase",
//       areaName: "JP Nagar",
//       costForTwo: "₹250 for two",
//       cuisines: [
//         "Mexican",
//         "American",
//         "Salads",
//         "Continental",
//         "Keto",
//         "Healthy Food",
//         "Desserts",
//       ],
//       avgRating: 4.5,
//       parentId: "1252",
//       avgRatingString: "4.5",
//       totalRatingsString: "10K+",
//       deliveryTime: 35,
//     },
//   },
//   {
//     info: {
//       id: "246645",
//       name: "Great Indian Khichdi by EatFit",
//       cloudinaryImageId: "6e44fd7f1e5cd9967edfe47c10247671",
//       locality: "2nd Stage",
//       areaName: "BTM Layout",
//       costForTwo: "₹200 for two",
//       cuisines: [
//         "Home Food",
//         "Indian",
//         "North Indian",
//         "Healthy Food",
//         "Snacks",
//         "Desserts",
//         "Rajasthani",
//         "South Indian",
//         "Maharashtrian",
//         "Sweets",
//       ],
//       avgRating: 4.2,
//       parentId: "319582",
//       avgRatingString: "4.2",
//       totalRatingsString: "1K+",
//       deliveryTime: 29,
//     },
//   },
//   {
//     info: {
//       id: "643652",
//       name: "WeFit - Protein Bowls, Salads & Sandwiches",
//       cloudinaryImageId:
//         "RX_THUMBNAIL/IMAGES/VENDOR/2024/5/23/8162aab2-4ccd-431e-8163-ad18749b95f5_643652.JPG",
//       locality: "16TH MAIN",
//       areaName: "BTM",
//       costForTwo: "₹250 for two",
//       cuisines: ["Healthy Food", "Salads", "Keto", "Snacks"],
//       avgRating: 4.4,
//       parentId: "355285",
//       avgRatingString: "4.4",
//       totalRatingsString: "100+",
//       deliveryTime: 35,
//     },
//   },
//   {
//     info: {
//       id: "750212",
//       name: "Daily Kitchen - Homely Meals",
//       cloudinaryImageId:
//         "RX_THUMBNAIL/IMAGES/VENDOR/2024/5/19/4ec6a5b6-7c8d-4e10-b8a3-317922e419da_750212.JPG",
//       locality: "2nd stage",
//       areaName: "BTM Layout",
//       costForTwo: "₹400 for two",
//       cuisines: ["Home Food", "Indian", "North Indian", "Thalis"],
//       avgRating: 4.3,
//       parentId: "444382",
//       avgRatingString: "4.3",
//       totalRatingsString: "50+",
//       deliveryTime: 30,
//     },
//   },
//   {
//     info: {
//       id: "390045",
//       name: "NH1 Bowls - Highway To North",
//       cloudinaryImageId:
//         "RX_THUMBNAIL/IMAGES/VENDOR/2024/5/18/8dd09eab-b40e-43ed-b46d-c88f50e450a3_390045.JPG",
//       locality: "2nd stage",
//       areaName: "Btm Layout",
//       costForTwo: "₹250 for two",
//       cuisines: ["North Indian", "Punjabi", "Home Food"],
//       avgRating: 4.6,
//       parentId: "22452",
//       avgRatingString: "4.6",
//       totalRatingsString: "100+",
//       deliveryTime: 30,
//     },
//   },
//   {
//     info: {
//       id: "374525",
//       name: "Kwality Walls Frozen Dessert and Ice Cream Shop",
//       cloudinaryImageId: "npp2m7tuszixwcc69pqd",
//       locality: "2nd Stage",
//       areaName: "Btm Layout",
//       costForTwo: "₹300 for two",
//       cuisines: ["Desserts", "Ice Cream", "Ice Cream Cakes"],
//       avgRating: 4.6,
//       veg: true,
//       parentId: "582",
//       avgRatingString: "4.6",
//       totalRatingsString: "1K+",
//       deliveryTime: 20,
//     },
//   },
//   {
//     info: {
//       id: "758321",
//       name: "NIC Ice Creams",
//       cloudinaryImageId: "5bbe809ee274743ba5e09eab110cd813",
//       locality: "MICO Employees Grinirman",
//       areaName: "BTM layout",
//       costForTwo: "₹120 for two",
//       cuisines: ["Ice Cream", "Desserts"],
//       avgRating: 4.9,
//       veg: true,
//       parentId: "6249",
//       avgRatingString: "4.9",
//       totalRatingsString: "10+",
//       deliveryTime: 16,
//     },
//   },
//   {
//     info: {
//       id: "590119",
//       name: "Bakingo",
//       cloudinaryImageId:
//         "RX_THUMBNAIL/IMAGES/VENDOR/2024/4/24/11e95f9e-ba33-472c-85ae-ed6d5c289992_590119.JPG",
//       locality: "1st  Stage",
//       areaName: "BTM Layout",
//       costForTwo: "₹299 for two",
//       cuisines: ["Bakery", "Desserts", "Beverages", "Snacks"],
//       avgRating: 4.3,
//       parentId: "3818",
//       avgRatingString: "4.3",
//       totalRatingsString: "1K+",
//       deliveryTime: 27,
//     },
//   },
//   {
//     info: {
//       id: "399138",
//       name: "Aubree",
//       cloudinaryImageId: "65faa4b5046cb2215fe285a8b96c9bd7",
//       locality: "JP Nagar",
//       areaName: "JP Nagar",
//       costForTwo: "₹700 for two",
//       cuisines: ["Bakery", "Italian", "Snacks", "Desserts"],
//       avgRating: 4.5,
//       parentId: "3807",
//       avgRatingString: "4.5",
//       totalRatingsString: "1K+",
//       deliveryTime: 33,
//     },
//   },
//   {
//     info: {
//       id: "108097",
//       name: "Ambur Star Briyani Since 1890",
//       cloudinaryImageId: "yktanq9i7yfjrixaghuj",
//       locality: "2nd Stage",
//       areaName: "BTM Layout",
//       costForTwo: "₹500 for two",
//       cuisines: ["Biryani", "Chettinad", "Andhra", "Beverages", "Seafood"],
//       avgRating: 4.3,
//       parentId: "21400",
//       avgRatingString: "4.3",
//       totalRatingsString: "10K+",
//       deliveryTime: 21,
//     },
//   },
//   {
//     info: {
//       id: "622017",
//       name: "MOJO Pizza - 2X Toppings",
//       cloudinaryImageId:
//         "RX_THUMBNAIL/IMAGES/VENDOR/2024/5/20/0fbf3dd4-03fc-403e-b861-6d7455bcb69b_622017.JPG",
//       locality: "BTM Layout",
//       areaName: "Btm 2nd Stage",
//       costForTwo: "₹250 for two",
//       cuisines: ["Pizzas", "Italian", "Fast Food", "Desserts"],
//       avgRating: 4.5,
//       parentId: "11329",
//       avgRatingString: "4.5",
//       totalRatingsString: "500+",
//       deliveryTime: 35,
//     },
//   },
//   {
//     info: {
//       id: "558760",
//       name: "HRX by EatFit",
//       cloudinaryImageId: "d8d85afa5c5e92461d30ff2ca867a587",
//       locality: "2nd Stage",
//       areaName: "BTM Layout",
//       costForTwo: "₹450 for two",
//       cuisines: ["Healthy Food", "Salads", "Keto", "Pastas"],
//       avgRating: 4.3,
//       parentId: "335529",
//       avgRatingString: "4.3",
//       totalRatingsString: "100+",
//       deliveryTime: 35,
//     },
//   },
// ];
// const resObj={
//     "info": {
//       "id": "658210",
//       "name": "The Fusion Lounge",
//       "cloudinaryImageId": "fa4944f0cfdcbca2bec1f3ab8e3db3f7",
//       "locality": "Triloki nagar",
//       "areaName": "Railway Station",
//       "costForTwo": "₹300 for two",
//       "cuisines": [
//         "North Indian",
//         "South Indian",
//         "Chinese",
//         "Beverages",
//         "Fast Food",
//         "Desserts"
//       ],
//       "avgRating": 4.1,
//       "parentId": "395453",
//       "avgRatingString": "4.1",
//       "totalRatingsString": "264",
//       "sla": {
//         "deliveryTime": 58,
//         "lastMileTravel": 10.2,
//         "serviceability": "SERVICEABLE",
//         "slaString": "55-60 mins",
//         "lastMileTravelString": "10.2 km",
//         "iconType": "ICON_TYPE_EMPTY"
//       },
//       "availability": {
//         "nextCloseTime": "2024-10-05 23:00:00",
//         "opened": true
//       },
//       "badges": {
        
//       },
//       "isOpen": true,
//       "type": "F",
//       "badgesV2": {
//         "entityBadges": {
//           "imageBased": {
            
//           },
//           "textBased": {
            
//           },
//           "textExtendedBadges": {
            
//           }
//         }
//       },
//       "aggregatedDiscountInfoV3": {
//         "header": "10% OFF",
//         "subHeader": "UPTO ₹40"
//       },
//       "differentiatedUi": {
//         "displayType": "ADS_UI_DISPLAY_TYPE_ENUM_DEFAULT",
//         "differentiatedUiMediaDetails": {
//           "mediaType": "ADS_MEDIA_ENUM_IMAGE",
//           "lottie": {
            
//           },
//           "video": {
            
//           }
//         }
//       },
//       "reviewsSummary": {
        
//       },
//       "displayType": "RESTAURANT_DISPLAY_TYPE_DEFAULT",
//       "restaurantOfferPresentationInfo": {
        
//       },
//       "externalRatings": {
//         "aggregatedRating": {
//           "rating": "--"
//         }
//       },
//       "ratingsDisplayPreference": "RATINGS_DISPLAY_PREFERENCE_SHOW_SWIGGY"
//     },
//     "analytics": {
      
//     },
//     "cta": {
//       "link": "https://www.swiggy.com/city/chhindwara/the-fusion-lounge-triloki-nagar-railway-station-rest658210",
//       "type": "WEBLINK"
//     }
//   }


// const Body=()=>{
//     return(
//         <div className="body">
//             <div className="search">Search</div>
//             <div className="res-container">
             
//             {restaurantList.map((restaurant) => (
//           <RestaurantCard
//             key={restaurant.info.id}
//             restaurantData={restaurant}
//           />
//         ))}
//               {/* {
//                 restaurantList.map((res) =>(
//                    <RestaurantCard   key={res.info.id} resData={res}/>)

                
//               )} */}
          
// <div>
//   {/*                 <RestaurantCard  
//                 resName="Meghana Foods"
//                 cuisine="Biryani, North Indian, Asian"
//                  />
                
//                 <RestaurantCard 
//                 resName="KFC" 
//                 cuisine="Burger,Fast Food"
//                 />
//  */} 
//  </div>            
                
             
           
//                 {/* 33 */}
//             </div>

//         </div>

//     )
// } 

const AppLayout=()=>{

    const [userInfo,setUserInfo]=useState()
    useEffect(()=>{
        const data={
            name:"laxman from provider"
        }
        setUserInfo(data.name)
    },[])
    return (
            <div className="app">
        <UserContext.Provider value={{loggedInUser:userInfo,setUserInfo}}>

            <Header/>
            <Outlet/>
        </UserContext.Provider>
            {/* if path=/ */}
           {/*  <Body/>  */}
            {/*  */}


            {/* <h1>Hello World</h1>
            <p>This is my first react app now</p> */}
        </div>
    )
}

const appRouter=createBrowserRouter([
    {
        path: '/',
        element:<AppLayout/>,

        children: [
            {
                path: '/',
                element: <Body/> 
            },

            
    {
        path: '/about',
        element:<About/>
    },
    {
        path: '/contact',
        element:<Contact/>
    },//
    {
        path:"/restaurants/:resId",
        element:<RestaurantMenu/>
    },  {
        path:"/Grocery",
        element: <Suspense fallback={<h>fallback from suspens</h>}><Grocery/></Suspense>
    }


        ],

        errorElement:<Error/>,
        // element: () => <AppLayout />,  // you can also use a function component as an element. this will allow you to pass props to the component dynamically. For example:
        /* or 
         element :<AppLayout/>
         */

    },

])
// root.render(<AppLayout />)
// root.render(<RestaurantCard/>) 
root.render(<RouterProvider router={appRouter}/>)

















/* 
/* react create element gives object and after render it giveas a html onject */

// const parent = React.createElement("div",{id :"parent"},"react is live   check live changes")
// console.log(parent)



// /*  */
// const jsx=<h1> This jsx form react</h1>
// const root=ReactDOM.createRoot(document.getElementById("root"));
// console.log(jsx)
// root.render(jsx)

// /* jsx (transpiled before it reaches the js )-parecel - babel  

// jsx =>react.createElement=>react elemnt javascript=>html render
// */


// //  React functional components
// const HeadingComponent=()=>(   
//     <h1>React functional component</h1>
// )

//  // renderin
// root.render(<HeadingComponent/>)
// // componenbt compostions
// const ComponentComposition=()=>(
//     <div>
//         <HeadingComponent/>
//         <p>This is a componet compostion</p>
//     </div>
// )
// root.render(<ComponentComposition/>)
// const js=(<h1>js here</h1>)

// //  javascript inside  jsx component and jsx  elemnt in jsx component
// const JavaScriptInsideJsxComponent=()=>(
//     <div>
//         <ComponentComposition/>
       
//         <p>This is a componet compostion with javascript inside</p>
//         <h2>{`Hello HERE WE USE JS IN { }  AND STRING LITEREAL , ${new Date().toLocaleTimeString()}`}</h2>
//     </div>
// )


// // in react element that has react compnent and js in{}

// const reactElementInComponent=(
//     <div>
//     <h1>reactElementInComponent   is the name of name of tghe elemnt</h1>
//      {console.log(JavaScriptInsideJsxComponent)} 
//      <JavaScriptInsideJsxComponent/>
// <h1>

//           use function is  js  and use that in react elemnt and  in js  like functio() {}
//      </h1>

//      {HeadingComponent()}
//      </div>

// )


// //test
// const Rend=()=>{
//     return (<h1>render is now </h1>)
// }
// //const root = ReactDOM.createRoot(document.getElementById('root')); // 'ReactDOM' is now correctly spelled
// root.render(<Rend/>);
// root.render(reactElementInComponent)


/* 




   header 
    -logo
    -NavItems
   Body 
     _search
     -restaraunt
     -restarauntcard
Footer
    -copyright
    -link 
    addrs 
    contact

*/

//1.20 zeb