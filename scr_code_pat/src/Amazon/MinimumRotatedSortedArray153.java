package Amazon;

/**
 * Created by yizhaoyang on 7/28/17.
 */
public class MinimumRotatedSortedArray153 {
    public int findMin(int[] nums) {
       /* int min = Integer.MAX_VALUE;
       for(int i = 0; i < nums.length; i++) {
           min = Math.min(min,nums[i]);
       }
       return min; */

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[start] <= nums[mid] && nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[start];
    }
}
