// charge 26 11 57
//  Changing data type
// String to number

 let fakenum="25";

 let orgNum=Number(fakenum);
 console.log(typeof fakenum);
 console.log(typeof orgNum);
 console.log("first");

 let strNum=String (orgNum);
 console.log(typeof strNum);

 // Destructuring and Spread

 let ScientificValue=[2.72,3.14,9.81,37,100];
 let [e,pi,gravity,bodytemp,
   boil]=ScientificValue;

   console.log(boil);

   let fullStack=[["html","css","js"],["nodejs","express","mangodb"]]
   let [frontend,backend]=fullStack;
   console.log("frontend "+frontend);
   console.log("backend "+backend);

   let arrayone=[1,2,3,4,5];
   let[a, ,b, ,c]=arrayone;
   console.log(a +" "+ b+" "+c+ "");
   let arrayone_2=[1,2,3,4,5,6,7,8,9];
   let [a1, b1 , ...rest]=arrayone_2;
   console.log(rest);
   console.log(a1+" b " +b1 );


   // Spread and rest
   function sum(x,y){
    return x+y;
   }

   let vari=[5,7];
   console.log(sum(...vari));// output 12 / if we use destructe using"...'  then it will do that spill each and esen to the function 
   console.log(sum(vari));//   output 5,7undefined   ...  spread

   //rest 
   function sumtwo(...args){
    console.log(args);
        let sum=0;
        for(let a of args){
            sum=sum+a;

        }
        return sum;
   }

   console.log(sumtwo(1,2,3,4,5));

   /* 
     there is no differece betwen the spread and rest 
      the thing when what time we use the name convice change like 
      spread or 
   */
 // 1.12

//  //  new keybord
//  let person={
//   name:"laxman",
//  };
//  console.log(person);
//  let  personNew = new Object();
//  personNew.name="new laxman";
//  console.log(personNew);
  

 

// var person=fuction(firstName,courseCount) {
//   this.firstName=firstName;
//   this.courseCount=courseCount;
//  }

var  person = function (firstName, course){
  this.firstName=firstName;
  this.course=course;
}
var anurag=new person("anurag",7);
console.log(anurag);


//set and map


let arraySet=[1,2,3,4,5,6,7,8,1,2,3,4,5,6,7,8,9];
let numSet=new Set(arraySet);
console.log(numSet);

// in java scrip each and everthing is a fi=ucton
// Set will only have unique elements

         
console.log(numSet.delete(1));
console.log(
  numSet.has(1));

  //maps   key  values pair

 //syntax to create a map

 let newMap=new Map();
 console.log(newMap);
 newMap.set("1","one");
 newMap.set(1,"one");
 newMap.set(true,"one");
 console.log(newMap);
// object  key: value , map key=>value


let city=[
  ["India","delhi"],
  ["Raj","Jaipur"]
]
let cityMap=new Map(city);
console.log(cityMap.get("Raj"));

//  for each and for of 
// closure
function outer(){
  let var1="laxman";
  function inner(){
    console.log(var1)
  }
  return inner;
}
let varClousure =outer();
console.log("varclousere "+varClousure);
varClousure();
// where an inner fuction can acces  var to outer fuction


//js is synchronous single threaded lenguage
// Inside the execution contxt
// 
//

