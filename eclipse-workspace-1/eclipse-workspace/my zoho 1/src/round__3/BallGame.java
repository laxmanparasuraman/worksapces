package round__3;

import java.util.Scanner;

public class BallGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] grid = {
            {'w', 'w', 'w', 'w', 'w', 'w', 'w'},
            {'w', ' ', ' ', ' ', ' ', ' ', 'w'},
            {'w', ' ', '1', '1', '1', ' ', 'w'},
            {'w', ' ', '1', ' ', '1', ' ', 'w'},
            {'w', ' ', ' ', ' ', ' ', ' ', 'w'},
            {'w', ' ', ' ', ' ', ' ', ' ', 'w'},
            {'w', 'g', 'g', 'o', 'g', 'g', 'w'}
        };

        int ballX = 6;
        int ballY = 3;
        int ballLife = 5;

        printGrid(grid, ballX, ballY);
        System.out.println("Ball count: " + ballLife);

        while (ballLife > 0) {
            System.out.print("Enter command (st, lt, rt): ");
            String command = scanner.nextLine().trim();

            if (command.equals("st")) {
                int[] result = moveStraight(grid, ballX, ballY);
                ballX = result[0];
                ballY = result[1];
                ballLife--;

                printGrid(grid, ballX, ballY);
                System.out.println("Ball count: " + ballLife);
            } else if (command.equals("lt")) {
                int[] result = moveLeft(grid, ballX, ballY);
                ballX = result[0];
                ballY = result[1];
                ballLife--;

                printGrid(grid, ballX, ballY);
                System.out.println("Ball count: " + ballLife);
            } else if (command.equals("rt")) {
                int[] result = moveRight(grid, ballX, ballY);
                ballX = result[0];
                ballY = result[1];
                ballLife--;

                printGrid(grid, ballX, ballY);
                System.out.println("Ball count: " + ballLife);
            } else {
                System.out.println("Invalid command. Please enter st, lt, or rt.");
            }
        }

        System.out.println("Out of balls. Game over.");
        scanner.close();
    }

    private static void printGrid(char[][] grid, int ballX, int ballY) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == ballX && j == ballY) {
                    System.out.print("o ");
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static int[] moveStraight(char[][] grid, int x, int y) {
        if (grid[x - 1][y] == '1') {
            grid[x - 1][y] = ' ';
            return new int[] { x + 1, y };
        } else {
            return new int[] { x - 1, y };
        }
    }

    private static int[] moveLeft(char[][] grid, int x, int y) {
        if (grid[x - 1][y - 1] == '1') {
            grid[x - 1][y - 1] = ' ';
            return new int[] { x + 1, y - 1 };
        } else {
            return new int[] { x - 1, y - 1 };
        }
    }

    private static int[] moveRight(char[][] grid, int x, int y) {
        if (grid[x - 1][y + 1] == '1') {
            grid[x - 1][y + 1] = ' ';
            return new int[] { x + 1, y + 1 };
        } else {
            return new int[] { x - 1, y + 1 };
        }
    }
}

