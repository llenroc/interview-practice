package Amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yizhaoyang on 7/30/17.
 */
public class SetMismatchLC645 {
    public int[] findErrorNums(int[] nums) {

        // sum - nums[] = missing - duplicate
        //  missing  - duplicate + duplicate = missing
        Set<Integer> set = new HashSet<>();
        int duplicate = 0, n = nums.length;
        long sum = (n * (n+1)) / 2;
        for(int i : nums) {
            if(set.contains(i)) duplicate = i;
            sum -= i;
            set.add(i);
        }
        return new int[] {duplicate, (int)sum + duplicate};
    }
}
