import React from 'react';
class UserClass extends React.Component {
  
  constructor(props) {
   super(props); 
   this.state = {
    count:0,
    count2:2,
    userInfo:{
      name:"dummy",
      email:"dummy@mail.in",
      avatar_url:"",
      location:"dummy location"
    }

   }
   console.log(this.props.name," child constructor")
    //console.log("first".this.state)
    
  }

  async componentDidMount(){
   // console.log(this.props.name,"child component didMount")
   const data=await fetch("https://api.github.com/users/priya6971")
  const json=await data.json()
    console.log(json)
    this.setState({userInfo:json})
   
  }

  setCount = () => {
    return this.setState({ count: this.state.count + 1 });
}

render(){
      const { name,location,avatar_url}=this.state.userInfo
  return(
        <div>

          <h1>
            <img src={avatar_url}/>
            <h1>Name :{name}</h1>
            <h1>Location:{location}</h1>
             
          </h1>
        </div>

      ) 


           /*  return(

            
            <div>
                {console.log(this.props.name,"child render")}
            <h1>Hello class bassed component is herer </h1>
               <h1 
               onClick={()=>(
              //  this.state.setCount()
               this.setState({count:this.state.count+1})
            )
            }
                
                >class Count :{this.state.count}</h1>
               <h1
               onClick={this.setCount}
               >class Count2 :{this.state.count2}</h1>
                <h1>Name :{this.props.name}</h1>
                 <h1>Email :plaxman@mail.in</h1>
                 <h1>Location:Kumbakonam</h1>
                 
            </div>
                ) */
      
          }

}

export default UserClass;