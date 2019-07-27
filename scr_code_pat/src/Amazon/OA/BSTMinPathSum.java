package Amazon.OA;

/**
 * Created by yizhaoyang on 7/23/17.
 */
class TreeNode {
    int nodeValue;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int val) {
        nodeValue = val;
        leftChild = null;
        rightChild = null;
    }
}

public class BSTMinPathSum {

    /**
     * Call the private method to solve the problem
     * @param root The root node of a binary search tree
     * @return     The minimum sum of the path from root to leaf
     */
    public int solution(TreeNode root) {
        return calBSTMinPathSum(root);
    }

    /**
     * Private method for encapsulation
     * Calculate the minimum sum of the path from root to leaf by recursion
     * @param root The root node of a binary search tree
     * @return     The minimum sum of the path from root to leaf
     */
    private int calBSTMinPathSum(TreeNode root) {
        // For each recursion, there are four cases
        if (root == null) {
            // Case 1: The root node is null
            return 0;
        } else if (root.leftChild != null && root.rightChild == null) {
            // Case 2: The root node's left child is not null and right child is null
            return calBSTMinPathSum(root.leftChild) + root.nodeValue;
        } else if (root.leftChild == null && root.rightChild != null) {
            // Case 3: The root node's left child is null and right child is not null
            return calBSTMinPathSum(root.rightChild) + root.nodeValue;
        } else {
            // Case 4: Both of the root node's children are not null
            return Math.min(calBSTMinPathSum(root.leftChild), calBSTMinPathSum(root.rightChild)) + root.nodeValue;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(15);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(16);
        TreeNode node7 = new TreeNode(0);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(3);
        TreeNode node10 = new TreeNode(20);
        TreeNode node11 = new TreeNode(22);

        node1.leftChild = node2;
        node1.rightChild = node10;
        node2.leftChild = node3;
        node2.rightChild = node4;
        node4.leftChild = node5;
        node4.rightChild = node6;
        node5.leftChild = node7;
        node5.rightChild = node8;
        node6.leftChild = node9;
        node10.leftChild = node11;

        BSTMinPathSum testInstance = new BSTMinPathSum();
        System.out.print(testInstance.solution(node1));
    }
}