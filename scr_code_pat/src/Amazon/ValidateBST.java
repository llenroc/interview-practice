package Amazon;

import java.util.Stack;

/**
 * Created by yizhaoyang on 7/23/17.
 */
public class ValidateBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public boolean isValidBST2(TreeNode root) {
        if(root == null) return true;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while(root!= null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
