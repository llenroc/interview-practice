package yahoo;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        int maxNum = 1;
        dp[0] = 1;
        for(int i = 1; i< nums.length; i++){
            int preMax =0;
            for(int j = 0; j<i;j++){
                if(nums[j] < nums[i]){
                    preMax = Math.max(preMax,dp[j]);
                }
            }
            dp[i] = preMax + 1;
            maxNum = Math.max(maxNum, dp[i]);
        }

        return maxNum;

    }
}
