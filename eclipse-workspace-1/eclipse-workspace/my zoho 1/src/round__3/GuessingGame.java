package round__3;

//public class GuessingGame {
//
//}
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        int maxAttempts = 10;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I have selected a random number between " + minRange + " and " + maxRange + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

        while (attempts < maxAttempts) {
            System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess == randomNumber) {
                hasGuessedCorrectly = true;
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Your guess is too low. Try again.");
            } else {
                System.out.println("Your guess is too high. Try again.");
            }

            attempts++;
        }

        if (hasGuessedCorrectly) {
            System.out.println("Congratulations! You've guessed the correct number: " + randomNumber);
            System.out.println("You guessed it in " + (attempts + 1) + " attempts.");
        } else {
            System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
        }

        System.out.println("Thank you for playing the Guessing Game!");
    }
}
