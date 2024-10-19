package round__2_Cpaste.jan2024.svblog.the100;

/*5. Given a matrix of 2D array of n rows and m coloumns. Print this matrix in ZIG-ZAG fashion as shown in figure.

 

Example:

Input: 

1 2 3

4 5 6

7 8 9

Output: 

1 2 4 7 5 3 6 8 9
*/
//public class zigzagmatrix {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
public class ZigzagMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] matrix4x4 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
            };
        //printZigzag(matrix);
        printZigzag(matrix4x4);
        
    }

    public static void printZigzag(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0, col = 0;
        boolean up = true;
       

        while (row < rows && col < cols) {
            System.out.print(matrix[row][col] + " ");

            if (up) {
                if (col == cols - 1) {
                    row++;
                    up = false;
                } else if (row == 0) {
                    col++;
                    up = false;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == rows - 1) {
                    col++;
                    up = true;
                } else if (col == 0) {
                    row++;
                    up = true;
                } else {
                    row++;
                    col--;
                }
            }
        }
    }
}

