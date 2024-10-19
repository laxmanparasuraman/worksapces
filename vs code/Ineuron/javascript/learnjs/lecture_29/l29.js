// HOF - higer order function
// three parts- call back

/*
 a call back is something that get a fuctions as a arguments
  and parameter and return a fuction and parameter 
*/
// ex

function greet(userName,callback){
    console.log("hello", userName)
    callback()
}
function callback(){
    console.log("i am call back")
}

greet( "laxman" , callback)

const callback1=(n)=>{

    return n**2
}
function square( callback ,n){
    return callback(n)*n

}
console.log(square(callback1,5))

// setTimeout   is a call back
//  in set time out syntax is settimeout ( fuction ,time)

setTimeout(()=>{
    console.log("welcome to js bootcamp")
},3000)
// setInterval(()=>{
//     console.log("refresh the page")
// },2000)
//  set interval after the givesn sec it call the fuction agan ND AGAIN

// FOR EACH

const arr_for_each=["hey","hi","hello"]
arr_for_each.forEach((ele)=>{
    console.log(ele,"foreach")

})
arr_for_each.map((val)=>{
    let count=0;

    val=val+val+count; 
    console.log(val,"map")
    count++;

})
arr_for_each.forEach((ele)=>{
    console.log(ele,"  foreach after map")

})

//  do google map can modify  a original or it jsus like a for each

// filter

let country =["india","germany","japan","england","amercia","finland"]

let ret= country.filter((country =>{
    return country.includes("ia")
}))
 

// without retyur so need no barakect
let ret_without_return= country.filter((country =>country.includes("ia")
))
console.log(ret_without_return)

// reduce   i have no idea nee google
const choc=[1,2,3,4,5];
const wrap =choc.reduce((acc,pos)=>acc+pos+0)
console.log(wrap)

//sort


//  destructuring :- spread and rest
function sum_destructuring(x,y){
    return x+y;

}
let vari=[1,2]
console.log(sum_destructuring(...vari))// spread


function sum_destructuring_args(...args){ // destructured
    //return x+y;
    console.log(args);

}
//let vari=[1,2]
//console.log(sum_destructuring(...vari))// spread
console.log(sum_destructuring_args(vari))

// new  

// set and map

//let tech = new Set() // syntax for set 
let tech=[ "html","css","js","nodejs","reactjs","html","css","js","Angular"]
let tech_set= new Set(tech);
console.log(tech_set)

// map like hasp map
// map has key value pair
let map=new Map();
map.set()
map.set("1","str1")
map.set(true,"Str2")
map.set(1,"str3")
console.log(map)

//closure  :  inner fuction that can able to acces the outer fuction  variable

function Grandparents(){
    let dad =" Hello now clousre  going my identifer name is dad"
    function parent(){
        console.log(dad)
    }
    parent()
}

Grandparents()
// real world closure example
function Grandparents_realWord(){
    let dad =" hello Hello now clousre  going my identifer name is dad  from real grand "
    function par(){
        console.log(dad)
    }
    return par;
}

let clousure_getFuc=Grandparents_realWord()
clousure_getFuc()

// try and catch
try {
    let firstName_try="laxmn"
    console.log(firstName_try+ " "+lastname)
}catch (err){
    console.log(err.name)
}finally{ // like default
   console.log("i will run at cost coz defualt")
}

console.log("end")

// 1.08

// promise  -> revolve &- >reject
// callback , .then , .catch , async await
const MakePromise = new Promise((reslove,reject)=>
{
    setTimeout(()=>{
        const exam=["html","css","js","talwind"]
        if(exam.length>100){
            reslove ("done")
        }else{
            reject("not done")
        }
    })

});

MakePromise .then((res)=>{
    console.log(res)
}).catch((res)=>{
    console.log(res)
})
//MakePromise

// asnyc and await

const uno =()=>{
    return " i am one "

}
const dos=()=>{
    //return " i am 2"
    return new Promise((resolve,rejected)=>{
        setTimeout(()=>{
            resolve("i am two")
        },2000)
    })
}

const tres = ()=>{
    return ' i am three'
}
  const call=async ()=>{
    let one =uno();
    console.log(one)

    let two = await dos()
    console.log(two)

    let three =tres()
    console.log(three)
  }
  call()

  console.log("afte call ")

  let one =uno();
    console.log(one)

    let two =  dos()
    console.log(two)

    let three =tres()
    console.log(three)

    // rescountries/v2/all
    const url ="https://restcountries.com/v2/all"

    fetch(url)
    .then((res)=>{
        return res.json()

    })
    .then((data)=>{
        console.log(data)
    })
    .catch((err)=>{
        console.error(err)

    })





