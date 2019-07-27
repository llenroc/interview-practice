package Uber;

public class SearchforRangeLC34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if(nums == null || nums.length == 0) return res;
        int leftBound = findFirstOccurence(nums,target);
        if(leftBound == -1) return res;
        int rightBound = findLastOccurence(nums,target);
        // while(rightBound < nums.length - 1){
        //     if(nums[rightBound + 1] == target) rightBound++;
        //     else break;
        // }
        res[0] = leftBound;
        res[1] = rightBound;
        return res;
    }

    public int findFirstOccurence(int[] arr, int target){
        int left = 0, right = arr.length -1;
        while(left + 1 < right){
            int mid = left + (right - left) /2;
            if(arr[mid] == target){
                right = mid;
            }else if(arr[mid] < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(arr[left] == target) return left;
        if(arr[right] == target) return right;
        return -1;
    }

    public int findLastOccurence(int[] arr, int target){
        int left = 0, right = arr.length -1;
        while(left + 1 < right){
            int mid = left + (right - left) /2;
            if(arr[mid] == target){
                left = mid;
            }else if(arr[mid] < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(arr[right] == target) return right;
        if(arr[left] == target) return left;
        return -1;
    }

}
