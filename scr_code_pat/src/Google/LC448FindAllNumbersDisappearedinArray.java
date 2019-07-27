package Google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhaoyang on 9/14/17.
 */
public class LC448FindAllNumbersDisappearedinArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LC448FindAllNumbersDisappearedinArray lc = new LC448FindAllNumbersDisappearedinArray();
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(lc.findDisappearedNumbers(arr));
    }



}
