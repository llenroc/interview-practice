package Adobe;

public class KthSmallestElementinBSTLC230 {
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


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
