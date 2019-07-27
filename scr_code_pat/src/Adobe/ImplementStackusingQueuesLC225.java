package Adobe;

import java.util.*;

public class ImplementStackusingQueuesLC225 {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    int top;
    /** Initialize your data structure here. */
    public ImplementStackusingQueuesLC225() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        top = x;
        q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size() > 1){
            int poll = q1.poll();
            top = poll;
            q2.offer(poll);
        }
        int res = q1.poll();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return res;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
