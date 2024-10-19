import java.util.Scanner;

public class Pattern_Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input;
		System.out.println("string");
		Scanner scr = new Scanner(System.in);
//		scr.close();
		input= scr.nextLine();
		int n=input.length();
		scr.close();
		System.out.println(n);
		for(int i=0;i<n;i++) {
			for(int j =0;j<n;j++) {
				if(i==j) {
					System.out.print(input.charAt(i));
				}
				else if (i+j==n-1) {
					System.out.print(input.charAt(i));
					
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		

	}

}
