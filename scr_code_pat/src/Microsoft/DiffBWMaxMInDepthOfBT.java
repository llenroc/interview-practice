package Microsoft;

public class DiffBWMaxMInDepthOfBT {

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        recurse(root,1);
        return max - min;
    }

    public void recurse(TreeNode root, int height){
        if(root == null) return;
        if(root.left == null && root.right == null) {
            max= Math.max(max, height);
            min= Math.min(min, height);
        }else{
            recurse(root.left, height+1);
            recurse(root.right, height+1);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
