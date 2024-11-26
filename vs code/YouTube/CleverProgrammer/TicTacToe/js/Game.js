export default class Game{

    constructor(){


        console.log("init game")
        this.turn="X";
        this.board=new Array(9).fill(null)
}

nextTurn(){
    if(this.turn=="X"){
        this.turn="O";
    }else{
        this.turn="X";
    }
}
makeMove(i){


    if(this.endOfgame()){
        return
    }
    if(this.board[i]){
        return;
    }
    this.board[i]=this.turn
    let winningCombination=this.findWinCombination()
    console.log("this is winning combination ",winningCombination)

    if(!winningCombination){
        this.nextTurn()
    }
}

findWinCombination(){
    const winCombinaton=[
        [0,1,2],
        [3,4,5],
        [6,7,8],
        [0,3,6],
        [1,4,7],
        [2,5,8],
        [0,4,8],
        [6,4,2]
    ]
    for(const combination of winCombinaton){
        /* console.log(combination)
        for (position of combination) */

        const[a,b,c]=combination
        if(this.board[a]&&this.board[b]&&this.board[c]){
           if(this.board[a]===this.board[b]&&this.board[b]===this.board[c]){
          return combination;    }
    }
}
return null  
}

endOfgame(){
   let winingcombinaton=this.findWinCombination()
   if(winingcombinaton){
    return true
   }else{
    return false
   }   l
}
}