package Uber;

public class MaximumSubarrayLC53 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i] + ((dp[i - 1] >= 0)? dp[i - 1] : 0);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static int maxSubArrayIndex(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        int start = 0, end = 0;
        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i] + ((dp[i - 1] >= 0)? dp[i - 1] : 0);
            if(dp[i] == nums[i]) start = i;
            if(dp[i] > max){
                max = dp[i];
                end = i;
            }
        }

        // 更新 sum[i] = num[i]的时候更新start 更新max的时候更新end
        System.out.println("start " +  start + " end " + end);
        return max;
    }


    // constant space
    public static int maxSubArray2(int[] A) {
        int maxSoFar=A[0], maxEndingHere=A[0];
        int start = 0, end = 0;
        for (int i=1;i<A.length;++i){
            maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
            if(maxEndingHere == A[i]) start = i;
            if(maxSoFar < maxEndingHere){
                maxSoFar = maxEndingHere;
                end = i;
            }
        }
        return maxSoFar;
    }
}
