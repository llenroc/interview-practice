package Twitter;

public class MostFrequentInSortedArray {

    public int highestFrequence(int[] nums){
        int len = 1;
        int left = 0;
        while(left < nums.length - 1){
            if(nums[left] != nums[left + 1]){
                left++;
                continue;
            }else{
                int right = binarySearch(nums, left, nums.length - 1);
                len = Math.max(right - left + 1, len);
                left = right + 1;
            }
        }
        return len;
    }


    // find last occurrence of element
    public int binarySearch(int[] nums, int lo, int hi){
        if(lo == hi){
            return lo;
        }
        if(lo + 1 == hi){
            return nums[lo] == nums[hi] ? hi : lo;
        }
        int target = nums[lo];
        while(lo + 1 < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > target){
                    hi = mid;
            }else{
                lo = mid;
            }
        }
        if(nums[hi] == target){
            return hi;
        }else{
            return lo;
        }
    }
}
