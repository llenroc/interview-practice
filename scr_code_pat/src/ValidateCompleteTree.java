import java.util.LinkedList;
import java.util.Queue;

public class ValidateCompleteTree {
    public boolean isCompleted(TreeNode root) {
        // Write your solution here
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = false;

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            if (cur.left == null) {
                flag = true;
            } else if (flag) { // cur.left != null && flag
                return false;
            } else {
                q.offer(cur.left);
            }

            if (cur.right == null) { // cur.right != null && flag
                flag = true;
            } else if (flag) {
                return false;
            } else {
                q.offer(cur.right);
            }
        }
        return true;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
