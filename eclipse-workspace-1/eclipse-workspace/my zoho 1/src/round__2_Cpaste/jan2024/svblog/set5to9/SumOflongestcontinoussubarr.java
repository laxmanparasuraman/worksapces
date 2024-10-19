package round__2_Cpaste.jan2024.svblog.set5to9;
//2) Find the largest sum contiguous subarray which should not have negative numbers. We have to print the sum and the corresponding array elements which brought up the sum.
//
//Sample: 
//
//Array : {­2, 7, 5, ­1, 3, 2, 9, ­7} 
//
//Output: 
//
//     Sum : 14 
//
//     Elements : 3, 2, 9
public class SumOflongestcontinoussubarr {
int sum(int arr[]) {
	int len=arr.length;
	int ans=0;
	for(int i=0;i<len;i++) {
//		if(arr[i]<0) {
//			continue;
//		}
	
		System.out.print(arr[i]+" ");
		int sum=arr[i];
		for(int j=i+1;j<len;j++) {
			if(arr[j]<0) {
				break;
			}
			System.out.print(arr[j]);
			sum=sum+arr[j];
		if(sum>ans) {
			ans=sum;
		}
		System.out.println();
		}
		
	}
	return ans;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumOflongestcontinoussubarr obj=new SumOflongestcontinoussubarr();
		int arr[]={-2, 7, 5, -1, 3, 2, 9, -7};
		int sol=obj.sum(arr);
	System.out.println(sol);
	}

}
