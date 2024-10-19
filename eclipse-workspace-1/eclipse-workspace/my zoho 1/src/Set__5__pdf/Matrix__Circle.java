package Set__5__pdf;

import java.util.Arrays;

public class Matrix__Circle {

	/*
	 * // * public Matrix__Circle() { // TODO Auto-generated constructor stub
	 * }Program 4: Rotate the matrix elements For 3*3 matrix Input 1 2 3 4 5 6 7 8 9
	 * Output: 4 1 2 7 5 3 8 9 6 For 4*4 matrix Input: 1 2 3 4 5 6 7 8 9 10 11 12 13
	 * 14 15 16 Output: 5 1 2 3 9 10 6 4 13 11 7 8 14 15 16 12
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int n = matrix.length;
		int[][] res1 = new int[n][n];
		n--;
		int j1 = 1;
		int k=0;
		int i1 = 0;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				// matrix[i][j];
				//System.out.println("1" + matrix[i][j] + "1");

		if(j1<=n) {
			//System.out.print("#"+matrix[i][j]+"#");
			res1[i1][j1]=matrix[i][j];
			j1++;
			if(j1>n) {
				 k=1;
				j1-- ;
				
			}
			
//			System.out.println(j1+"p");
//			System.out.println(n+"pn");
			//System.out.println(i1+"p");
			//break;
             }
		if(j1==n&&i1<2&&k==1) {
			i1++;
			res1[i1][j1]=matrix[i][j];
			}
//		if(i1==j1&&j1>=n&&j>0) {
//			j1--;
//			res1[i1][j1]=matrix[i][j];
//}
//		if(i1==j1&&j1==0&&i>0) {
//			i1--;
//			res1[i1][j1]=matrix[i][j];
//}
				/*
				 * for (int m=0;m<=2;m++) { for(int l=0;l<=2;l++) {
				 * System.out.print(res1[m][l]); } System.out.println(); }
				 */

			}
		}
		
		  for (int m=0;m<=2;m++) { for(int l=0;l<=2;l++) {
		  System.out.print(res1[m][l]); } System.out.println(); }
		  
		  System.out.println("\n" +n);
		  
		  }
//
}
