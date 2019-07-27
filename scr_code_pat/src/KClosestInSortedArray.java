public class KClosestInSortedArray {


    public static int[] kClosest(int[] arr, int target, int k) {
        // Write your solution here
        if(arr ==null || arr.length == 0) return arr;
        if(k == 0) return new int[0];

        int left = findClosestElement(arr, target);
        int right = left + 1;
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            if(right >= arr.length || ( left >= 0 &&
                    Math.abs(target - arr[left]) < Math.abs(target - arr[right]))){
                res[i] = arr[left--];
            }else{
                res[i] = arr[right++];
            }
        }
        return res;
    }

    public static int findClosestElement(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while(left + 1< right){
            int mid = left + (right - left)/2;
            if(arr[mid] <= target) {
                left = mid;
            }else{
                right = mid;
            }
        }
        if(arr[right] <= target){
            return right;
        }
        if(arr[left] <= target){
            return left;
        }
        return -1;
    }
}
