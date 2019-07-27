package Microsoft;

public class LC33SearchinRotatedSortedArray {


    public int search(int[] nums, int target) {
        if(nums ==null || nums.length == 0) return -1;
        int start = 0, end = nums.length -1;
        // 这里必须是 小于等于 要不长度为1的就进不去
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            // 这里月也要 小于等于 要不 【3，1】，1 的case过不去
            if(nums[start] <= nums[mid]){
                if(target >= nums[start] && target < nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
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
