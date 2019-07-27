import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yizhaoyang on 6/26/17.
 */
public class AVLTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public class Solution {
        public boolean isBalanced(TreeNode root) {
            if(root==null){
                return true;
            }
            return height(root)!=-1;

        }


        public int height(TreeNode node){
            if(node==null){
                return 0;
            }
            int lH=height(node.left);
            if(lH==-1){
                return -1;
            }
            int rH=height(node.right);
            if(rH==-1){
                return -1;
            }
            if(lH-rH<-1 || lH-rH>1){
                return -1;
            }
            return Math.max(lH,rH)+1;
        }
    }


}
