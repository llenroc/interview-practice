package indeed;

public class BinaryTreeTilt {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    int res =0;

    public int findTilt(TreeNode root) {
        postOrder(root);
        return res;

    }

    public int postOrder(TreeNode root) {
        if(root == null ) return 0;

        int left = postOrder(root.left);
        int right = postOrder(root.right);
        res += Math.abs(right - left);


        return root.val + left + right;



    }
}
