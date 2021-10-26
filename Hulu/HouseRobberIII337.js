/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 *
 *
 * max : max(currNode + grandChildren, directChilren)
 * grandChildren: left.left, left.right, right.left, right.left
 *  Time: O(n)  n is number of nodes
 *  space: O(h)  hight
 */
var rob = function(root) {
  let map = new Map();
  return getMax(root);

  function getMax(root) {
    if (root == null) return 0;
    if (map.has(root)) return map.get(root);
    //get max sum of grand child
    let grandChildVal = 0;
    if (root.left) {
      grandChildVal += getMax(root.left.left) + getMax(root.left.right);
    }
    if (root.right) {
      grandChildVal += getMax(root.right.left) + getMax(root.right.right);
    }
    let maxSum = Math.max(
      grandChildVal + root.val,
      getMax(root.left) + getMax(root.right)
    );
    if (!map.has(root)) map.set(root, maxSum);
    return maxSum;
  }
};
