package gfg;

import java.util.Arrays;

public class SubstringSearch_matix {
    public static void main(String[] args) {
        String input = "WELCOMETOZOHOCORPORATION";
        char[][] matrix = createMatrix(input);

        String substring = "too";
        System.out.println(Arrays.deepToString(matrix));
    	
        findSubstring(matrix, substring);
    }

    private static char[][] createMatrix(String input) {
        int cols = 5;
        int rows = input.length() /cols;

        char[][] matrix = new char[rows][cols];
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.charAt(index);
                index++;
            }
        }

        return matrix;
    }

    private static void findSubstring(char[][] matrix, String substring) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int subLength = substring.length();

        for (int i = 0; i <= rows - subLength; i++) {
            for (int j = 0; j <= cols - subLength; j++) {
                StringBuilder diagonalSubstring1 = new StringBuilder();
                StringBuilder diagonalSubstring2 = new StringBuilder();

                for (int k = 0; k <subLength; k++) {
                    diagonalSubstring1.append(matrix[i + k][j + k]);
                    diagonalSubstring2.append(matrix[i + k][j + subLength - 1 - k]);
                }

                if (diagonalSubstring1.toString().equals(substring)) {
                    System.out.println("Start index: <" + i + ", " + j + ">");
                    System.out.println("End index: <" + (i + subLength - 1) + ", " + (j + subLength - 1) + ">");
                }

                if (diagonalSubstring2.toString().equals(substring)) {
                    System.out.println("Start index: <" + i + ", " + (j + subLength - 1) + ">");
                    System.out.println("End index: <" + (i + subLength - 1) + ", " + j + ">");
                }
            }
        }
    }
}


