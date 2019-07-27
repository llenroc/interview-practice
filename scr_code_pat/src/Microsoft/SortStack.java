package Microsoft;

import java.util.List;
import java.util.Stack;

public class SortStack {

    public void sort (Stack<Integer> stack){
        Stack<Integer> temp = new Stack<>();

        while(!stack.isEmpty()){
            int val = stack.pop();
            while(!temp.isEmpty() && val > temp.peek()){
                stack.push(temp.pop());
            }
            temp.push(val);
        }

        while(! temp.isEmpty()){
            stack.push(temp.pop());
        }
    }

}
