package PoketGem;

public class LC285InorderSuccessorinBST {


    /*
let's take the successor for example, basically we always want to find p's closest node (in inorder traversal)
and the node's value is larger than p's value, right? That node can either be p's parent or the smallest node in p' right branch.

When the code runs into the else block, that means the current root is either p's parent or a node in p's right branch.

If it's p's parent node, there are two scenarios:
1. p doesn't have right child, in this case, the recursion will eventually return null, so p's parent is the successor;
 2. p has right child, then the recursion will return the smallest node in the right sub tree, and that will be the answer.

If it's p's right child, there are two scenarios:
1. the right child has left sub tree, eventually the smallest node from the left sub tree will be the answer;
2. the right child has no left sub tree, the recursion will return null, then the right child (root) is our answer.


     */
    public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val <= p.val) {
            return successor(root.right, p);
        } else {
            TreeNode left = successor(root.left, p);
            return (left != null) ? left : root;
        }
    }


    // Uses Parent Pointer

    /*
The Algorithm is divided into two cases on the basis of right subtree of the input node being empty or not.

Input: node, root // node is the node whose Inorder successor is needed.
output: succ // succ is Inorder successor of node.

1) If right subtree of node is not NULL, then succ lies in right subtree. Do following.
Go to right subtree and return the node with minimum key value in right subtree.
2) If right sbtree of node is NULL, then succ is one of the ancestors. Do following.
Travel up using the parent pointer until you see a node which is left child of it’s parent. The parent of such a node is the succ.


     */

    Node inOrderSuccessor(Node root, Node n) {

        // step 1 of the above algorithm
        if (n.right != null) {
            return minValue(n.right);
        }

        // step 2 of the above algorithm
        Node p = n.parent;
        while (p != null && n == p.right) {
            n = p;
            p = p.parent;
        }
        return p;
    }

    /* Given a non-empty binary search tree, return the minimum data
     value found in that tree. Note that the entire tree does not need
     to be searched. */
    Node minValue(Node node) {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Node {

        int data;
        Node left, right, parent;

        Node(int d) {
            data = d;
            left = right = parent = null;
        }
    }
}
