package Google;

/**
 * Created by yizhaoyang on 9/17/17.
 */
public class LC643MaximumAverageSubarray1 {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        // first k sum
        for(int i=0;i<k;i++)
            sum+=nums[i];
        double res=sum;
        // sliding window
        for(int i=k;i<nums.length;i++){
            sum+=nums[i]-nums[i-k];
            res=Math.max(res,sum);
        }
        return res/k;
    }

}
