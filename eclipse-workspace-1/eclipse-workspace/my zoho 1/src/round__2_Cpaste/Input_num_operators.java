package round__2_Cpaste;

import java.util.Arrays;
//public class Input_num_operators {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
import java.util.Stack;

public class Input_num_operators {//PostfixExpressionEvaluator
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
     int n=   expression.length();
        int arr[]=new int[n+1];
        char arr1[]=new char[n+1];
        int index=0;
for(int i=0;i<expression.length();i++) {
	
	
}

for (char ch:expression.toCharArray()) {
	arr1[index++]=ch;
}
System.out.print(arr1);
int num[]=new int[n];
int numindex=0;
int operatorindex=0;
int operator[]=new int[n];
for(int i=0;i<arr1.length;i++) {
	if(Character.isDigit(arr1[i])) {
		num[numindex++]=arr1[i];
	}
	else {
		operator[operatorindex++]=arr[i];
		
	}
	
}
int res=0;
int j=1;
//char operator2=(char)operator[j];
String operator2=""+operator[j];

//res=applyOperator(operator2,num[0],num[1]);

for(int i=0;i<numindex;i++) {
	//char operator1=Character.getNumericValue(operator[j]);
	String operator1=""+operator[j];
	//res=applyOperator(operator2,res,num[i]);
	System.out.print(operator2+num[i] +" ");
	j++;
	//res+=

//	if(i+1<numindex) {
//		
//	
//	}
	
}
int result=0;
System.out.print(" me " + res);
int a=0;
       for (String token : expression.split("\\s+")) {
    	   if(a==0) {
               if (isOperand(token)) {
                   stack.push(Integer.parseInt(token));
               } else if (isOperator(token)) {
                   int operand2 = stack.pop();
                   int operand1 = stack.pop();
 result =applyOperator(token,operand1,operand2);                   

                   stack.push(result);
               }
               a++;
           }

           if (isOperand(token)) {
               stack.push(Integer.parseInt(token));
           } else if (isOperator(token)) {
              // int operand2 = stack.pop();
               int operand1 = stack.pop();
 result =applyOperator(token,result,operand1);                   

               stack.push(result);
           }
    		   
    	   }

        if (!stack.isEmpty()) {
            return stack.pop();
        } else {
            throw new IllegalArgumentException("Invalid expression");
        }
//return index;
}
//
    private static boolean isOperand(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String token) {
        return token.matches("[+\\-*/]");
    }

    private static int applyOperator(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
//            default:
//                throw new IllegalArgumentException("Invalid operator: " + operator);
       }
		return operand2;
    }

    public static void main(String[] args) {
        String expression = "12345 * + - +";
        int result = evaluatePostfix(expression);
        System.out.println("Output: " + result); // Output: 6
    }
}












































