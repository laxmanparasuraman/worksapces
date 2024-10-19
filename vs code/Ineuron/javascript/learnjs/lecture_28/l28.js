//   mostly like revision and interview prep
//  javascript lanuch year 1995

// var,  let , const

// what is variable :  variable is used to save the value of differnt data types 

// const has  to be intializes while  declare
//  category of datatypes  primitive and objects :
/*
 primitives are caoable of storing one type of values
 primitive are: number, string , boolean ,null, undefined
 non prim are: Array and object


 / Math.round
 Math.pow
 Math.random()=>0to 0.9999993

 let user =''  and " "

*/ 

let user ="laxmaN";
console.log(user[3])// give leeter 3 in user  bcoz itself store in arr
/* 
  truty and falsy value
  
  truty value all string  exept  empyt,  numere all positive and negboolen true
  false  0 , null, undefinend ,nan,false , empty string , 
*/

/* operator
  1 assingnment operator :

  2 Arthimatic operator : +, -.*,/,%,**,pow 

  3 comparision operator  == ,><,<=,>=,!=,===

  4 logical operator  && (and) , || (or) 

  5 ternary operator  or condition   "?"


*/

/* 
 condional statement 
 if , if else , if - else if - else , switch , terary operator


*/

let value="1"
switch(value ){
    case "3" :
        console.log("3")

    case "1":
    // console.log(1)
      console.log("1");
      //break
    case "2": 
      console.log("2")
   //   break
}

console.log("loki")
//119

//  can inizialize and  declare vazriable in  for loop

for(let i=0;i<=5;i=i+1){
  console.log(i)
}
// while and do while

//arrays

let students =["Shivam"," laxman","loki"]
//console.log(marks)

let UpperStud=[]
for(let i=0; i<students.length;i++)
{
  UpperStud.push(students[i].toUpperCase())
}
console.log(UpperStud)

// for of

let arr_forof= [1,2,3,4]
for( let element of arr_forof){
  console.log(element)
}

// name of the types  push pos shift unshist concat slice and splice remove tostring 
  

// object
  let obj_names={
  'laxma':97,
  'loki': 99,
  'jni': 99

}
console.log("pr")
 console.log(obj_names)

 let date =  new Date()
 console.log(date.getMinutes())

 //  fuction and break and continue

 function square(){
  console.log("square")
 }
 square()


 function argscheck(...args){
  for(let ele of args){
    console.log(ele+ "s " +ele.length);
  }
 }

 argscheck("lax","loki",arr_forof,obj_names)

 //without ... spredad oprator
 // use aruguments key word

 function argscheck1(){
  for(let ele of arguments){
    console.log(ele+ " aruguments" +ele.length);
  }
 }

 argscheck1("lax","loki",arr_forof,obj_names)
 //argscheck1()


 // arrow function

 let arrow=()=>{
  console.log("this is arrow function syntax")
 }
 arrow()
 // HOISTING ,scope ,execution contest 