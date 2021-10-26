/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */

/*
    in BST, node are sorted under inorder, for k smallest => k - 1 in inorder arr
    Time: O(n), n: number of nodes
    Space: O(n)
*/
var kthSmallest = function(root, k) {
  //edge case
  if (root == null) return null;

  let inorderArr = [];
  getInorder(root);
  return inorderArr[k - 1];

  function getInorder(node) {
    if (node == null) return;
    getInorder(node.left);
    inorderArr.push(node.val);
    getInorder(node.right);
  }
};

/*
    can be improved by using stack, so we dont traverse all the nodes in the tree
    time: O(K)
    space: O(K)
*/

var kthSmallest = function(root, k) {
  //edge case
  if (root == null) return null;

  let stack = [];
  let node = root;
  while (node != null) {
    stack.push(node);
    node = node.left;
  }

  while (k >= 0) {
    let curr = stack.pop();
    k--;
    if (k === 0) return curr.val;
    let tmp = node.right;
    while (tmp != null) {
      stack.push(tmp);
      tmp = tmp.left;
    }
  }
  return -1;
};
