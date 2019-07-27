package Microsoft;

import java.util.Stack;

public class LC173BinarySearchTreeIterator {

    Stack<TreeNode> stack = new Stack<TreeNode>();

    public LC173BinarySearchTreeIterator(TreeNode root) {

        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() != 0;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node;
        if(cur.right != null){
            cur = cur.right;
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
        }
        return node.val;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
