package Uber;

import java.util.List;
import java.util.Stack;

public class FlattenNestedListIteratorLC341 {


    Stack<NestedInteger> stack = new Stack<>();

    public FlattenNestedListIteratorLC341 (List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i-- ){
            stack.push(nestedList.get(i));
        }
    }


    public Integer next() {
        return stack.pop().getInteger();
    }


    public boolean hasNext() {
        while(!stack.isEmpty()){
            NestedInteger cur = stack.peek();
            if(cur.isInteger()){
                return true;
            }
            stack.pop();
            for(int i = cur.getList().size() -1; i >= 0; i--){
                stack.push(cur.getList().get(i));
            }
        }
        return false;
    }

    private class NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return false;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger(){
            return -1;
        };

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList(){
            return null;
        };
    }
}


