package sept16;
import java.util.*;

public class occurence { 

    public static String countCharacters(String inputString1) {
        int[] charCount = new int[26]; // Assuming ASCII characters
String inputString=inputString1.toLowerCase();
        // Count the occurrences of each character in the input string
        for (int i = 0; i < inputString.length(); i++) {
            charCount[inputString.charAt(i)-97]++;
        }

        // Create the formatted result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            int count = charCount[c-97];
            if (count > 0) {
                result.append(c).append(count);
                //charCount[c-97] = 0; // Set count to 0 to avoid duplicate counting
            }
        }

        return result.toString();
    }
//}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String input=in.nextLine();
		int len =input.length();
		set Set[]=new set[len];
		for(int i=0;i<len;i++) {
			Set[i]=new set(input.charAt(i),i);
		//	set=
			System.out.print(Set[i].getnum());
			System.out.print(Set[i].getchar());
		}
//		System.out.println(Arrays.toString(Set));
//		System.out.print(Set);
		 String inputString = "laxman";
	        String result = countCharacters(inputString);
	        System.out.println(result); // Output: "l1a2x1m1n1"
	    
	}
	//public
	

}
class set{
	char ch;
	int num;
	set(char ch,int num){
		this.ch=ch;
		this.num=num;
		
	}
	public char getchar() {
		return ch;
	}
	public int getnum() {
		return num;
	}
//	public set getset() {
//		return set;
//	}
}
