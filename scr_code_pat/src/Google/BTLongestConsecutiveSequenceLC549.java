package Google;

/**
 * Created by yizhaoyang on 6/20/17.
 */
public class BTLongestConsecutiveSequenceLC549 {
    int maxval = 0;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return maxval;
    }

    public int[] helper(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }
        int dcr = 1, inc = 1;

        if(root.left != null){
            int[] l = helper(root.left);
            if(root.left.val + 1 == root.val){
                dcr = l[1] + 1;
            }else if(root.left.val - 1 == root.val){
                inc = l[0] + 1;
            }
        }
        if(root.right != null){
            int[] r = helper(root.right);
            if(root.left.val + 1 == root.val){
                dcr = Math.max(dcr,r[1] + 1);
            }else if(root.left.val - 1 == root.val){
                inc = Math.max(inc,r[0] + 1);
            }
        }
        maxval = Math.max(maxval, dcr + inc -1);
        return new int[]{inc,dcr};
    }


  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

}
