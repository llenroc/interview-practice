import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yizhaoyang on 9/13/17.
 */
public class LC338CountingBits {
    class Solution {
        public int[] countBits(int num) {
            int result[] = new int[num + 1];
            int offset = 1;
            for (int index = 1; index < num + 1; ++index){
                if (offset * 2 == index){
                    offset *= 2;
                }
                result[index] = result[index - offset] + 1;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(3 & 1);
    }

    class MyStack {
        private Queue<Integer> q1;
        private Queue<Integer> q2;
        private int top;

        /** Initialize your data structure here. */
        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
            top = 0;
        }

        // Push element x onto stack.
        public void push(int x) {
            q1.add(x);
            top = x;
        }

        /** Removes the element on top of the stack and returns that element. */
        public void pop() {
            while (q1.size() > 1) {
                top = q1.remove();
                q2.add(top);
            }
            q1.remove();
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        /** Get the top element. */
        public int top() {
            return top;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty() & q2.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
