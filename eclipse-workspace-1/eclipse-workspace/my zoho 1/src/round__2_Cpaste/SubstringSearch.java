package round__2_Cpaste;

public class SubstringSearch {
    public static void main(String[] args) {
        String string1 = "test123string";
        String string2 = "123";

        int index = findSubstringIndex(string1, string2);

        if (index != -1) {
            System.out.println("String2 is a substring of String1 at index: " + index);
        } else {
            System.out.println("String2 is not a substring of String1.");
        }
    }

    private static int findSubstringIndex(String string1, String string2) {
        int len1 = string1.length();
        int len2 = string2.length();

        for (int i = 0; i <= len1 - len2; i++) {
            int j;
            boolean bool=true;

            for (j = 0; j < len2; j++) {
            	 bool=true;
                if (string1.charAt(i + j) != string2.charAt(j)) {
                    bool=false;
                	break;
                }
            }

            if (j == len2&&bool) {
                return i; // Found a match, return the starting index
            }
        }

        return -1; // No match found
    }
}
