package Amazon.OA;

/**
 * Created by yizhaoyang on 7/23/17.
 */
import java.util.Stack;

/**
 * Created by wuyiz on 2/15/17.
 */

public class NumOfValidParentheses {

    /**
     * Call the private method to solve the problem
     * @param str A string containing parentheses
     * @return    If all the characters in the given string form valid parentheses,
     *            return the number of valid parentheses pairs, else return -1
     */
    public int solution(String str) {
        int numOfValidParPairs = numOfValidParentheses(str);

        if (numOfValidParPairs >= 0)  {
            // If the number of valid parentheses pairs is no smaller than 0
            return numOfValidParPairs;
        } else {
            // Not valid parentheses, return -1
            return -1;
        }
    }

    /**
     * Private method for encapsulation
     * Judge if all the characters in the given string form
     * valid parentheses and count the number of valid parentheses pairs
     * @param str A string containing parentheses
     * @return    If all the characters in the given string form valid parentheses,
     *            return the number of valid parentheses pairs, else return -1
     */
    private int numOfValidParentheses(String str) {
        // If the string is null or the length of it is 0,
        // then the string contains 0 pair of valid parentheses
//        if (str == null || str.length() == 0) {
//            return 0;
//        }

        // Initialize a counter to store the number of valid parentheses pairs
        int pairCounter = 0;
        // Initialize a stack for judging if the current character forms valid parentheses
        Stack<Character> stack = new Stack<Character>();

        // Iteratively check each character in the given string
        for (char c : str.toCharArray()) {
            // If the current character is space, continue to check the next character
            if (c == ' ') {
                continue;
            }
            // If coming across a left parenthesis, push its right parenthesis
            // into the stack and increase the counter by 1
            if (c == '(') {
                stack.push(')');
                pairCounter ++;
            } else if (c == '{') {
                stack.push('}');
                pairCounter ++;
            } else if (c == '[') {
                stack.push(']');
                pairCounter ++;
            } else {
                // If the stack is empty or the top parenthesis in the
                // stack does not match the current character
                if (stack.isEmpty() || stack.pop() != c) {
                    // The given string is not valid parentheses, return -1
                    return -1;
                }
            }
        }

        // After checking all the characters in the given string, if the stack is empty,
        // then all the parentheses are valid, return the number of pairs, else return -1
        if (stack.isEmpty()) {
            return pairCounter;
        } else {
            return -1;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        NumOfValidParentheses testInstance = new NumOfValidParentheses();
        System.out.println(testInstance.solution(" [{ ()}] "));
    }
}
