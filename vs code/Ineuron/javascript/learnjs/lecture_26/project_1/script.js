const btn = document.getElementById("button");

//    alphanumerice ramdom number
const randomColour=()=>{
    let val="0123456789ABCDEF"
    let cons="#";
    for(let i=0;i<6;i++){
        cons=cons+val[Math.floor(Math.random()*16)];

    }
      return cons;
    //document.getElementById("button)
}


function changeRandomColour(){
    document.body.style.backgroundColor=randomColour()
}


btn.addEventListener("click",changeRandomColour)