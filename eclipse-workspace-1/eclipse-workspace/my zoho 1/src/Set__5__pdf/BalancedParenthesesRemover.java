package Set__5__pdf;
import java.util.*;

//import java.util.*;
//public class BalancedParenthesesRemover {
//    public static void main(String[] args) {
//        String input1 = "((abc)((de))";
//        String input2 = "(((ab)";
//
//        String output1 = removeUnbalancedParentheses(input1);
//        String output2 = removeUnbalancedParentheses(input2);
//
//        System.out.println("Input 1: " + input1);
//        System.out.println("Output 1: " + output1);
//        System.out.println("Input 2: " + input2);
//        System.out.println("Output 2: " + output2);
//    }
//
//    public static String removeUnbalancedParentheses(String expression) {
//        Stack<Character> stack = new Stack<>();
//        StringBuilder result = new StringBuilder();
//
//        for (char c : expression.toCharArray()) {
//            if (c == '(') {
//                stack.push(c);
//                result.append(c); // Append opening parenthesis to the result
//            } else if (c == ')' && !stack.isEmpty()) {
//                stack.pop();
//                result.append(c); // Append closing parenthesis to the result
//            } else if (c != ')') {
//                result.append(c); // Append other characters to the result
//            }
//        }
///* firstOpenIndex!=0              Input 1: ((abc)((de))    Input 1: ((abc)((de))                     
// if not                          Output 1: (abc)((de))     Output 1: ((abc)(de))
//                               Input 2: (((ab)           Input 2: (((ab)
//                               Output 2: (ab)             Output 2: (ab)                                                        */
//        // Remove the first occurrence of an opening parenthesis if unbalanced
//        if (!stack.isEmpty()) {
//            int firstOpenIndex = result.indexOf("(");
//            if (firstOpenIndex != -1&& firstOpenIndex!=0) {
//                result.deleteCharAt(firstOpenIndex);
//                stack.pop();
//            }
//        }
//
//        // Remove the last occurrence of an opening parenthesis if unbalanced
//        while (!stack.isEmpty()) {
//            int lastOpenIndex = result.lastIndexOf("(");
//            if (lastOpenIndex != -1) {
//                result.deleteCharAt(lastOpenIndex);
//                stack.pop();
//            }// else {
////                stack.pop();
////            }
//        }
//
//        return result.toString();
//    }
//}



//public class kk {
//
//}
import java.util.*;

public class BalancedParenthesesRemover {
  public static void main(String[] args) {
      String input1 = "((abc)((de))))";
      String input2 = "((ab)";

      String output1 = removeUnbalancedParentheses(input1);
      String output2 = removeUnbalancedParentheses(input2);

      System.out.println("Input 1: " + input1);
      System.out.println("Output 1: " + output1);
      System.out.println("Input 2: " + input2);
   System.out.println("Output 2: " + output2);
  }

  public static String removeUnbalancedParentheses(String expression) {
      Stack<Character> stack= new Stack<>();
      String str="ll";
     // str.
      //char c;
      
      StringBuilder result = new StringBuilder();
     // ArrayList<String> result= new ArrayList<>();

      for (char c : expression.toCharArray()) {
          if (c == '(') {
              stack.push(c);
              result.append(c);
          } else if (c == ')' && !stack.isEmpty()) {
              stack.pop();
              result.append(c);
          } else if (c != ')') {
              result.append(c);
          }
          
      }

      while (!stack.isEmpty()) {
          stack.pop();
          result.deleteCharAt(result.lastIndexOf("("));
      }
      result.delete(0, 0);

      return result.toString();
  }
}

