package Uber;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollisionLC735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int each: asteroids){
            if(each > 0){
                stack.offerLast(each);
            }else{
                while(!stack.isEmpty() && stack.peekLast() > 0 && stack.peekLast() < -each){
                    stack.pollLast();
                }
                if(!stack.isEmpty() && stack.peekLast() == -each){
                    stack.pollLast();
                }else if(stack.isEmpty() || stack.peekLast() < 0){
                    stack.offerLast(each);
                }
            }
        }
        int[] res= new int[stack.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = stack.pollFirst();
        }
        return res;
    }
}
