package PoketGem.OA;

import java.util.HashMap;
import java.util.Map;

public class DeleteandEarn {

    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        int prepre = 0;
        int pre = nums[0];
        for(int i =1; i < nums.length; i++){
            int cur = Math.max(prepre + nums[i], pre + nums[i]);
            prepre = pre;
            pre = cur;
        }
        return Math.max(pre,prepre);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,-1,-3,2,1};
        System.out.println("result: " + rob(arr));;
    }
}
