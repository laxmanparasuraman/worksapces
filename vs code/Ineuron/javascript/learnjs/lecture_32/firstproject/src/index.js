import ReactDOM from "react-dom/client"
import './index.css'/*  learn how and whre to import and css ho w it work what ahppen if i d on index.html , app.js lear the scope */
import App from './app'
import Navbar from './Components/Navbar';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<h1>Hello, world!</h1>);
root.render(<Navbar/>)  
root.render(<App/>) 

 