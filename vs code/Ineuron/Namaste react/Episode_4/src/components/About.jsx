import React from "react"
import Header from "./Header"
import User from "./User"
import UserClass from "./UserClass"

import React from "react"
class About extends React.Component{

    constructor(props) {
        super(props)
        //console.log("parent constructor")

    }
    componentDidMount(){
        //console.log("parent component didMount")
      }

    render(){
       // console.log("parent  render")

        return(
            <div>
                {/* <Header/> */}
                <h1>About Us</h1>
{/*                 <p>This is the about page.</p>
 */}                  {/* <User name=" laxman (function)"/> */}
    
            <UserClass name="laxman (class)"/>
           {/*  <UserClass name="jan (class)"/>
             */}</div>
        )
    }

}


/* 
 parent construtor 
 parnet rendered
    laxman constructor
    laxman render
    laxmna did mount
    jan constructor
    jan render
    jan did mount
    oarent did mount 
*/
// 45 10 43

// const About=()=>{
//     return(
//         <div>
//             {/* <Header/> */}
//             <h1>About Us</h1>
//             <p>This is the about page.</p>
//               <User name=" laxman (function)"/>

//         <UserClass name="laxman (class)"/>
//         </div>
//     )
// }
export default About



/* 
 final revision notes

 constructor is called and updete with dummy date
 render is called and the component with dummuy data  is rendered

 componentDidMount is called and it fetches data from the API and logs it.
            <api cal>
            <this.setState>  - now  re-concilation  render with updated data


 */