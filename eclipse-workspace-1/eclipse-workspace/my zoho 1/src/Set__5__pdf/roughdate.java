package Set__5__pdf;
import java.util.*;
public class roughdate {
	public static void main(String args[]) {
	String str[]=new String[3];
	Scanner scr =new Scanner(System.in);
	//System.out.println("print date");
	System.out.println("date");
	String str1=scr.nextLine();
	str=str1.split(":");
	int date=Integer.parseInt(str[0]);
	int mon=Integer.parseInt(str[1]);
	int year=Integer.parseInt(str[2]);
	System.out.print(date+"  "+mon+" "+year);
	}
}
