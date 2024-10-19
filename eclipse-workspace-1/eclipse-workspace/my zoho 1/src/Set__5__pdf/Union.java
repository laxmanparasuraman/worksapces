package Set__5__pdf;

//import java.lang.reflect.Array;
import java.util.*;

public class Union {                                                                                   // Program 3:
//                                                                                                      	//Find the union intersection of two list and also 
//                                                              	                                        //find except (remove even elements from list1 and
//		                                                                                                      //	//odd elements from list2)
//		                                                                                                          //	Input
//		                                                                                                    	//List 1: 1,3,4,5,6,8,9
//	                                                                                                       		//List 2: 1, 5,8,9,2
//			                                                                                                    //Union: 1, 3,4,5,6,8,9,2
//			                                                                                                    //Intersection: 1,5,8,9
//			                                                                                                    //Except: 1, 3, 5,9,8,2 
//
//	public Union() {
//		// TODO Auto-generated constructor stub
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[]= {1,3,4,5,6,8,9};
		int arr2[]= {1, 5,8,9,2};
        int union[] = FindUnion(arr1,arr2);
        int[]Fintersection= FinIntersection(arr1,arr2);
        System.out.println(Arrays.toString(union));
        System.out.println(Arrays.toString(Fintersection));
	}
        
        public static int[]FindUnion(int[] ar1, int[]ar2) {
        	int a1l= ar1.length;
        	int a2l= ar2.length;
        	int index =0;
        	int  res[] = new int[a1l+a2l];
        	for( int num:ar1) {
        		 res[index++]=num;
        	}
        	for(int num :ar2) {
        		boolean bool=true;
        		for(int check :ar1) {
        			if(check==num) {
        				bool=false;
        			break;
        			}
        	
        		}
        		if(bool) {
        			res[index++]=num;
        			//bool=false;
                			
        		}
        	}
        	 return Arrays.copyOf(res,index);
        }
        
        public static int[]FinIntersection(int[] ar1, int[]ar2) {
        	int a1l= ar1.length;
        	int a2l= ar2.length;
        	int index =0;
        	int  res[] = new int[a1l+a2l];
//        	for( int num:ar1) {
//        		 res[index++]=num;
//        	}
        	for(int num :ar2) {
  //      		boolean bool=true;
        		for(int check :ar1) {
        			if(check==num) {
        				res[index++]=num;
        				  
        			//	bool=false;
        			//break;
        			}
        	
        		}
//        		if(bool) {
//        			res[index++]=num;
//        			//bool=false;
//                			
//        		}
        	}
        	 return Arrays.copyOf(res,index);

       
        		
	}
}

