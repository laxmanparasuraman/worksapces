package Set__5__pdf;

public class Snake_Matrix {
	public static void main(String []args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int n = matrix.length;
		for(int i=0;i<n;i++) {
			if(i%2==0) {
				for(int j=0;j<n;j++) {
					System.out.print(matrix[i][j]);
				}
				System.out.println();
			}
			else if (i%2!=0) {
				for(int j=n-1;j>=0;j--) {
//					System.out.print(matrix[i][n-j-1]);
					System.out.print(matrix[i][j]);
//					
				}
				System.out.println();
			
			}
		}

		
	}

}
