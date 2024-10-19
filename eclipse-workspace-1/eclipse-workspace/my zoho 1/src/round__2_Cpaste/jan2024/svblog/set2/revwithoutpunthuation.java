package round__2_Cpaste.jan2024.svblog.set2;

//3) Given a string, we have to reverse the string without changing the position of punctuations and spaces.
//
//Sample:   house no : 123@ cbe 
//
//Output:    ebc32 1o :  nes@ uoh 
public class revwithoutpunthuation {
public static String rev(String str) {
	int j=str.length()-1;
	int i=0;
	StringBuilder sb=new StringBuilder(str);
	while(i<=j) {
		if(str.charAt(i)==' '||str.charAt(i)=='@'||str.charAt(j)==':') {

					i++;
					continue;
			
		}
		if(str.charAt(j)==' '||str.charAt(j)=='@'||str.charAt(j)==':') {
			j--;
			
			continue;
			}
		char temp=str.charAt(i);
		sb.setCharAt(i, str.charAt(j));
		sb.setCharAt(j, temp);
		i++;
		j--;
		
	}
	return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ans=rev("house no : 123@ cbe");
		System.out.println(ans);
		System.out.println("ebc32 1o : nes@ uoh \n" +"house no : 123@ cbe");
		

	}

}
