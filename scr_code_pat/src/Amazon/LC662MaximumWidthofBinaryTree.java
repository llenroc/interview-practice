package Amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yizhaoyang on 9/16/17.
 */
public class LC662MaximumWidthofBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> count = new LinkedList<>();
        int max =0;
        q.add(root);
        count.add(0);

        while(!q.isEmpty()){
            int size = q.size();
            int left = 0, right =0;
            for(int i = 0; i < size; i++){
                int index  = count.remove();
                if(i == 0) left = index;
                if (i == size - 1) right = index;
                TreeNode node = q.remove();
                if(node.left != null){
                    q.add(node.left);
                    count.add(index * 2);
                }
                if(node.right != null){
                    q.add(node.right);
                    count.add(index * 2 + 1);
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
