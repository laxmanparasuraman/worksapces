package round__2_Cpaste.jan2024.svblog.the100;
/*8. Q2. Print all possible subsets of the given array whose sum equal to given N.

example: Input: {1, 2, 3, 4, 5} N=6 Output: {1, 2, 3}, {1, 5}, {2, 4}*/
public class printset_equalstosum_n {
	
	static void sum(int arr[],int n) {
		int len=arr.length;
		for(int i=0;i<len;i++) {
			int sum=arr[i];
			for(int j=i+1;j<len;j++) {
				if(sum==n) {
					print(i,j,arr);
					
				}
				sum=sum+arr[j];
				
				
			}
		}
		
	}
	static void print(int start,int end,int arr[]) {
		System.out.print(  start+"  "+end +"{  "  );
		for(int i=start;i<end;i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println("}");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int arr[]={1, 2, 3, 4, 5};
int n=6;
sum(arr,n);
	}

}
