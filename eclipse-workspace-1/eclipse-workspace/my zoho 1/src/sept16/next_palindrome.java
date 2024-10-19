package sept16;
import java.util.*;

public class next_palindrome {
public static boolean ispalindrome(String n) {
	int n1 =n.length();
	for(int i=0;i<n1/2;i++) {
		if(n.charAt(i)!=n.charAt(n1-i-1)) {
			return false;
		}
		
	}
	return true;
	
}
//int input=0;
//Scanner scr =new Scanner(System.in);
public static void main (String args[]) {
Scanner scr =new Scanner(System.in);
int input=scr.nextInt();
String k;
//do
//{
//	 k =""+input;
//	input++;
//
//} while(!ispalindrome(k))// {
//	 //k++;
//	 
// //}
//k =""+input;
for(int i=input+1;i>=0;i++) {
	k =""+i;
	if(ispalindrome(k)) {
		System.out.print(k);
		break;
	}
}
}
}
