// sept 1 
 //event loop and promise
 /* 
 
 */
let myHeros=["thor", "Spiderman"]
let heropower={
    thor:"hammer",
    spiderman:"sling",
    getSpiderpower:function(){
        console.log(`spidy power is ${this.spiderman} k`);
    }
}
//let obj=new heropower;
//console.log(heropower.getSpiderpower());
console.log(heropower);

//console.log(heropower.laxman());//err
console.log("first");

Object.prototype.laxman=function() {
    console.log("new method fuction to all object and using protyupe ");
}
//heropower.laxman
console.log(heropower.laxman());
console.log("my heros");
myHeros.laxman();
// we get undefien when we have fuc in clg which has clg

Array.prototype.heyArray=function(){
    console.log(`total elemt are ${this.length}`);

}
myHeros.heyArray();

// forsake create a new arrr with 3 length chek the fuction hey array


//Inheritance 

const User={
    name:"top name",
    email:"example@gmail.com"
}
const Teacher={
    makeVideos:true
} 

Teacher.__proto__=User;
console.log(Teacher.email);

//another way of inheritace

Teacher.prototype=User;
//   morder way  es6 
Object.setPrototypeOf(Teacher,User);

 const TeachingSupport={
    isAvaille: false
 }


 // to make user teacxhing supprt have alluser ans teaxher variabl;e 
 Object.setPrototypeOf(TeachingSupport,Teacher);
                               // angular js html css java springboot postgresql

console.log("laxman".length);

console.log("laxman  ".length);


// need to create a new protype method  way it give a truelength which exclude an  space and give a true length;

String.prototype.truelength=function(){

    console.log(`true length is ${this.trim().length} `);

}
console.log("true length");


console.log("laxman  ".truelength());

// Event 

//laxman parasuram 



// sake

const UserOne=()=>{
    
    console.log("user one");
}
const userTwo=()=>{
    setTimeout(()=>{
        console.log("insider of 2")
         
    },2000)
    console.log("user two");
}

const User3=(()=>{
    console.log("user 3");
})
/* 
   ggs 
*/

UserOne();
userTwo();
User3();

//promise( callback, promise constructor)  real time example  such as  cab driver   we  booked  and he promised to pick up
//  - pending
// fullfiled - fullfilled promise is also known as reslove 

// - reject
//

// promise constructor
const MakePromise = new Promise((resolve ,reject)=>{
setTimeout(()=>{
    const arrOne=["userOne","userTwo","userThree"];
    if(arrOne.length<0){
        resolve("yes");
    }else{
        reject("no found");
    }
},2500)
})

//console.log(MakePromise.then());

console.log("next")
MakePromise.then((result)=>{
    console.log(result)
}).catch((res)=>{
    console.log(res)
})


// async and await 
const userone1=()=>{
    return "i am user one 11";

}
const userone2=()=>{

    return new Promise((reslove,reject) => {
        setTimeout(()=>{
            reslove("user fopund")
        },1500)
    })
    //return "i am user two ";

}

const userone3=()=>{
    return "i am user three ";

}


///  wait  without async i do it to understand and do dry rin

const wait=()=>{
    let guestOne=userone1();
    console.log(guestOne);

    let guestOne1=  userone2();
    console.log(guestOne1);

    let guestOne3=userone3();
    console.log(guestOne3);
 }
console.log("wait begin");
 wait();
  console.log("wait aftet");



// with async  and awit


 const wait=async()=>{
    let guestOne=userone1();
    console.log(guestOne);

    let guestOne1= await userone2();
    console.log(guestOne1);

    let guestOne3=userone3();
    console.log(guestOne3);
 }
console.log("wait begin");
 wait();
  console.log("wait aftet");













    