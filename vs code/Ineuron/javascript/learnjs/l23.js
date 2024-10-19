// class and protype


/*  
let arr=[1,2,3];
let[one , ...two]=arr;
console.log(one,+" two  ",two);
//callstack and hoisting 
console.log("after");
console.log(one + " two1 " ,two);

  */
///article js intervie prep    1 sinle thread 2 hoistng 3 callback


//  class 
let user1={
    talk(){
        return "Taking";
    }
}

let user2={
    talk(){
        return "taking";
    }
}


class user{
    constructor(firstName,lastName){
        this.firstName=firstName;
        this.lastName=lastName;
}
getFullName(){
    return this.firstName+" "+this.lastName;
}

}

let userClass=new user("laxman","parasuraman");
console.log( userClass.getFullName());
 
/// default construt("  
//          ")

//getter and setters

// protype   check in mdn
// var varone=10;
// varone.hasown
// console.log(varone.
    
  //  )

//  using a protye we can insert a extra method  to class or object
// example
user.prototype.getName= function(){
    console.log(`the user name is ${this.firstName}`) ;
}
//console.log(userClass.getName());
//userClass.getFullName();
console.log("first");

let objectOne={
    fullNam:"laxman",
    add:"Jaipur",
    getName:function(){
        console.log(this.fullName+" ..."+this.add);
    },
}
let objectTwo={
    fullName:"Hitesh Sir",
}
objectTwo.__proto__=objectOne;//protype inheritance
console.log(objectTwo);
console.log(objectTwo.add);//  add method or fuction or varible    but  acces by 2 from 1

console.log(objectOne);
