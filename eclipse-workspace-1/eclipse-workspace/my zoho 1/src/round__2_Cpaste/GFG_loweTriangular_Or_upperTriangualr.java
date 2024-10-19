
package round__2_Cpaste;

//Java program to print Lower
//triangular and Upper triangular
//matrix of an array
//import java.io.*;
public class GFG_loweTriangular_Or_upperTriangualr
{
	public static boolean IsLower(int[] [] a) {
		int n=a.length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<i;j++) {
				//int k= a[i][j];
				if(a[i][j]!=0) {
					return false;
				}
				
			}
		}
		return true;
	}
	public static boolean IsUpper(int[][] b) {
		int n=b.length;
		for(int i=0;i<n;i++) {
			for (int j=i;j<n;j++) {
				if(b[i][j+1]!=0) {
					return false;
				}
			
		}
			}
		return true;

	}
	// method to form lower
	// triangular matrix
	static void lower(int matrix[][],
					int row, int col)
	{
		int i, j;
		for (i = 0; i < row; i++)
		{
			for (j = 0; j < col; j++)
			{
				if (i < j)
				{
					System.out.print("0" + " ");
				}
				else
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	// Method to form upper
	// triangular matrix
	static void upper(int matrix[][],
					int row, int col)
	{
		int i, j;
		for (i = 0; i < row; i++)
		{
			for (j = 0; j < col; j++)
			{
				if (i > j)
				{
					System.out.print("0" + " ");
				}
				else
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	// Driver Code
	public static void main(String args[])
	{
		int matrix[][] = {{1, 2, 3},
						{4, 5, 6},
						{7, 8, 9}};
		int row = 3, col = 3;
		int matrix1[][]= {{1,1},{0,1}};
		int[][] b = {
			    {4, 6, 1, 4},
			    {0, 3, 5, 9},
			    {0, 0, 6, 2},
			    {0, 0, 0, 8}
			};

		
		System.out.println("Lower triangular matrix: ");
		lower(matrix, row, col);
		
		System.out.println("Upper triangular matrix: ");
		upper(matrix, row, col);
		boolean z=IsUpper(b);
		System.out.println("Upper triangular matrix: "+	IsLower(b)+ z);
	//;

	}
}


