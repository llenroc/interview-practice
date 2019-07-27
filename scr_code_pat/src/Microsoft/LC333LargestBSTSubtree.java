package Microsoft;

public class LC333LargestBSTSubtree {



    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        if(isBST(root, Integer.MIN_VALUE,Integer.MAX_VALUE)) return countNode(root);
        return Math.max(largestBSTSubtree(root.left),largestBSTSubtree(root.right));

    }

    public boolean isBST(TreeNode root,int low, int high){
        if(root == null) return true;
        if(root.val <= low || root.val >= high) return false;
        return isBST(root.left, low, root.val) && isBST(root.right, root.val, high);
    }

    public int countNode(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return 1 + countNode(root.left) + countNode(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
