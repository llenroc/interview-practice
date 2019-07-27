package yahoo;

public class LowestCommonAncestor {
    // BST
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left,p,q);
        else if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right,p,q);
        else return root;
    }


    // BT
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left,p,q);
        TreeNode right = lowestCommonAncestor2(root.right, p , q);
        if(left != null &&  right!= null) return root;
        return (left== null)? right: left;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
