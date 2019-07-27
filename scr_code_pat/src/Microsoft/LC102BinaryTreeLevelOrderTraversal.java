package Microsoft;

import java.util.*;
import java.util.List;

public class LC102BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null){
            return result;
        }
        q.offer(root);

        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i< level; i++){
                TreeNode temp = q.poll();
                list.add(temp.val);
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            result.add(list);
        }
        return result;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
