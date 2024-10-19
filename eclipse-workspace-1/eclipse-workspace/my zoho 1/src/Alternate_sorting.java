import java.util.*;
public class Alternate_sorting {

	
	public static int[] asort(int []arr){
		Arrays.sort(arr);
		int left =0;
		int n=arr.length;
		int right=n-1;
		int res[]=new int[n];
		for(int i=0;i<n;i++) {
			if(i%2==0) {
				res[i]=arr[right--];
				
			}
			else {
				res[i]=arr[left++];
			}
//			return res;
		}
		return res;
		
		
		
	}
	public static void main(String[] args) {
        // TODO Auto-generated method stub
int arr[] =  {1, 2, 3, 4, 5, 6, 7};//{5,3,9,4,7,8};
int arr1[] =  {5,3,9,4,7,8};
int arr2[]= {1,2,3,4,5};

System.out.println(Arrays.toString(arr2)+" nan dhan");

                //Scanner scr =new Scanner(System.in);
int asorted[]=asort(arr);
System.out.println(Arrays.toString(asorted));
int asorted1[]=asort(arr1);
int asorte2[]=asort(arr2);
System.out.println(Arrays.toString(asorte2)+" nan dhan");
Arrays.sort(asorted1);
//System.out.println(Arrays.toString(Arrays.sort(asorted1)));
String arre=Arrays.toString(asorted1);
System.out.println(Arrays.toString(asorted1));
System.out.println(arre.substring(1,arre.length()-1));


}
}

