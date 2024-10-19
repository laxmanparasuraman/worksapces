import java.util.Arrays;
import java.util.Scanner;

public class nonRepeating {

	public static void main(String[] args) {
		// TODO Auto-generated method stubc
		System.out.println("prin");
		Scanner scr=new Scanner(System.in);
		String s=scr.nextLine();
		int len=s.length();
		//int arr[]=new int[26];
		int start=0;
		int end=0;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<len;i++) {
			//Arrays.fill(arr, 0);
			int arr[]=new int[26];
			boolean bool=true;
			for(int j=i;j<len;j++) {
				char ch=s.charAt(j);
				int index=ch-97;
				arr[index]++;
				if(arr[index]>1&&j-i>max) {
					max=j-i+1;
					start=i;
				     end =j;
				     break;
				     //bool=false;
				}
				
			}
		}
		for(int i=start;i<=end;i++) {
			System.out.print(s.charAt(i));
		}
	}

}
