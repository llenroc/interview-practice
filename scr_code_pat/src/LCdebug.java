

/**
 * Created by yizhaoyang on 6/19/17.
 */
public class LCdebug {



    public int longestConsecutive(TreeNode root) {
        return 1+ Math.max(helper(root,root.left,1,1),helper(root,root.right,1,1));
    }

    int helper(TreeNode parent, TreeNode root, int currentMax, int max){
        max = Math.max(currentMax, max);
        if(root == null) return max;
        if(parent.val != root.val - 1){currentMax = 0;}
        return Math.max(helper(root,root.left, currentMax + 1,max),helper(root,root.right,currentMax + 1,max));
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
