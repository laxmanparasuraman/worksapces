package round__2_Cpaste.jan2024.svblog.the100;
//3. Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes. For example, in an array A:

//Example :
//
//Input: A[] = {-7, 1, 5, 2, -4, 3, 0}
//
//Output: 3
//
//3 is an equilibrium index, because:
//
//A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
//
//Input: A[] = {1, 2, 3}
//
//Output: -1
public class Equlibriumindexofarrary {
int   index(int arr[]) {
	int totalsum=0;
	int len=arr.length;
	for(int i=0;i<len;i++) {
		totalsum+=arr[i];
	}
	int leftsum=0;
	for(int i=0;i<len;i++) {
		totalsum-=arr[i];
		if(totalsum==leftsum) {
			return i;
		}
		leftsum+=arr[i];
	}
	return -1;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={-7, 1,4, 5, 2, -4, 3, 0,4};
		Equlibriumindexofarrary obj=new Equlibriumindexofarrary(); 
	int res=	obj.index(arr);
System.out.println(res);
	}

}
