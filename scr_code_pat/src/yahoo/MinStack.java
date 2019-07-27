package yahoo;

import java.util.Stack;

public class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public int pop() {
        if(stack.isEmpty()) return -1;
        int res = stack.pop();
        if(res == min) min=stack.pop();
        return res;
    }

    public int top() {
        if(stack.isEmpty()) return -1;
        return stack.peek();
    }

    public int min() {
        if(stack.isEmpty()) return -1;
        return min;
    }


}
