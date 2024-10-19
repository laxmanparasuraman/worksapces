package round__2_Cpaste;
//public class NumberSystem {
//    public static void main(String[] args) {
//        int n = 15; // Replace with the desired value of n
//
//        String nthNumber = findNthNumber(n);
//        System.out.println("The " + n + "th number in the number system is: " + nthNumber);
//    }
//
//    private static String findNthNumber(int n) {
//        if (n <= 0) {
//            return ""; // Invalid input, return an empty string
//        } else if (n == 1) {
//            return "3"; // Base case: The first number is "3"
//        } else if (n == 2) {
//            return "4"; // Base case: The second number is "4"
//        } else {
//            // Recursively find the (n-2)th number and append "3" to it to get the nth number
//            String previousNumber = findNthNumber(n - 2);
//            return "3" + previousNumber;
//        }
//    }
//}     Form a number system with only 3 and 4. Find the nth number of the number system. 
//Eg.) The numbers are: 3, 4, 33, 34, 43, 44, 333, 334, 343, 344, 433, 434, 443, 444, 3333,
//3334, 3343, 3344, 3433, 3434, 3443, 3444 
//public class NumberSystem {
//    public static void main(String[] args) {
//        int count = 15; // The number of numbers to print
//
//        for (int n = 1; n <= count; n++) {
//            String nthNumber = findNthNumber(n);
//            System.out.println("Number " + n + ": " + nthNumber);
//        }
//    }
//
//    private static String findNthNumber(int n) {
//    	int k=3;
//    	 k = (k == 3 ? 4 : 3);
//         
//        if (n <= 0) {
//            return ""; // Invalid input, return an empty string
//        } else if (n == 1) {
//            return "3"; // Base case: The first number is "3"
//        } else if (n == 2) {
//            return "4"; // Base case: The second number is "4"
//        } else {
//            // Recursively find the (n-2)th number and append "3" to it to get the nth number
//            String previousNumber = findNthNumber(n - 2);
//            return k + previousNumber;
//        // k = (k == 3 ? 4 : 3);
//        }
//     
////        if (k==3)
////			k = 4;
////		else
////			k = 3;
//    }
//    
//   
//}
//
//public class NumberSystem {
//    public static void main(String[] args) {
//        int count = 10; // The number of numbers to print (adjust as needed)
//
//        for (int n = 1; n <= count; n++) {
//            String nthNumber = generateNumber(n);
//            System.out.println(nthNumber);
//        }
//    }
//
//    private static String generateNumber(int n) {
//        StringBuilder number = new StringBuilder();
//
//        for (int i = 0; i < n; i++) {
//            if (i % 2 == 0) {
//                number.append("3");
//            } else {
//                number.append("4");
//            }
//        }
//
//        return number.toString();
//    }
//}
//
//Java program to find n'th number in a number system with
//only 3 and 4
import java.io.*;
import java.util.Arrays;

public class NumberSystem {
	// Function to find n'th number in a number system with
	// only 3 and 4
	static void find(int n,String k,String l)
	{
		// An array of strings to store first n numbers.
		// arr[i] stores i'th number
		
		String[] arr = new String[n + 1];

		// arr[0] stores the empty string (String with 0
		// digits)
		arr[0] = "";

		// size indicates number of current elements in
		// arr[], m indicates number of elements added to
		// arr[] in previous iteration
		int size = 1, m = 1;

		// Every iteration of following loop generates and
		// adds 2*m numbers to arr[] using the m numbers
		// generated in previous iteration
		while (size <= n) {
			// Consider all numbers added in previous
			// iteration, add a prefix "3" to them and add
			// new numbers to arr[]
			for (int i = 0; i < m&& (size + i) <=n; i++) {// && (size + i) <= n
				arr[size + i] = "3" + arr[size - m + i];
			}

			// Add prefix "4" to numbers of previous
			// iteration and add new numbers to arr[]
			for (int i = 0; i < m && (size + m + i) <=n;
				i++){//
				arr[size + m + i] = "4" + arr[size - m + i];
				}
//
			// Update no. of elements added in previous
			// iteration
			//m = m << 1; // Or m = m*2;
			m = m*2;

			// Update size
			//int z=0;
			size = size + m;
//			System.out.print(size +   m +"    k   " + z++ +"   ");
//			z++;
		}
//		 System.out.print(Arrays.asList(arr)  +" z  ");
//		System.out.println(arr[n]);
		//System.out.println();
		//System.out.println(Arrays.asList(arr)  +" z  ");
		//int k=arr.;
		String are =Arrays.toString(arr);
		System.out.print(Arrays.toString(arr)  +" z  ");
		System.out.print(are.substring(2,are.length()-1)  +" z  ");
		 
		
	}

	// Driver program
	public static void main(String[] args)
	{
//		for (int i = 1; i < 4; i++)
//			find(i);
//		 
//	
		find(5,"3","4");

}
	}

//Contributed by Pramod Kumar
