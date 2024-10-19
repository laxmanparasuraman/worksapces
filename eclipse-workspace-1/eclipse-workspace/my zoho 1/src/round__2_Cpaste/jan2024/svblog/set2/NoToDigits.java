package round__2_Cpaste.jan2024.svblog.set2;
//5. Let 1 represent ‘A’, 2 represents ‘B’, etc. Given a digit sequence, count the number of possible decodings of the given digit sequence.
//
//Examples:
//
//Input: digits[] = “121”
//
//Output: 3 // The possible decodings are “ABA”, “AU”, “LA”
//
//Input: digits[] = “1234” Output: 3

// The possible decodings are “ABCD”, “LCD”, “AWD
public class NoToDigits {
public static void generatewords(String num,int ind,String str) {
	if(ind==num.length()) {
		System.out.println(str);
		return;
	}
	int index=num.charAt(ind)-'1';
	//System.out.print(index);
	char ch=(char)('A'+index);
	generatewords(num,ind+1,str+ch);
	if(ind+1<num.length()) {
		int two=Integer.parseInt(num.substring(ind, ind+2));
		if(two>=10&&two<=26) {
			char letter=(char)('A'+two-1);
			generatewords(num,ind+2,str+letter);
			
		}
	}
	
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="1234";
		generatewords(str,0,"");

	}

}
