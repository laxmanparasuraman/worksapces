package round__2_Cpaste.jan2024.svblog.set2;
//.Given a sentence of string, in that remove the palindrome words and print the remaining.
//
//Input:
//
//He did a good deed
//
//Output:
//
//He good
//
//Input:
//
//Hari speaks malayalam
//
//Output:
//
//Hari speaks
public class RemovePalindrome {
	
	public static boolean ispalindrome(String str) {
		int n =str.length();
		for(int i=0;i<n;i++) {
			if(str.charAt(i)!=str.charAt(n-i-1)) {
				return false;
			}
		}
		return true;
				
				
	}
public static String print(String str) {
	String s[]=str.split(" ");
	for(int i=0;i<s.length;i++) {
		if(!ispalindrome(s[i])) {
			System.out.print(s[i]+" ");
		}
	}
	
	
	return "";
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print("Hari speaks malayalam");
		print("He did a good deed");
	}

}
