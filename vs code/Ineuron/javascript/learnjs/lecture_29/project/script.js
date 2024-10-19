const btn = document.getElementById("button")


const randomcolour=()=>{
    let value="1234567890ABCDEF"
    let hash ="#"

    for(let i=0; i<6; i++){
        hash=hash+value[Math.floor(Math.random()*16)]

    }
    return hash;
}
function changeColour(){
    document.body.style.backgroundColor=randomcolour()
}
btn.addEventListener("click",changeColour)