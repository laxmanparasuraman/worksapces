package round__2_Cpaste.jan2024.svblog.the100;
/*60. Print longest sequence between same character

Ex I/p cabcccccbba

O/p 8 (from a to a)

I/p aaaaaaaa

O/p 6
*/
public class PrintlongestSubBtwSameChar {
	public static int actualseq(String str) {
		int len= str.length();
		int start=0;
		int max=0;
		for(int i=1;i<len;i++) {
			if(str.charAt(i)!=str.charAt(i-1)) {
				max=Math.max(max, i-start);
				start=i;
			}
		}
		return max+1;//covert to 1 basr indes
		}
	
 public static int Seq(String Str,int start,int end) {
//	 int len=Str.length();
//			 int start=0;
//			 int end=len-1;
	 if(start<0||end<0)return 0;
 			 int max=0;
			// while(start<=end) {
				 if(Str.charAt(start)==Str.charAt(end)) {
					 //System.out.println(end+" "+start);
				return	 max=end-start-1;
//					 start--;
//					 end--;
				 }
				 else {
					 return Math.max(Seq(Str,start,end-1), Seq(Str,start+1,end));
				 }
				 
			 //}
			// System.out.println(Str.charAt(end));
					 
	// return 0;
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="dabcccccbba";
		String str1="aaaaaaaa";
		 int len=str1.length();
		 System.out.println("length is " + len);
		 int start=0;
		 int end=len-1;
		 //int max=0;
		System.out.println(Seq(str1,start,end));
	//	System.out.println(actualseq(str));

	}

}
