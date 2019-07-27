package Microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC94BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<>();

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;

    }

    public List < Integer > inorderTraversal(TreeNode root) {
        List< Integer > res = new ArrayList< >();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List < Integer > res) {
        if (root != null) {
            // if (root.left != null) {
            helper(root.left, res);
            // }
            res.add(root.val);
            // if (root.right != null) {
            helper(root.right, res);
            // }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
