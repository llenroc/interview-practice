package Adobe;

public class LowestCommonAncestorOfBT {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(root.val > p.val && root.val > q.val) return lowestCommonAncestorBST(root.left,p,q);
        else if(root.val < p.val && root.val < q.val) return lowestCommonAncestorBST(root.right,p,q);
        else return root;
    }


    public TreeNode lowestCommonAncestorBT(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        else{
            TreeNode left = lowestCommonAncestorBT(root.left, p ,q);
            TreeNode right = lowestCommonAncestorBT(root.right, p ,q);
            if(left != null && right != null) return root;
            return (left == null)? right: left;
        }
    }
}
