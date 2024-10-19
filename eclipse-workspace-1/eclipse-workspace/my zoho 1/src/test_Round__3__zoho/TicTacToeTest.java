package test_Round__3__zoho;
import java.util.*;

 public class TicTacToeTest {
	 int size =3;
	 char player='x';
	 char board[][]=new char[3][3];

	 public TicTacToeTest() {
		 intializeBoard();
		 
	 }
	 public void intializeBoard() {
		 for(int i=0;i<size;i++) {
			 for(int j=0;j<size;j++) {
				 board[i][j]='-';
			 }
		 }
	 }
	 public void PrintBoard() {
		 for(int i=0;i<size;i++) {
			 for(int j=0;j<size;j++) {
				System.out.print( board[i][j]+ " ");
			 }
			 System.out.println();
		 }}
	 public boolean isBoardFul() {
		 for(int i=0;i<size;i++) {
			 for(int j=0;j<size;j++) {
				if( board[i][j]=='-')
					return false;
			 }
		 }
		 return true;
		 
	 }
	 public boolean move(int row, int col) {
		 if(row<0||col<0||row>=size||col>=size||board[row][col]!='-') {
			 System.out.println("invaild inputs");
			 return false;
		 }
		 else {
			 board[row][col]=player;
			 return true;
		 }
	 }
	 public boolean WinCheck() {
		 for(int i =0;i<size;i++) {
			 if(board[0][i]==player&&board[1][i]==player&&board[2][i]==player) {
				 System.out.println("the "+ player+ "is win");
				 return true;
			 }if(board[i][0]==player&&board[i][1]==player&&board[i][2]==player) {
				 System.out.println("the "+ player+ "is win");
				 return true;
			 }
		 }if(board[0][0]==player&&board[1][1]==player&&board[2][2]==player) {
			 System.out.println("the "+ "player " + player+"is win");
			 return true;
		 }if(board[0][2]==player&&board[1][1]==player&&board[2][0]==player) {
			 System.out.println("the "+ player+ "is win");
			 return true;
		 }
		 return false;
	 }
	 public void playgame() {
		 boolean winCheck = false;
		 int moves=0;
		 Scanner scanner=new Scanner(System.in);
		// System.out.println("Yours turn  "+ player);
		 while(!winCheck&&moves<9) {
			 System.out.println("Yours turn  "+ player);
			 
			 PrintBoard();
			 int row =scanner.nextInt();
			 int col =scanner.nextInt();
			 if(move(row,col)) {
			 if(WinCheck()) {
				 System.out.println();
				 break;
			 }
			 else if(isBoardFul()) {
				 System.out.println("draw");
				 break;
				 
			 }
			 moves++;
			 player=(player=='x')?'o':'x';
				 
			 }
			 
			 
			 
		 }
		scanner.close();
	 }
	 
//}
 //public class kk{
	 public static void main (String args[]) {
		 TicTacToeTest g=new TicTacToeTest();
		// g.PrintBoard();
		 g.playgame();
	 }
	 
 }
