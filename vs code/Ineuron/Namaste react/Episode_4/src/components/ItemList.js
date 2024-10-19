


import { CDN_URL } from '../utils/constants';

// const ItemList = ({items}) => {
//     console.log("itemList",items)
//     console.log(CDN_URL)
//   return (
//     <div>
//            {
//             items.map((item) =>(
//             <div key={item.card.info.id}  
//             className=' p-2 m-2 border-green-800 border-b-2 text-left flex justify-between'>
//                 <div className='py-2'>
                
//                 <span>   {item.card.info.name}</span>
//                 <span>  Rs : {item.card.info.price?item.card.info.price/100:item.card.info.defaultPrice/100}</span>
//                 </div>
//                 <p className='text-xs'> {item.card.info.description}</p>
//                <div className='w-3/12 p-4'>
//                <img src={CDN_URL+item.card.info.imageId}
//                  className='w-full
//                  '/>
//                </div>
//             </div>  
//             ))
//            }       
//     </div>
//   )
// }

// export default ItemList


// import { IMG_CDN_URL } from "../../../../public/common/constants";
// import { MdStarRate } from "react-icons/md";

const ItemList = ({ items }) => {
  // console.log("iteam listt")
  // console.log("useContext",useContext)
  return (
    <div>
      {items.map((item) => {
        const { id, name, price, defaultPrice, ratings, imageId, description } =
          item.card.info;
        const avgRatingString = ratings?.aggregatedRating?.rating || 3.8;

        return (
          <div
            key={id}  
            className="flex justify-between items-center gap-[50px] py-[20px] border-b border-[#5b5b5b]"
          >
            <div className="flex flex-col gap-[5px] w-[75%]">
              <h2 className="text-[20px] font-bold text-gray-700">{name}</h2>
              <h4 className="font-semibold text-gray-700">
                ₹{price / 100 || defaultPrice / 100}
              </h4>
              <p className="text-gray-600">
                {(description && description.slice(0, 140)) || "Dummy Data"}
              </p>
              <h4 className="flex font-semibold">
               
                <span className="text-[#484747]">
                  {avgRatingString} (
                  {ratings?.aggregatedRating?.ratingCountV2 || 6})
                </span>
              </h4>
            </div>

            <div className="flex flex-col items-center justify-center">
              <img
                className="w-[150px] h-[100px] object-cover rounded-[8px]"
                src={CDN_URL + imageId}
                alt={name}
              />
              <button className="text-green-600 bg-white font-semibold rounded-md text-[1.2rem] px-[30px] py-[5px] cursor-pointer border-none relative bottom-[15px] hover:bg-gray-300 hover:text-green-800 transition-all 0.3s">
                ADD
              </button>
            </div>
          </div>
        );
      })}
    </div>
  );
};

export default ItemList;
