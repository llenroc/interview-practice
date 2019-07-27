package Uber;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
    //
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        int prepre = 0;
        int pre = nums[0];
        for(int i =1; i < nums.length; i++){
            int cur = Math.max(prepre + nums[i], pre);
            prepre = pre;
            pre = cur;
        }
        return pre;
    }

    // 环
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }

    public int helper(int[] nums, int lo, int hi) {
        int prepre = 0;
        int pre = 0;
        for(int i =lo; i <= hi; i++){
            int cur = Math.max(prepre + nums[i], pre);
            prepre = pre;
            pre = cur;
        }
        return pre;
    }

    // 树
    public int rob(TreeNode root) {
        return robSub(root, new HashMap<>());
    }

    private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }

        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);

        return val;
    }










    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
