package Set__5__pdf;

public class DoublePyramidPattern {
    public static void main(String[] args) {
        int n = 4; // Number of rows in each pyramid

        // Printing the upper pyramid
        for (int i = 1; i <= n; i++) {
            // Print spaces for center alignment
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }

            int num = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num--;
            }

            num = 2;
            for (int j = 2; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }

            System.out.println();
        }

        // Printing the lower pyramid
        for (int i = n - 1; i >= 1; i--) {
            // Print spaces for center alignment
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }

            int num = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num--;
            }

            num = 2;
            for (int j = 2; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }

            System.out.println();
        }
    }
}

