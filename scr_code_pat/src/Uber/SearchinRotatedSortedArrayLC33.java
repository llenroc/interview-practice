package Uber;

public class SearchinRotatedSortedArrayLC33 {
    public int search(int[] nums, int target) {
        if(nums ==null || nums.length == 0) return -1;
        int start = 0, end = nums.length -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            // left side is sorted
            if(nums[start] <= nums[mid]  && nums[mid] > nums[end]){
                if(target >= nums[start] && target < nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{ // right side is sorted
                if(target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
