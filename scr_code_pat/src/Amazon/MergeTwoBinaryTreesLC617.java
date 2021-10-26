package Amazon;

/**
 * Created by yizhaoyang on 7/28/17.
 */
public class MergeTwoBinaryTreesLC617 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // base case
        if (t1 == null && t2 == null) {
            return null;
        }
        // 1. current level operation
        int val = 0;
        if (t1 == null) {
            val = t2.val;
        } else if (t2 == null) {
            val = t1.val;
        } else {
            val = t1.val + t2.val;
        }
        TreeNode res = new TreeNode(val);
        // 2. child level operation
        // 这里必须要判断 t1和t2是否是 null。 因为 结果是最后return的 所以 T1/T2是null 不会有left right
        res.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        res.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        // 3. return current level to parent
        return res;
    }
}
