package Microsoft;

public class LC112PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null){
            if(sum - root.val == 0){
                return true;
            }else{
                return false;
            }
        }
        return hasPathSum(root.left, sum - root.val) ||hasPathSum(root.right, sum - root.val) ;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
