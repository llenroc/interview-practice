/**
 * Created by yizhaoyang on 6/26/17.
 */


import java.util.Stack;
public class IterativePreorderTraversal {
    // Java program to implement iterative preorder traversal

    // A binary tree node
    static class Node {

        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class BinaryTree {

        Node root;

        void iterativePreorder()
        {
            iterativePreorder(root);
        }

        // An iterative process to print preorder traversal of Binary tree
        void iterativePreorder(Node node) {

            // Base Case
            if (node == null) {
                return;
            }

            // Create an empty stack and push root to it
            Stack<Node> nodeStack = new Stack<Node>();
            nodeStack.push(root);

        /* Pop all items one by one. Do following for every popped item
         a) print it
         b) push its right child
         c) push its left child
         Note that right child is pushed first so that left is processed first */
            while (nodeStack.empty() == false) {

                // Pop the top item from stack and print it
                Node mynode = nodeStack.peek();
                System.out.print(mynode.data + " ");
                nodeStack.pop();

                // Push right and left children of the popped node to stack 把right放前面 所以下次先执行left
                if (mynode.right != null) {
                    nodeStack.push(mynode.right);
                }
                if (mynode.left != null) {
                    nodeStack.push(mynode.left);
                }
            }
        }

    }
        // driver program to test above functions
        public static void main(String args[]) {
            BinaryTree tree = new BinaryTree();
            tree.root = new Node(10);
            tree.root.left = new Node(8);
            tree.root.right = new Node(2);
            tree.root.left.left = new Node(3);
            tree.root.left.right = new Node(5);
            tree.root.right.left = new Node(2);
            tree.iterativePreorder();

        }

// This code has been contributed by Mayank Jaiswal
}
