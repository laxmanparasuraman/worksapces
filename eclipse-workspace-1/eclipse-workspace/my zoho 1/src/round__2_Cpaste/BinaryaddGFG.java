package round__2_Cpaste;
//
////public class BinaryaddGFG {
////
////}
////java program to add
////two binary strings
//
//public class BinaryaddGFG {
//	// This function adds two
//	// binary strings and return
//	// result as a third string
//	static String addBinary(String A, String B)
//	{
//		// initialize the ith index
//		int i = A.length()-1;
//		// initialize the jth index
//		int j = B.length()-1;
//		// initialize the carry
//		int carry = 0;
//	// initialize the sum
//		int sum = 0;
//		StringBuilder result = new StringBuilder();
//		while(i>=0 || j>=0 || carry == 1){
//			sum = carry;
//			if(i>=0) sum = sum+A.charAt(i)-'0';
//			if(j>=0) sum = sum+B.charAt(j)-'0';
//			result.append((char)(sum%2+'0'));
//			carry = sum/2;
//			i--;
//			j--;
//		}
//		return result.reverse().toString();
//	}
//
//	//Driver code
//	public static void main(String args[])
//	{
//		String a = "11001", b="1010";
//		
//		System.out.print(addBinary(a, b));
//	}
//}

//This code is contributed by Sam007.
//A bit improvement by Mustak Ahmed
import java.util.*;




public class BinaryaddGFG{
	public static  String binary(String a,String b) {
		int alen=a.length()-1;
		int blen=b.length()-1;
		int sum=0;
		int carry=0;
		String result1="";
		StringBuilder result = new StringBuilder();
		while(alen>=0||blen>=0|| carry==1) {
			sum = carry;
			if(alen>=0)sum=sum+a.charAt(alen)+0;System.out.print(sum +" l");
			if(blen>=0)sum=sum+b.charAt(blen)+0;System.out.print(sum);
			//sum =sum%2;
			System.out.println("   alen  blen  "+sum%2);
			result.append((char) (sum%2+' '));
result1=result1+ (sum%2+"");
			carry =sum/2-'0';
			System.out.print(carry+ " c ");
			alen--;
			blen--;
					
		}
//		return result;
		//return result.toString();
		int z=result.length();
	System.out.println(result1 +" k");
		return result.reverse().toString();
		
	}
	public static void main (String args[]) {
		Scanner scr = new Scanner(System.in);
		int x = scr.nextInt();
		if(true) {
			System.out.println("loki");
		}
		String a = "1100", b="1010";
		//String k  =binary(a, b);
		System.out.println(binary(a, b)+" l " );
		String str="11" ;
		int m=str.charAt(0)-'0';
		char m1 =(char) (str.charAt(0)-'0');
		
		System.out.print(m+" l ");
	}
}
