package Set__5__pdf;

/*public class NumberToWords {

}
public class NumberToWords {
//    private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
//    private static final String[] teens = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
//    private static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	static  String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
      static String[] teens = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
     static String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        if (num < 10) {
            return units[num];
        }

        if (num < 20) {
            return teens[num - 10];
        }

        if (num < 100) {
            return tens[num / 10] + (num % 10 != 0 ? " " + units[num % 10] : "");
        }

        return units[num / 100] + " Hundred" + (num % 100 != 0 ? " and " + numberToWords(num % 100) : "");
    }

    public static void main(String[] args) {
        int num = 234;
        String words = numberToWords(num);
        System.out.println("Output: " + words); // Output: "Two Hundred and Thirty Four"
    }
}
*/
public class NumberToWords{
	static String [] units = { " ", "one","two","Three","four","five","six","seven","eight","nine"};
	static String [] teens = {" ","eleven"," twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	static String [] ten = {" ","ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninty"};
	public static   String numberToWords(int num) {
		if(num==0) {
			return "zero";
		}
		if(num<10) {
			return units[num];
		
		}
		if(num<100) {
			return ten[num/10]  +(num%10==0? " ": " " + units[num%10]);
		}
		return units[num/100] + " hundred " + (num%100==0?" ": "and "+ numberToWords(num%100));
		 //return units[num / 100] + " Hundred" + (num % 100 != 0 ? " and " + numberToWords(num % 100) : "");
		
	}
	
	public static void main(String args[] ){
		int num =234;
		//String l =numberToWords(num);
		  String l= numberToWords(num);
		  
		System.out.println(l);
		
	}
}

//public static void main(String[] args) {
//  int num = 234;
//  String words = numberToWords(num);
//  System.out.println("Output: " + words); // Output: "Two Hundred and Thirty Four"
//  }
//
//}






































