package sept16;

import java.util.Arrays;

public class Array_traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int [] arr= {1,2,3,4,5,6,7};
		 rotate(arr);
		 rotate(arr);
		 rotate(arr);
		 
		 System.out.print(Arrays.toString(arr));
		
	}
	 public static int[] rotate(int arr[]) {
		 int len=arr.length;
		 int last =arr[len-1];
		 for(int i=len-1;i>0;i--) {
			 arr[i]=arr[i-1];
					 }
		 arr[0]=last;
		 
		 return arr;
	 }


}
