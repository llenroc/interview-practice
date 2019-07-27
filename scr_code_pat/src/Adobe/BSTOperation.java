package Adobe;

public class BSTOperation {
    public TreeNode insert(TreeNode root, int key) {
        // Write your solution here
        TreeNode cur  = root, parent = null;
        TreeNode newNode = new TreeNode(key);
        if(root == null){
            return newNode;
        }
        while(cur!= null){
            parent = cur;
            if(cur.key > key){
                cur = cur.left;
            }else if (cur.key < key ){
                cur = cur.right;
            }else{
                return root;
            }
        }
        if(parent.key < key){
            parent.right = newNode;
        }else{
            parent.left = newNode;
        }

        return root;
    }

    public TreeNode delete(TreeNode root, int key) {
        // Write your solution here
        if(root == null) return null;
        if(key <root.key){
            root.left = delete(root.left,key);
        }else if(key > root.key){
            root.right = delete(root.right,key);
        }else{
            if(root.left == null || root.right == null){
                return root.left == null? root.right: root.left;
            }
            TreeNode rightSmallest = root.right;
            while(rightSmallest.left != null){
                rightSmallest = rightSmallest.left;
            }
            rightSmallest.left = root.left;
            return root.right;
        }
        return root;
    }

    public class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { key= x; }

    }
}
