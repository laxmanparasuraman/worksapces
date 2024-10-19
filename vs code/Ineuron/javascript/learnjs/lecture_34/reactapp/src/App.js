import logo from './logo.svg';
import './App.css';
import Card from './Components/Card'
import DestructureProps from './Components/DestructureProps';
import Counter from './Components/Counter';

function App() {
  return (
    <div className="App"> 
       
        <Card name="laxman" imgurl="https://images.pexels.com/photos/18148936/pexels-photo-18148936.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"/>
        <Card name ="ja " imgurl="https://images.pexels.com/photos/2085118/pexels-photo-2085118.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"/> 
        <DestructureProps title="learn react"  description="loki"/> 
        <Counter/>
   
    </div>
  );
}

export default App;
