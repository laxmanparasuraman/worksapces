package round__2_Cpaste.jan2024.svblog;
//1. Pangram Checking
//
//Check whether all english alphabets are present in the given sentence or not
//
//I/P: abc defGhi JklmnOP QRStuv wxyz
//
//O/P: True
//
//I/P: abc defGhi JklmnOP QRStuv
//
//O/P: False1. Pangram Checking

 
//


public class panagramcheck {

		public static  boolean Ispangram(String str) {
			
			int arr[]= new int[26];
            str =str.toLowerCase();
            int n=str.length();
            for(int i=0;i<n;i++) {
            	char c=str.charAt(i);
            	if(Character.isLetter(c)) {
            		arr[c-'a']++;	
            	}
            	
            }
            for (int i=0;i<26;i++) {
            	if(arr[i]==0) {
            		return  false;
            	}
            }
            
			
			return true;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s="abc defGhi JklmnOP QRStuv wxyz";
String s1="abc defGhi JklmnOP QRStuv";
System.out.println(Ispangram(s)+"    "+Ispangram(s1));
	}

}