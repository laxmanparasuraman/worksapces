package Set__5__pdf;

//public class a {

//}
import java.util.Stack;

public class ValidMathExpressionWithOperators {
    public static boolean isValidExpression(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false; // Unmatched closing parenthesis
                }
                stack.pop();
            } else if (isValidOperator(ch)) {
                if (stack.isEmpty() || !isValidOperator(stack.peek())) {
                    return false; // Invalid operator position
                }
                stack.pop(); // Pop the previous operator
            }
        }

        return stack.isEmpty();
    }

    public static boolean isValidOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static void main(String[] args) {
        String expression1 = "(a+b)(a*b)";
        String expression2 = "(ab)(ab+)";
        String expression3 = "a+b";

        System.out.println("Expression 1: " + (isValidExpression(expression1) ? "Valid" : "Invalid"));
        System.out.println("Expression 2: " + (isValidExpression(expression2) ? "Valid" : "Invalid"));
        System.out.println("Expression 3: " + (isValidExpression(expression3) ? "Valid" : "Invalid"));
    }
}
