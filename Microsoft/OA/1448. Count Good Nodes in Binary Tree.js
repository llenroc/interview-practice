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
var goodNodes = function (root) {
    return traverse(root, Number.MIN_SAFE_INTEGER);

    function traverse(node, prevValue) {
        if (!node) return 0;

        let count = 0;
        if (node.val >= prevValue) count++;

        let left = traverse(node.left, Math.max(prevValue, node.val));
        let right = traverse(node.right, Math.max(prevValue, node.val));
        count = count + left + right;

        return count;
    }
};