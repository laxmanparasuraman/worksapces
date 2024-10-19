import java.util.Arrays;

public class substring {

	//public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//int a[] = { 9, 1, 8, 2, 7, 3, 6, 4, 5 }; // consider the sub string size is 3 and find the max of xub string

		public static int[] subs_tring(int a [], int b) {
			
			int c =a.length;
			int result[]=new int[c-b+1];
			int idx =-1;
			
			for(int i=0; i<=c-b;i++){
				 //int i;
				int Tmax= a[i];
				for(int j=1;j<3;j++) {
					Tmax=Math.max(Tmax, a[j+i]);//[7, 7, 7, 6, 5, 3, 4]
					
					
				}
				result[++idx]=Tmax;
				System.out.print(Tmax+" ");
						
			}
			return result;
		}
			
			
			
			public static void main (String[] args) {
				//int n[]= {9,1,8,2,7,3,6,4,5};
				int m[]={3, 2, 7, 6, 5, 1, 2, 3, 4};
				
				int k =3;
				subs_tring (m
						,k);
//				int res[]= subs_tring (m
//						,k);
//				int n=res.length;
//			
//				System.out.println(Arrays.toString(res));
//                     // System.out.println(IntStream.of(res).collect(Collectors.toList));
//				
		}
		}

	


