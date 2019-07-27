package Adobe;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianfromDataStreamLC295 {
    PriorityQueue<Integer> smaller; // max
    PriorityQueue<Integer> larger;  // min

    public FindMedianfromDataStreamLC295() {
        // add new fields and complete the constructor if necessary.
        smaller = new PriorityQueue<>(Collections.reverseOrder());
        larger = new PriorityQueue<>();
    }

    public void read(int value) {
        // write your implementation here.

        if(smaller.isEmpty() || value <= smaller.peek()){
            smaller.offer(value);
        }else{
            larger.offer(value);
        }

        // smaller should only larger by 1
        if(smaller.size() > 1 + larger.size()){
            larger.offer(smaller.poll());
        }else if(smaller.size() < larger.size()){
            smaller.offer(larger.poll());
        }
    }

    public Double median() {
        // write your implementation here.
        if(smaller.size() + larger.size() == 0) return null;
        if(smaller.size() == larger.size()) return  (smaller.peek() + larger.peek()) / 2.0;
        else return (double)smaller.peek();
    }
}
