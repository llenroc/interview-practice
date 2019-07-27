package Uber;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BasicCalculator {

    // extra space   +-*/
    public static int calculate1(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        int re = 0;
        for (int i : stack) {
            re += i;
        }
        return re;
    }


    // O(1) space
    public int calculate(String s) {
        if (s == null) return 0;
        s = s.trim().replaceAll(" +", "");
        int length = s.length();

        int res = 0;
        long preVal = 0; // initial preVal is 0
        char sign = '+'; // initial sign is +
        int i = 0;
        while (i < length) {
            long curVal = 0;
            while (i < length && (int) s.charAt(i) <= 57 && (int) s.charAt(i) >= 48) { // int
                curVal = curVal * 10 + (s.charAt(i) - '0');
                i++;
            }
            if (sign == '+') {
                res += preVal;  // update res
                preVal = curVal;
            } else if (sign == '-') {
                res += preVal;  // update res
                preVal = -curVal;
            } else if (sign == '*') {
                preVal = preVal * curVal; // not update res, combine preVal & curVal and keep loop
            } else if (sign == '/') {
                preVal = preVal / curVal; // not update res, combine preVal & curVal and keep loop
            }
            if (i < length) { // getting new sign
                sign = s.charAt(i);
                i++;
            }
        }
        res += preVal;
        return res;
    }


    // +- ()
    public int calculate3(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (int) (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        if (number != 0) result += sign * number;
        return result;


    }


    public int basicCalculatorIII(String s) {
        int l1 = 0, o1 = 1;
        int l2 = 1, o2 = 1;

        Deque<Integer> stack = new ArrayDeque<>(); // stack to simulate recursion

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int num = c - '0';

                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(++i) - '0');
                }

                l2 = (o2 == 1 ? l2 * num : l2 / num);

            } else if (c == '(') {
                // First preserve current calculation status
                stack.offerFirst(l1); stack.offerFirst(o1);
                stack.offerFirst(l2); stack.offerFirst(o2);

                // Then reset it for next calculation
                l1 = 0; o1 = 1;
                l2 = 1; o2 = 1;

            } else if (c == ')') {
                // First preserve the result of current calculation
                int num = l1 + o1 * l2;

                // Then restore previous calculation status
                o2 = stack.poll(); l2 = stack.poll();
                o1 = stack.poll(); l1 = stack.poll();

                // Previous calculation status is now in effect
                l2 = (o2 == 1 ? l2 * num : l2 / num);

            } else if (c == '*' || c == '/') {
                o2 = (c == '*' ? 1 : -1);

            } else if (c == '+' || c == '-') {
                l1 = l1 + o1 * l2;
                o1 = (c == '+' ? 1 : -1);

                l2 = 1; o2 = 1;
            }
        }

        return (l1 + o1 * l2);
    }

}

