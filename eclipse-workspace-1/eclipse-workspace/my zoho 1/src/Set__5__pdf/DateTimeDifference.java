package Set__5__pdf;
import java.util.*;

public class DateTimeDifference {
	 
	public static void main(String args[]) {
		Scanner input=new Scanner(System.in);
		System.out.print(" date : month: Year  in format");
		String date1=input.nextLine();
		//System.out.print(date1);
		date method =new date(date1);
		String res= method.getdate();
		System.out.println(res);
		String res1= method.getmonth();
		System.out.println(res1);
		String res2= method.getyear();
		int res3=Integer.parseInt(res2);
		res3--;
		System.out.println(res3);
		
		
	}
	//public static re
	

}
class date{
	int Date;
	int month;
	int year;
	char[] input;
	String date1;
	String month1;
	String str1;
	String year1;
	public date(String str){
		input=str.toCharArray();
		str1=str;
	//}
		
	String value []=new String[5];
	int index=0;
	int k=0;
	int m=0;
	
   for(int i=0;i<input.length;i++) {
	   int j=i;
	   if(m==2)j=input.length;
	if(input[i]== ':'||m==2) {
		value[index++]=str1.substring(k,j);
		k=i+1;
		m++;
		}
		}
 date1 =value[0];
 month1 =value [1];
 year1= value [2];
	}
public String getdate() {
	return date1;
}
public String getmonth() {
	return month1;
}
public String getyear() {
	return year1;
}


}

