package sept16;

import java.util.Arrays;

public class Mov_0_last {
	public static void main(String args[]) {
		 int a[]= {0,1,4,3,12,0,0,0,0,2};
		 int a1=a.length;
		 for(int i=0;i<a1;i++) {
			 for(int j=i+1;j<a1;j++) {
			 if(a[i]>a[j]) {//if==0
				 int temp=a[i];
				 a[i]=a[j];
				 a[j]=temp;
			 }
		 }
		 }
		 System.out.print(Arrays.toString(a));
		
	

}
}
