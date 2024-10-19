package round__2_Cpaste.jan2024;


//Java program to find longest common prefix of
//given array of words.
import java.util.*;

public class GFGlongestCommonPrefix
{
 public String longestCommonPrefix(String[] arr)
 {
    int n = arr.length;
    // take temp_prefix string and assign first element of arr : a.
    String result = arr[0];
    
    // Iterate for rest of element in string.
    for(int i = 1; i < n; i++){
         // .indexOf() return index of that substring from string.
         
         System.out.print(arr[i].indexOf(result)+"   lll  ");
         //arr[i].indexo
      
         while(arr[i].indexOf(result) != 0){
            System.out.print(arr[i].indexOf(result)+"  in ");
             System.out.print( result+" "+ i+"before  ");
             // update matched substring prefx
             result = result.substring(0, result.length()-1);
              System.out.println( result+" i"+ i);
            
            
             // check for empty case. direct return if true..
             if(result.isEmpty()){
                 return "-1";
             }
         }
          
     }
          
     return result;
 }

 /* Driver Function to test other function */
 public static void main(String[] args)
 {
	 GFGlongestCommonPrefix gfg = new GFGlongestCommonPrefix();
     String[] input = { "geezer","geeksforgeeks", "geeks", "geek"};
     System.out.println( "The longest Common Prefix is : " +
                                gfg.longestCommonPrefix(input));
 }
}
