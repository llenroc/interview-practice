package Microsoft;

public class LC114FlattenBTLinkedList {

    public void flatten(TreeNode root) {
        if(root ==null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 去掉左边
        root.left = null;

        flatten(left);
        flatten(right);

        // 把右边变成左边
        root.right = left;

        // travel到最右下角的node 再把原来的右边加上去
        TreeNode cur = root;
        while(cur.right != null) cur = cur.right;
        cur.right = right;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
