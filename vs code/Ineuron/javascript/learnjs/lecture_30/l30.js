/* 
interview questions

  
1 what is nature of javascript
2 what are function scope and block scope
3 what is synchronous and Asynchronous in javascript:  js sync single thread

   3 ans :a future code is not  until the curret code is run
4 is javascript a statical typed or dynamically type
     : js is dynamically typed ,if we want static can use  int ,string ,  and typesript is statically typed
5 what is hoisting in javascript
        : hoisting   is ;;   can acccces some varible before  it decalre and inzialize it give undefied bcoz it scannen un  global scopes but not  
        where by interperter      
*/

//hoisting code 
console.log(first)
var first= "hoisting"
console.log(first)

/*   
 6  difference betwwen undecalre and undefined
 */
let message
console.log(message) //un defined
//console.log(msg)// un decalred

/*
7 what is "this" in java script: this . keyword 

 */
console.log(this)
/*
8 difference between let , var , const
        :  var is something that has  global scope
           let has bloc scope and const is some thing we cant reasign

 */


 /* 9 what is dom and virutual dom
               :virutual dom offer spa - single page applications

*/
/* 10 what closure in javasript 
        : clousure is domtjhing the  inner function can  access the variable of outer function varaible  
             closure also  related or also know as lexical scope            
 */
/* 11  what is rest and spread operators
        : spread operator is used to spilt the entity lik arr to each element */
//  exaple
const arr =[2,3,4,5];
console.log(...arr)
console.log(arr[0], ...arr)
let [one,rest]=[...arr]
console.log(one)
console.log(rest)
/*  what are promises in javasript and how to use of promise in js
 */

/*
 2  what fuction scope block scope lexical scope 
 3  what is synchorouss and asychoronus - singel ans multi thread
 4  is static tyoed or dynamically typed language
 5  what is hoisting in java script
 6   scope chaning
 7 what is this in java script
 8 temproal dead zone exexcution context
 9   dom 
 10 rest asnd spread and destructuring 

 11 promise
 12 differnt tyoes fuction : normal fuction, arrow fuction , self inv
 13  
   
 */
let c={
    greeting :'hey'
}
let d 
d= c 
c.greeting='hello'
console.log(d.greeting)

// always break down anything into chunks to make better
