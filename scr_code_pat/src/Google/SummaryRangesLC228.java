package Google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhaoyang on 6/28/17.
 */
public class SummaryRangesLC228 {
    public class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> res = new ArrayList<>();
            int fast = 0;
            while(fast < nums.length){
                int slow = fast;
                while(fast + 1 < nums.length && nums[fast + 1] - 1 == nums[fast]){
                    fast++;
                }
                if(slow == fast){
                    res.add("" + nums[slow]);
                }else{
                    res.add(nums[slow] + "->" + nums[fast]);
                }
                fast++;
            }
            return res;
        }
    }
}


