/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function (preorder, inorder) {
    let map = new Map();
    for (let i = 0; i < inorder.length; i++) {
        map.set(inorder[i], i);
    }

    function traverse(left, right) {
        if (left > right) return null;

        let currVal = preorder.shift();
        let node = new TreeNode(currVal);
        let index = map.get(currVal);

        node.left = traverse(left, index - 1);
        node.right = traverse(index + 1, right);

        return node;
    }

    return traverse(0, inorder.length - 1);
};