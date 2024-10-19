package round__2_Cpaste.jan2024.svblog.set5to9;
//
//5) Given a string, change the order of words in the string (last string should come first).
//
//Should use RECURSION
//
//Sample:   one two three 
//
//Output :  three two one 
public class revesewords {

	String rev (String str){
		String arr[]=str.split(" ");
		String res=arr[arr.length-1]+"";
		
		for(int i=arr.length-2;i>=0;i--) {
			res=res+" "+arr[i];
			
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		revesewords  obj=new revesewords();
String sol=obj.rev("one two three");
System.out.println(sol);
	}

}
