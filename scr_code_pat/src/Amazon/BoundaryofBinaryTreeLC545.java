package Amazon;

import java.util.*;

/**
 * Created by yizhaoyang on 7/30/17.
 */
public class BoundaryofBinaryTreeLC545 {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> left = new LinkedList<>(), right = new LinkedList<>();
        preorder(root, left, right, 0);
        left.addAll(right);
        return left;
    }

    public void preorder(TreeNode cur, List<Integer> left, List<Integer> right, int flag) {
        if (cur == null) return;
        if (flag == 2) right.add(0, cur.val);
        else if (flag <= 1 || cur.left == null && cur.right == null) left.add(cur.val);
        preorder(cur.left, left, right, flag <= 1 ? 1 : (flag == 2 && cur.right == null) ? 2 : 3);
        preorder(cur.right, left, right, flag % 2 == 0 ? 2 : (flag == 1 && cur.left == null) ? 1 : 3);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
