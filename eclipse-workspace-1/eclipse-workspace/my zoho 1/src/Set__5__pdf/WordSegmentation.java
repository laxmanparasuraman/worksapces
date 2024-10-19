package Set__5__pdf;

import java.util.ArrayList;
import java.util.List;

public class WordSegmentation {
    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("i");
        dictionary.add("ilike");
        dictionary.add("sam");
        dictionary.add("sung");
        dictionary.add("samsung");
        dictionary.add("mobile");
        dictionary.add("ice");
        dictionary.add("cream");
        dictionary.add("icecream");
        dictionary.add("man");
        dictionary.add("go");
        dictionary.add("mango");

        String input1 = "ilike";
        System.out.println("Input: " + input1);
        System.out.println("Output: " + canSegment(input1, dictionary));

        String input2 = "ilikesamsung";
        System.out.println("Input: " + input2);
        System.out.println("Output: " + canSegment(input2, dictionary));
//        String input3 = "g";
//        System.out.println("Input: " + input3);
//        System.out.println("Output: " + canSegment(input3, dictionary));
}

    public static boolean canSegment(String input, List<String> dictionary) {
        int n = input.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (dp[j] && dictionary.contains(input.substring(j, i))) {
                    dp[i] = true;
                    System.out.println(j+"   "+i+"  if ");
          
                    break;
                }
                System.out.println(j+"   "+i+"  loop ");
            }
        }
        System.out.println(n+"p");
               return dp[n];
    }
}
