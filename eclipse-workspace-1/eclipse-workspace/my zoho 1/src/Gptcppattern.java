
//public class Gptcppattern {
//
//}
import java.util.Scanner;

public class Gptcppattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String input = scanner.next();
        scanner.close();
        
        int n = input.length();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    System.out.print(input.charAt(i));
                } else if (i + j == n - 1) {
                    System.out.print(input.charAt(j));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
