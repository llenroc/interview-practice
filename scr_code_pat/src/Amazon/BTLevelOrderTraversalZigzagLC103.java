package Amazon;

import java.util.*;

/**
 * Created by yizhaoyang on 7/27/17.
 */
public class BTLevelOrderTraversalZigzagLC103 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null){
            return result;
        }
        q.offer(root);
        boolean side = true;
        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i< level; i++){
                TreeNode temp = q.poll();
                if(side){
                    list.add(temp.val);
                }else{
                    list.add(0,temp.val);
                }

                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            side = !side;
            result.add(list);
        }
        return result;

    }

}
