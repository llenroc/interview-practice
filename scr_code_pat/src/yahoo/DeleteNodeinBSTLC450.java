package yahoo;

public class DeleteNodeinBSTLC450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            // only have one branch
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode rightSmallest = root.right;
            while (rightSmallest.left != null) rightSmallest = rightSmallest.left;
            rightSmallest.left = root.left;
            return root.right;
        }
        return root;
    }

    // 删除比target等于和小的node
    public static TreeNode deleteNode2(TreeNode root, int target){
        if(root == null) return null;
        if(root.val > target){
            root.left = deleteNode2(root.left,target);
        }else{
            return deleteNode2(root.right,target);
        }
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right= new TreeNode(6);
        root.left.right.right= new TreeNode(8);
        root.left.right.right.right= new TreeNode(9);
        deleteNode2(root,6);
        System.out.println("hello");
    }

}
