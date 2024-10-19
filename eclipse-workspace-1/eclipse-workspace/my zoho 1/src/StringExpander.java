import java.lang.*;
 

public class StringExpander {
    public static String expandString(String input) {
    	
        StringBuilder expanded = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

//            if (Character.isLetter(currentChar)) {
//                expanded.append(currentChar);
          //  }
             if (Character.isDigit(currentChar)) {
            	// int count =Integer.parseInt(currentChar);
            			 int count = Character.getNumericValue(currentChar);
             //   if (i + 1 < input.length()) {
                    char nextChar = input.charAt(i - 1);
                    for (int j = 0; j < count; j++) {
                    	System.out.print(nextChar);
                        expanded.append(nextChar);
               //     }
                   // i++; // Skip the next character since it has been processed
                }
                    //System.out.println(count+"k" +currentChar);

            }
        }
       
        return expanded.toString();
    }

    public static void main(String[] args) {
        String input = "a2b3";
        String expandedString = expandString(input);
        //System.out.println("Expanded String: " + expandedString);
    }
}
// Java implementation of the approach
//public class GFG {
//
//	// Function to expand and print the given string
//	static void expandString(String strin)
//	{
//		String temp = "";
//		int j;
//
//		for (int i = 0; i < strin.length(); i++) {
//			if (strin.charAt(i) >= 0) {
//
//				// Subtract '0' to convert char to int
//				int num = strin.charAt(i) - '0';
//				if (strin.charAt(i + 1) == '(') {
//
//					// Characters within brackets
//					for (j = i + 1; strin.charAt(j) != ')'; j++) {
//						if ((strin.charAt(j) >= 'a'
//							&& strin.charAt(j) <= 'z')
//							|| (strin.charAt(j) >= 'A'
//								&& strin.charAt(j) <= 'Z')) {
//							temp += strin.charAt(j);
//						}
//					}
//
//					// Expanding
//					for (int k = 1; k <= num; k++) {
//						System.out.print(temp);
//					}
//
//					// Reset the variables
//					num = 0;
//					temp = "";
//
//					if (j < strin.length()) {
//						i = j;
//					}
//				}
//			}
//		}
//	}
//
//	// Driver code
//	public static void main(String args[])
//	{
//		String strin = "3(ab)4(cd)";
//		expandString(strin);
//	}
//}
