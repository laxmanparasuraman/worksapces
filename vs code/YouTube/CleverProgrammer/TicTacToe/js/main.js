import Game from "./Game.js"

import GameView from "./GameView.js";
console.log("first  116" +
    "  207complte  e 30 go back   235  302")


let arr=["x","o","x"];


let game=new Game()
let gameView=new GameView()

document.querySelector(".restart").
addEventListener("click",()=>{
        //console.log("restarting")
        onRestartClick()
    }
)

let tiles =document.querySelectorAll(".board-tile")

console.log(" tiles ",tiles)

tiles.forEach((tile)=>{
    tile.addEventListener("click",()=>{
        console.log("tile clicked ",tile.dataset.index)
        onTileClick(tile.dataset.index)
    })

    console.log()
})

function onTileClick(i){
    game.makeMove(i)
    gameView.updateBoard(game)
   // game.nextTurn()
}

console.log("the turn is  " +game.turn)
game.nextTurn()
console.log("the turn is  " +game.turn)
console.log(game.board)
game.makeMove(3)
console.log(game.board)
console.log(" game  board ")
gameView.updateBoard(game)
game.findWinCombination()

function onRestartClick(){
    game=new Game();
    gameView.updateBoard(game)
}