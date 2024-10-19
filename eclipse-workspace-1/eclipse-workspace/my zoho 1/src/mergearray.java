import java.util.*;
public class mergearray {
	
    public static int []merger(int[] ar1, int[]ar2){
		
		int l1= ar1.length;
		int l2= ar2.length;
		//int i, j, k;
		int i =0;
		int j=0;
		int k=0;
		int merge[]=new int[l1+l2];
		
		
		while((i<l1)&&(j<l2)) {                                                    // int[] arr1 = {1, 2, 3, 6, 9};
	                                                                                // int[] arr2 = {2, 4, 5, 10};

			
			if (ar1[i]<ar2[j]) {
				merge[k++]= ar1[i++];
				
			}
			else if(ar1[i]>ar2[j]){
				merge[k++]= ar2[j++];
				
				
			}
			else {
				merge[k++]=ar1[i++];
				j++;
			}
		}
			 while(i<l1) {
				 merge[k++]=ar1[i++];
			    	
			    }
			 while(j<l2) {
				 merge[k++]=ar2[j++];
			    	
			    }
		
		int k1=remove(merge);
		return Arrays.copyOf(merge, k1);
    }
    public static int remove(int arr[]) {
    	int n=arr.length;
    	sort(arr);
    	int j=0;
for(int i=0;i<n;i++) {
	if(arr[j]!=arr[i]) {
		arr[++j]=arr[i];
	}
}
return j+1;
    }
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Scanner scr = new Scanner(System.in);
		//int ar
		 int[] arr1 = {1, 2, 3, 6, 9};
		 
	        int[] arr2 = {2,2,2,2, 4, 5,5,5,5, 10,10,10,2};

	        int[] mergerd = merger(arr1, arr2);

	        System.out.println("Merged Array: " + Arrays.toString(mergerd));
		

		
	}
public static void sort(int arr[]) {
	int n =arr.length;
	System.out.println(Arrays.toString(arr)+"  before sort   ");
	for(int i=0;i<n;i++) {
		for (int j=i;j<n;j++) {
			if(arr[i]>arr[j]) {
				int temp =arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
	}
	System.out.println(Arrays.toString(arr)+" aafter   sort ");
}

}
//import java.util.*;

//public class mergearray {
//    public static int[] mergeArrays(int[] arr1, int[] arr2) {
//        int n1 = arr1.length;
//        int n2 = arr2.length;
//        int[] merged = new int[n1 + n2];
//        
//        int i = 0, j = 0, k = 0;
//        while (i < n1 && j < n2) {
//            if (arr1[i] < arr2[j]) {
//                merged[k++] = arr1[i++];
//            } else if (arr1[i] > arr2[j]) {
//                merged[k++] = arr2[j++];
//            } else {
//                merged[k++] = arr1[i++];
//                j++;
//            }
//        }
//        
//        while (i < n1) {
//            merged[k++] = arr1[i++];
//        }
//        
//        while (j < n2) {
//            merged[k++] = arr2[j++];
//        }
//        
//        return Arrays.copyOf(merged, k);
//    }
//
//    public static void main(String[] args) {
//        int[] arr1 = {1, 2, 3, 6, 9};
//        int[] arr2 = {2, 4, 5, 10};
//
//        int[] mergedArray = mergeArrays(arr1, arr2);
//
//        System.out.println("Merged Array: " + Arrays.toString(mergedArray));
//    }
//}
