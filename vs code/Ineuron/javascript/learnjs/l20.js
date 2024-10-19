
console.log("first")
user={
    firstname:"loki",
    lastname:"kumar",
    courseList:[],

    buycourse: function(course){
        this.courseList.push(course);

    },
    getCourseCount:function(){
        return `${this.courseList}`;
    },
    getlen:function(){
        return '${this.firstname}';
    },

}

/*
console.log(user.getlen);
console.log(user.getCourseCount);
user.buycourse("re");
console.table(user)
console.log("1")
console.log(user)

//  check  fuc

//obj key or val

console.log(" values  ")
console.log( Object.values(user));

console.log("keys")
console.log( Object.keys(user));

// check is key is availabe o not

console.log(user.hasOwnProperty("firstna"))

//for in

for(let x in user){
    // console.log(x)
    // console.log(user[x])
    console.log(`key is ${x} and value is ${user[x]} `);
}


//higher order function 
//and call back functi on  

// arrow function for find the element is even or not

let iseven=(el)=>{
    return el%2==0;
}
let val= [2,4,6,9].every(iseven);
console.log(val);



// callback
//for squre
const callback=(n)=>{
    return n**2;
}

// return callback sq and 3

function cube(callback,n){
    return callback(n)*n;

}
console.log(cube(callback,3));
///higer order

//   a fuction that takes a fuction as parameter are 
//higer order  ---   example callback 

function course(){
    console.log("welcome to fullstack")
}
course();

setTimeout(course,3000);

setTimeout(()=>{
    console.log("clg");
},3000);
setInterval(()=>{
    console.log("first");
},3000)*/


//   for each

let arr=["hey","hi","hello","love"];

arr.forEach((val)=>{
    console.log(val)
})

//map
//problem statement   we have  to create an array of object :each object should have name ,price,launch date and method to buy 
/*
let appleproducts=[
    {
        productName:'Macbook',
        productPrice:15000,
        productLaunch:'December 2002',
        buyProduct:()=>{
            console.log(`congrats ${this.productName}`)
        }
    }

    //807  89
    //  check the moziall mdn

    // telegram 9486968877 api id 27986394
    //  api hash  676cd5a3ef69f55c34e021321723062f
]
*/
//  Map
let number =[1,2,3,4,5,6,7];
let store=number.map((num)=>{
    return num*num
});
let storeNoCurly=number.map((num)=>num*num)
console.log(store);
console.log(storeNoCurly);

//filter 

let country=["INDIA","JAPAN","KENYA","IRELAND,"];
//syntax for reduce 
// arrayname.reduce()

/*  
  revision topics

  data types - number string , undefined , boolean
  variables
  conditions -
  Math functions
  array and all method
 loop for do while , for in , for out
 function- with paramter ,without paramete. arrow function , callback high order  function
 object-  syntax 
 high order fuction; setInteral, setTimeout 
 functional program : every ,foreach,map.reduce 
//


/ clouser
/ when am inner fuction try to access the outer  

*/

console.log(" prev");
function outer(){
    let variable="seven";
    function inner(){
        console.log(variable + " ");
    }
}
outer();

console.log("recent");
inner();