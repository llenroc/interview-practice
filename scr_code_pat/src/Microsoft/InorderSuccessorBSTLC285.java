package Microsoft;

public class InorderSuccessorBSTLC285 {



    /*
    Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while(root != null){
            if(root.val > p.val){
                res = root;
                root = root.left;
            }
            else{
                root = root.right;
            }

        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
