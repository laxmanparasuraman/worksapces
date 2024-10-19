import logo from './logo.svg';
import './App.css';
import Cardcopy from "./Components/Cardcopy"
import Card from "./Components/Card"
import { useEffect, useState } from 'react';
import axios from "axios"
function App() {
  const [details ,setdetails]=useState({})

  const fetchDetails =async()=>{
    const {data} =await axios.get("https://randomuser.me/api")
    console.log("laxman api begin")        
   // console.log(data)
    const detailData=data.results[0]
    setdetails(detailData)
    console.log(detailData)
    }
    useEffect(() => {
      
    
      fetchDetails()
    }, [])
    
  return (
    <div className="App">

      <h1>hello api</h1>
      <Cardcopy details={details} />

        <Card details={details}/>    
    </div>
  );
}

export default App;
