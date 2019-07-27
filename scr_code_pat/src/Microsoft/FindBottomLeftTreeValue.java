package Microsoft;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

    /*


    Doing BFS right-to-left means we can simply return the last node's value and don't have
     to keep track of the first node in the current row or even care about rows at all.
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null)
                queue.add(root.right);
            if (root.left != null)
                queue.add(root.left);
        }
        return root.val;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
