package Amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yizhaoyang on 7/29/17.
 */
public class KthLargestElementArrayLC215 {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>(){
        //     public int compare(int a, int b){return a - b;}
        // });
        PriorityQueue<Integer> pq= new PriorityQueue<Integer>(nums.length, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){return a - b;}
        });



        for(int val : nums) {
            pq.offer(val);

            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }


    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        return findKthLargest2(nums, 0, nums.length - 1, nums.length - k);
    }

    public int findKthLargest2(int[] nums, int start, int end, int k) {// quick select: kth smallest
        if (start > end) return Integer.MAX_VALUE;

        int pivot = nums[end];// Take A[end] as the pivot,
        int left = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
                swap(nums, left++, i);
        }
        swap(nums, left, end);// Finally, swap A[end] with A[left]

        if (left == k)// Found kth smallest number
            return nums[left];
        else if (left < k)// Check right part
            return findKthLargest2(nums, left + 1, end, k);
        else // Check left part
            return findKthLargest2(nums, start, left - 1, k);
    }

    void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

}
