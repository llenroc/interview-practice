package PoketGem;

import java.util.PriorityQueue;

public class LC215KthLargestElementinArray {

    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>(){
        //     public int compare(int a, int b){return a - b;}
        // });
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);

            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }



}

