package round__3;

//public class dungen_oct {
//
//}
import java.util.Random;
import java.util.Scanner;

class Game {
    private int adventurerPosition;
    private int monsterPosition;
    private int treasurePosition;
    private int dungeonSize;

    public Game(int size) {
        this.dungeonSize = size;
        Random rand = new Random();
        adventurerPosition = rand.nextInt(size);
        monsterPosition = rand.nextInt(size);
        treasurePosition = rand.nextInt(size);
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int steps = 0;

        while (true) {
            System.out.println("Dungeon Status:");
            displayDungeon();

            System.out.println("Enter your move (L/R): ");
            String move = scanner.nextLine();

            if (move.equalsIgnoreCase("L")) {
                adventurerPosition--;
            } else if (move.equalsIgnoreCase("R")) {
                adventurerPosition++;
            } else {
                System.out.println("Invalid move. Use 'L' or 'R'.");
                continue;
            }

            steps++;

            if (adventurerPosition == treasurePosition) {
                System.out.println("Congratulations! You found the treasure in " + steps + " steps.");
                break;
            } else if (Math.abs(adventurerPosition - monsterPosition) <= 1) {
                System.out.println("Oh no! The monster caught you.");
                break;
            }

            if (adventurerPosition < 0) {
                adventurerPosition = 0;
            } else if (adventurerPosition >= dungeonSize) {
                adventurerPosition = dungeonSize - 1;
            }
        }
    }

    private void displayDungeon() {
        for (int i = 0; i < dungeonSize; i++) {
            if (i == adventurerPosition) {
                System.out.print("A ");
            } else if (i == monsterPosition) {
                System.out.print("M ");
            } else if (i == treasurePosition) {
                System.out.print("T ");
            } else {
                System.out.print(". ");
            }
        }
        System.out.println();
    }
}

public class dungen_oct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Dungeon Game!");
        System.out.print("Enter the size of the dungeon: ");
        int dungeonSize = scanner.nextInt();

        Game game = new Game(dungeonSize);
        game.play();
    }
}

