package Adobe;

import java.util.*;

/**
 * Created by yizhaoyang on 7/29/17.
 */
public class TreeTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = stack.pop();
                list.add(temp.val);
                cur = temp.right;
            }
        }

        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            list.add(cur.val);

            if (cur.right != null) {
                s.push(cur.right);
            }
            if (cur.left != null) {
                s.push(cur.left);
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return ans;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return ans;
    }

    // 根据方向判断
    /*
     * What do we know: the direction Maintain a previous Node to record previous
     * visiting node so that we know what direction we are taking and what is the
     * direction we are taking next
     * 
     * 
     * root = stack.peek() if previous is null -> going down(left subtree has
     * priority) if previous is current's parent -> going down(left subtree has
     * priority) if previous == current.left -> left subtree finished, going
     * current.right if previous == current.right -> right subtree finished, pop
     * current, going up
     * 
     */

    public List<Integer> postOrder(TreeNode root) {
        // Write your solution here
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        stack.offerLast(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.peekLast();
            if (pre == null || cur == pre.left || cur == pre.right) {
                if (cur.left != null) {
                    stack.offerLast(cur.left);
                } else if (cur.right != null) {
                    stack.offerLast(cur.right);
                } else {
                    list.add(cur.val);
                    stack.pollLast();
                }
            } else if (pre == cur.left) {
                if (cur.right != null) {
                    stack.offerLast(cur.right);
                } else {
                    list.add(cur.val);
                    stack.pollLast();
                }
            } else {
                list.add(cur.val);
                stack.pollLast();
            }
            pre = cur;
        }
        return list;
    }
}
