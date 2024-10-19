
public class sumofweights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr= {10,36,54,89,12};
		int n= arr.length;
		 for (int i=0;i<n;i++) {
			  if (arr[i]%4==0&&arr[i]%6==0) {
				  
			  }
		 }
		
		

	}

}

/*
2. Given a set of numbers like <10, 36, 54,89,12> we want to find sum of weights based on the
following conditions
1. 5 if a perfect square
2. 4 if multiple of 4 and divisible by 6
3. 3 if even number
And sort the numbers based on the weight and print it as follows
<10,its_weight>,<36,its weight><89,its weight>
Should display the numbers based on increasing order.*/