package Microsoft;

public class LC153FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        if(nums.length == 1) return nums[0];

        int start = 0 , end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) /2 ;
            if(mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
            // 这里nums[mid] > nums[end] 不是小于等于 要不然 如果start = mid = end的话， start会进位 + 1 答案就不对了
            if(nums[start] <= nums[mid] && nums[mid] > nums[end]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return nums[start];
    }

}
