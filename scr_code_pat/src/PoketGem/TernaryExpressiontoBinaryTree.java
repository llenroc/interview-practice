package PoketGem;

import java.util.Stack;

public class TernaryExpressiontoBinaryTree {
    public static TreeNode convert(char[] expr) {
        if (expr.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(expr[0]);

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);


        for (int i = 1; i < expr.length; i += 2) {
            TreeNode node = new TreeNode(expr[i + 1]);

            if (expr[i] == '?') {
                stack.peek().left = node;
            }

            if (expr[i] == ':') {
                // pop previous left node
                stack.pop();
                while (stack.peek().right != null) {
                    stack.pop();
                }
                stack.peek().right = node;
            }

            stack.push(node);
        }

        return root;
    }

    static String res = "";
    public static String toString(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(sb, root);
        return sb.toString();
    }

    public static void traverse(StringBuilder sb, TreeNode root) {
        if(root == null) return;
        sb.append(root.val);
        if(root.left != null || root.right != null) sb.append("?");
        traverse(sb, root.left);
        if(root.right != null) sb.append(":");
        traverse(sb, root.right);

    }


    public static void main(String[] args) {
        char[] arr = "a?b?c:d:e".toCharArray();
        convert(arr);

    }

    public static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;
        TreeNode(char x) { val = x; }
    }
}
