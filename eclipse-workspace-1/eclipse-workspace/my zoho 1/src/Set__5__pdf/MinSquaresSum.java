package Set__5__pdf;

public class MinSquaresSum {

    public static void main(String[] args) {
        int n = 12;
        int minSquares = findMinSquares(n);
        System.out.println("Input: " + n);
        System.out.println("Output: min: " + minSquares);
    }

    public static int findMinSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = i; // Initialize to the worst case (sum of 1^2 for each number)
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
                System.out.print( 1 + dp[i - j * j]);
                System.out.print(dp[i]+ " "+i);
            }
        }

        return dp[n];
    }
}

