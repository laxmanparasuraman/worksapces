import Navbar from "./Components/Navbar"
import Card from "./Components/card"

function App(){

     return (
        // Parsing error: Adjacent JSX elements must be wrapped in an enclosing tag. Did you want a JSX fragment
        // the react  jsx should have one parent tag 
        <div> {/*  can use   <> empty tag and react.fragment  */}
        {/* <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"></link> */}
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"></link>
        <Navbar/>
            <h2> this is a app function - Hitiesh</h2>
        <p>this is paragrah</p>
        <Card/>
        </div>
     ) 
}
export default App

