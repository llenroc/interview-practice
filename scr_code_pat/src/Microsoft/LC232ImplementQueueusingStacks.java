package Microsoft;

import java.util.Stack;

public class LC232ImplementQueueusingStacks {

    Stack<Integer> s1= new Stack<>();
    Stack<Integer> s2= new Stack<>();
    int front = 0;
    /** Initialize your data structure here. */
    public LC232ImplementQueueusingStacks() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(s1.isEmpty()) front = x;
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(!s2.isEmpty()){
            return s2.peek();
        }
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }


}
