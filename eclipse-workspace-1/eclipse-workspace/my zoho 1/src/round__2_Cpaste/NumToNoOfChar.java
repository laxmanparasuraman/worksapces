package round__2_Cpaste;

/*You’re given a number n. If write all the numbers from 1 to n in a paper, we have to find the
number of characters written on the paper.For example if n=13, the output should be 18 if n = 101,
the output should be 195 */

public class NumToNoOfChar {
	//public class CountTotalCharacters {
	    public static void main(String[] args) {
	        int n = 10; // Change this value to any positive integer

	        int totalCharacters = 0;

	        for (int i = 0; i <= n; i++) {
	            totalCharacters += Integer.toString(i).length(); // Count digits in the number
	        }

	       // totalCharacters =Integer.reverse(totalCharacters);
	      //  totalCharacters += n - 1; // Add spaces between numbers

	        System.out.println("Total number of characters: " + totalCharacters);
	    }
	}


//}
