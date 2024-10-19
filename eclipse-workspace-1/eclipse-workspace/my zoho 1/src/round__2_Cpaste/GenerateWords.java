package round__2_Cpaste;

public class GenerateWords {
    public static void main(String[] args) {
        String input = "123";
        generateWords(input, 0, "");
//        generateWords2(input, 0, "");
      //  System.out.println(input.substring(1, 1 + 2));  
        }

    public static void generateWords(String input, int index, String currentWord) {
        if (index == input.length()) {
            System.out.println(currentWord);
            return;
        }

        // Process single-digit number as a letter (A=1, B=2, ...)
        int singleDigit = input.charAt(index) - '1';
        char letter = (char) ( 'A'+ singleDigit );
        generateWords(input, index + 1, currentWord + letter);

        // Process two-digit number if possible
        if (index + 1 < input.length()) {
            int twoDigits = Integer.parseInt(input.substring(index, index + 2));
            if (twoDigits >= 10 && twoDigits <= 26) {
                char twoDigitLetter = (char) ('A' + twoDigits - 1);
                generateWords(input, index + 2, currentWord + twoDigitLetter);
            }
        }
    }
//    public static void generateWords2(String input, int index, String currentWord) {
//    	if (index == input.length()) {
//            System.out.println(currentWord);
//            return;
//        }
//    	if (index + 1 < input.length()) {
//        int twoDigits = Integer.parseInt(input.substring(index, index + 2));
//        if (twoDigits >= 10 && twoDigits <= 26) {
//            char twoDigitLetter = (char) ('A' + twoDigits - 1);
//            generateWords(input, index + 2, currentWord + twoDigitLetter);
//        }
//    }
//}
}
