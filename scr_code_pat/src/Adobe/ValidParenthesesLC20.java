package Adobe;

import java.util.Stack;

public class ValidParenthesesLC20 {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i <s.length(); i++){
            if(s.charAt(i) == '(' ||s.charAt(i) == '{'|| s.charAt(i) =='['){
                stack.push(s.charAt(i));
            }else if(!stack.empty() && s.charAt(i) == ')' && stack.peek() == '('){
                stack.pop();
            }else if(!stack.empty() && s.charAt(i) == '}' && stack.peek() == '{'){
                stack.pop();
            }else if(!stack.empty() && s.charAt(i) == ']' && stack.peek() == '['){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.empty();
    }
}
