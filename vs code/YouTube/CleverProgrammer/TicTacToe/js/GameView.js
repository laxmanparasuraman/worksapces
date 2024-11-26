export default class GameView{


    constructor() {
        console.log("init gamwView")
        
    }

    updateBoard(game){

        console.log("updates    Bord  from game view")
        console.log(game.board)

        const winingCombinaton=game.findWinCombination()

                for (let i=0;i<game.board.length;i++){
                let tile =document.querySelector(`.board-tile[data-index='${i}']`)
                         
                  tile.classList.remove("title-winner")

                /*    let tile =document.querySelector(`.board-tile[data-index='${i}']`);  console.log(tile+"title")
                    console.log(game.board[i])
                    */

                    let  tileType =game.board[i]=="X"?"tile-x":"tile-o"

                    tile.innerHTML=`<span class ="${tileType}"> ${game.board[i]? game.board[i]:"-"}</span>`


                /* if(game.board[i]) tile.innerHTML=game.board[i]
                else  tile.innerHTML=  "-"
                */ 
                this.updateTurn(game)
                if(winingCombinaton&&winingCombinaton.includes(i)){
                    tile.classList.add("title-winner")
                    console.log("we are the winner")
                    console.log(tile)
                }
                }


   }


 updateTurn(game){
        let playerX =document.querySelector(".player-x")
        let playerO =document.querySelector(".player-o")
       console.log(playerO,playerX)
           if(game.turn=="X"){
            playerX.classList.add("active")
            playerO.classList.remove("active")
           }
          else  
          {
            playerX.classList.remove("active")
              playerO.classList.add("active") 
          } 
    }


   
}