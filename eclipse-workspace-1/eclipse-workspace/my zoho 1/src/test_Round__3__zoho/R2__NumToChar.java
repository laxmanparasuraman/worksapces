package test_Round__3__zoho;

import java.util.Scanner;

//java.util.*;

/*1) Given a number, convert it into corresponding alphabet.
Input Output
 1 A
 26 Z
 27 AA
 676 ZZZ

*/
public class R2__NumToChar {
	public static void main(String[]args) {
		Scanner input= new Scanner(System.in);//Scanner scanner = new Scanner(System.in);
		int num=input.nextInt();
		//for()
		if(num<=26&&num>0) {
			num+=64;
			System.out.println((char)num);
			}
		else if (num>26) {
			while(num>0) {
				num=num%26;
				//num+=64;
						int num1=num+64;
				System.out.println((char)num1);
				//num/=26;
				
				
			}
			
			
		}
	
	}
}
