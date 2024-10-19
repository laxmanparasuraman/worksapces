package round__2_Cpaste.jan2024.svblog.the100;

 
public class ZigzagTraversal {
    public static void main(String[] args) {
        int[][] matrix4x4 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        int[][] matrix5x5 = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };

        System.out.println("Zigzag traversal for 4x4 matrix:");
        printZigzag(matrix4x4);

        System.out.println("\nZigzag traversal for 5x5 matrix:");
        printZigzag(matrix5x5);
    }

    public static void printZigzag(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean up = true;

        for (int i = 0; i < rows + cols - 1; i++) {
            if (up) {
                int row = i < rows ? i : rows - 1;
                int col = i < rows ? 0 : i - rows + 1;
                while (row >= 0 && col < cols) {
                    System.out.print(matrix[row][col] + " ");
                    row--;
                    col++;
                }
            } else {
                int row = i < cols ? 0 : i - cols + 1;
                int col = i < cols ? i : cols - 1;
                while (row < rows && col >= 0) {
                    System.out.print(matrix[row][col] + " ");
                    row++;
                    col--;
                }
            }
            up = !up;
        }
    }
}
