/**
 * Created by yizhaoyang on 6/27/17.
 */
public class KthSmallestBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private static int number;
    private static int count;

    public int kthSmallest(TreeNode root, int k) {
        count =k;
        helper(root);
        return number;
    }

    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        count--;
        if(count == 0){
            number = root.val;
            return;
        }
        helper(root.right);
    }

}
