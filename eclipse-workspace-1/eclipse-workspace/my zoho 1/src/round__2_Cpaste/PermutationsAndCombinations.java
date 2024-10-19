package round__2_Cpaste;

import java.util.Arrays;

public class PermutationsAndCombinations {
    public static void main(String[] args) {
        String input = "532";
        System.out.println("Permutations:");
       // generatePermutations(input, 0, input.length() - 1);
        System.out.println("\nCombinations:");
        generateCombinations(input, "", 0);
    }

    // Generate permutations of the string
    public static void generatePermutations(String str, int left, int right) {
        if (left == right) {
            System.out.println(str);
        } else {
            for (int i = left; i <= right; i++) {
                str = swap(str, left, i);
                generatePermutations(str, left + 1, right);
                str = swap(str, left, i); // backtrack
            }
        }
    }

    // Generate combinations of the string
    public static void generateCombinations(String str, String combination, int index) {
        if (index == str.length()) {
            System.out.println(combination);
        } else {
            generateCombinations(str, combination + str.charAt(index), index + 1);
            generateCombinations(str, combination, index + 1);
        }
    }

    // Swap characters at position i and j in the string
    public static String swap(String str, int i, int j) {
       //tatic int =0;
    	char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
         String res= new String(charArray);
       // System.outprintln(Arrays.asList(charArray)+"test");
   int  test =1;
   test++;
  // final int circlecount = 0;
         //.out.println(res+(test));
     return new String(charArray);
     
    }
} 
