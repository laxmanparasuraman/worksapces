package round__2_Cpaste.jan2024.svblog.set5to9;

//1) Given an array, find the minimum of all the greater numbers for each element in the array.  
//
//Sample: 
//
//Array : {2, 3, 7, ­1, 8, 5, 11} 
//
//Output: 
//
//{2­>3, 3­>5, 7­>8, ­1­>2, 8­>11, 5­>7, 11­>} 

public class minofgreater {
void next(int  arr[] ){
	int len = arr.length;
	for(int i=0;i<len;i++) {
		int min=Integer.MAX_VALUE;
		boolean bool=false;
		for(int j=0;j<len;j++) {
	if(arr[j]>arr[i]) {
		min=Math.min(min, arr[j]);
		bool=true;
	}
	
		}
if(bool) {
	System.out.print(arr[i]+" -> "+ min+" ");
}
if(!bool) {
	System.out.print(arr[i]+" -> "+" ");
	
}
if(i!=len-1) {
	System.out.print(",");
}
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int arr[]={12,2, 3, 7,-1, 8, 5, 11};
minofgreater obj=new minofgreater();
obj.next(arr);
//next(arr);
	}

}
