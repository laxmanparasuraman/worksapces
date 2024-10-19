package gfg;

//public class Pattern_cross {
	public class Pattern_cross {
	    public static void printOddLetterPattern(char[][] pattern) {
	        int n = pattern.length;
	        int mid = n / 2;

	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (i == j || i + j == n - 1) {
	                    pattern[i][j] = (char) ('A' + (mid - Math.abs(mid - i)));
	                } else {
	                    pattern[i][j] = ' ';
	                }
	            }
	        }

	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                System.out.print(pattern[i][j]);
	            }
	            System.out.println();
	        }
	    }

	    public static void main(String[] args) {
	        int size = 7;
	        char[][] pattern = new char[size][size];
	        printOddLetterPattern(pattern);
	    }
	}



//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
