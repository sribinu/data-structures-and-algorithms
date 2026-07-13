package stack.practice;

import java.util.Stack;

public class BalancedParentheses {

    public static boolean isValidParentheses(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c: expression.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }
            else if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty())
                    return false;

                char temp = stack.pop();
                if (temp == '{' && c != '}' ||
                    temp == '[' && c != ']' ||
                    temp == '(' && c != ')'
                ) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // The "Push the Opposite" Trick
    public static boolean isValidParenthesesOpposite(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            // Step 1: When you see an open bracket, push its matching CLOSE bracket
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            }
            // Step 2: When you see a close bracket, just check if it matches the top of the stack
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("Valid: " + isValidParentheses("{[()]}"));
        System.out.println("Valid: " + isValidParentheses("{[(])}"));
        System.out.println("Valid: " + isValidParentheses("((a + b) * c)"));
    }
}