package round__2_Cpaste.jan2024.svblog.the100;
//23.  Given a number N. find the minimum count of numbers in which N can be represented as a sum of numbers x1, x2, … xn. where xi is number whose digits are 0s and 1s.
//
//example 1)  i/p :  N = 33
//
//o/p : count = 3.     33( 11 + 11 + 11 )
//
//some other possibilities of 33 is (11 + 11 + 10 + 1),   (11 + 10 + 10 + 1 + 1 ), (10 + 10 + 10 + 1 + 1 + 1)
public class ConvertN_numTo_1_0 {
	public  static int method(int n) {
		int ans=0;
		while(n>0) {
			if(n>11) {
				int sum=n/11;
				n=n%11;
				ans+=sum;
			}
			if(n>10) {
				int sum=n/10;
				n=n%10;
				ans+=sum;
			}
			if(n<10) {
				ans=ans+n;
				return ans;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(method(45));
	}

}
