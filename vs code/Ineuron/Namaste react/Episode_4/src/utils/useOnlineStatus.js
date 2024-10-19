// import React, { useEffect, useState } from 'react'

// const useOnlineStatus = () => {

//     const [onlineStatus,setOnlineStatus]=useState(true)
// useEffect(() =>{

//     window.addEventListener("offline",()=>{
//     return setOnlineStatus(false)
// })

// window.addEventListener("online",()=>{
//     return setOnlineStatus(true)
// })
// },[])

    
//   return onlineStatus
// }

// export default useOnlineStatus


/* import { useState, useEffect } from "react";

const useOnlineStatus = () => {
  const [isOnline, setIsOnline] = useState(true);

  // Check if Online or Offline
  useEffect(() => {
    const handleOnline = () => {
      setIsOnline(true);
    }
    const handleOffline = () => {
      setIsOnline(false);
    }

    // Event Listeners
    window.addEventListener("online", handleOnline);
    window.addEventListener("offline", handleOffline);

    // Cleanup - Taught in Live Clsses
    return () => {
      window.removeEventListener("online", handleOnline);
      window.removeEventListener("offline", handleOffline);
    };
  }, []);

  // return true if online, otherewise return false
  return isOnline;
};

export default useOnlineStatus;
 */
import React, { useEffect, useState } from "react";

// Custom hook to check online status
const useOnlineStatus = () => {
  const [isOnline, setIsOnline] = useState(navigator.onLine); // Use `navigator.onLine` for initial value

  useEffect(() => {
    const handleOnline = () => {
      setIsOnline(true);
    };

    const handleOffline = () => {
      setIsOnline(false);
    };

    // Add event listeners for 'online' and 'offline'
    window.addEventListener("online", handleOnline);
    window.addEventListener("offline", handleOffline);

    // Cleanup event listeners when the component unmounts
    return () => {
      window.removeEventListener("online", handleOnline);
      window.removeEventListener("offline", handleOffline);
    };
  }, []);

  return isOnline;
};


export default useOnlineStatus;