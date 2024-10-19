package sept16;   /*Given an unsorted array of size N. Find the first element in array such that all of its left elements are smaller and all right elements to it are greater than it.
				
				Note: Left and right side elements can be equal to required element. And extreme elements cannot be required element.
				
	     			
				
		     		Example 1:
				
				Input:
				N = 4
				A[] = {4, 2, 5, 7}
				Output:
				5
				Explanation:
				Elements on left of 5 are smaller than 5
				and on right of it are greater than 5.
				
				
				Example 2:
				
				Input:
				N = 3
				A[] = {11, 9, 12}
				Output:
				-1
				
				
				*
				*
				* Java program to find the element which is greater than
// all left elements and smaller than all right elements.

import java.util.*;

class Main {
	// Function to check
	static boolean check(int arr[], int n, int ind)
	{
		int i = ind - 1;
		int j = ind + 1;

		while (i >= 0) {
			if (arr[i] > arr[ind]) {
				return false;
			}
			i--;
		}

		while (j < n) {
			if (arr[j] < arr[ind]) {
				return false;
			}
			j++;
		}

		return true;
	}

	// Function to return the index of the element which is
	// greater than all left elements and smaller than all
	// right elements.
	static int findElement(int arr[], int n)
	{

		// Traverse array from 1st to n-1 th index because
		// Extrem elements can't be aur answer
		for (int i = 1; i < n - 1; i++) {
			if (check(arr, n, i)) {
				return i;
			}
		}

		// If there was no element matching criteria
		return -1;
	}

	// Driver program
	public static void main(String[] args)
	{
		int arr[] = { 5, 1, 4, 3, 6, 8, 10, 7, 9 };
		int n = arr.length;
		System.out.println("Index of the element is "
						+ findElement(arr, n));
	}
}
*/

public class Left_Less_Right_Greater_Array_Index {
public static boolean check ( int arr[],int index,int len) {
	int left=index-1;
	int right =index+1;
	while(left>=0){
		if(arr[left]>arr[index]) {
			return false;
		}
//		if(arr[right]<arr[index]) {
//			return false;
//		}
		
		left--;
		//right++;
	}
	while(right<len){
//		if(arr[left]>arr[index]) {
//			return false;
//		}
		if(arr[right]<arr[index]) {
			return false;
		}
		
		//left--;
		right++;
	}
	///////
	return true;
	
}

public static int find(int arr[] ){
	int len=arr.length;
	for(int i=1;i<len-1;i++) {
		if(check(arr,i,len)) {
			return arr[i];
			
			}
	}
	return -1;
	//return -1;;
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr= {4,2,1,7,1,1,1,1,9,2,3,6,7,};
		int index=find(arr);
		int A[] = {11, 9, 12};//{11, 9, 12}    {4, 2, 5, 7}
		int index1 =find (A);
		System.out.print(
				index1);

	}

}
//Java program to remove duplicates

//class Main {
//
//	// Function to remove duplicate elements This function
//	// returns new size of modified array.
//	static int removeDuplicates(int arr[], int n)
//	{
//		// Return, if array is empty or
//		// contains a single element
//		if (n == 0 || n == 1)
//			return n;
//
//		int[] temp = new int[n];
//
//		// Start traversing elements
//		int j = 0;
//		for (int i = 0; i < n - 1; i++)
//			
//			// If current element is not equal to next
//			// element then store that current element
//			if (arr[i] != arr[i + 1])
//				temp[j++] = arr[i];
//
//		// Store the last element as whether it is unique or
//		// repeated, it hasn't stored previously
//		temp[j++] = arr[n - 1];
//
//		// Modify original array
//		for (int i = 0; i < j; i++)
//			arr[i] = temp[i];
//
//		return j;
//	}
//
//	// Driver code
//	public static void main(String[] args)
//	{
//		int arr[] = { 1, 2, 2, 3, 4, 4, 4, 5, 5 };
//		int n = arr.length;
//
//		// removeDuplicates() returns new size of array
//		n = removeDuplicates(arr, n);
//
//		// Print updated array
//		for (int i = 0; i < n; i++)
//			System.out.print(arr[i] + " ");
//	}
//}
//
////This code is contributed by Aditya Kumar (adityakumar129)
