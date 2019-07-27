package Adobe;

import java.util.*;

public class BTZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res =new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean even = false;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size;i++){
                TreeNode cur = q.poll();
                temp.add(cur.val);
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }

            if(even){
                Collections.reverse(temp);
            }
            res.add(temp);
            even = !even;
        }
        return res;
    }
}
