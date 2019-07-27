import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yizhaoyang on 6/27/17.
 */

public class InorderTreeTraversal {
    // non-recursive java program for inorder traversal

/* importing the necessary class */

    /* Class containing left and right child of current
     node and key value*/
    static class Node {

        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /* Class to print the inorder traversal */
    static class BinaryTree {

        Node root;

        void inorder() {
            if (root == null) {
                return;
            }

            //keep the nodes in the path that are waiting to be visited
            Stack<Node> stack = new Stack<Node>();
            Node node = root;

            //first node to be visited will be the left one
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            // traverse the tree
            while (stack.size() > 0) {

                // visit the top node
                node = stack.pop();
                System.out.print(node.data + " ");
                if (node.right != null) {
                    node = node.right;

                    // the next node to be visited is the leftmost
                    while (node != null) {
                        stack.push(node);
                        node = node.left;
                    }
                }
            }
        }

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if(root == null) return list;
            Stack<TreeNode> stack = new Stack<>();
            while(root != null || !stack.empty()){
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

        public static void main(String args[]) {

        /* creating a binary tree and entering
         the nodes */
            BinaryTree tree = new BinaryTree();
            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(5);
            tree.inorder();
        }
    }
}
