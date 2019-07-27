/**
 * Created by yizhaoyang on 6/26/17.
 */
public class LowestCommonAncestorOfBT {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        else{
            TreeNode left = lowestCommonAncestor(root.left, p ,q);
            TreeNode right = lowestCommonAncestor(root.right, p ,q);
            if(left != null && right != null) return root;
            return (left == null)? right: left;
        }
    }
}
