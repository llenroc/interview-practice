/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var diameterOfBinaryTree = function (root) {
    let max = 0;
    traverse(root);
    return max;

    function traverse(node) {
        if (!node) return 0;

        let left = traverse(node.left);
        let right = traverse(node.right);

        let allThree = node.val + left + right;
        max = Math.max(max, allThree);

        return 1 + Math.max(left, right);
    }
};