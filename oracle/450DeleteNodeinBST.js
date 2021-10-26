/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} key
 * @return {TreeNode}
 *
 *
 * case 1: find the target node,
 *         search target.left, if  root.val > key
 *         search target.right, if root.val < key
 * case 2: target found
 *         if has both left and right: find the smallest in right, replace and delete smallest right
 *         if only has left, move left up
 *         if only has right, move right up
 *
 */
var deleteNode = function(root, key) {
  //edge cases
  if (root == null) return null;

  if (root.val > key) {
    root.left = deleteNode(root.left, key);
  } else if (root.val < key) {
    root.right = deleteNode(root.right, key);
  } else {
    if (root.left != null && root.right != null) {
      let min = root.right;
      while (min.left != null) {
        min = min.left;
      }
      root.val = min.val;
      root.right = deleteNode(root.right, min.val);
    } else {
      // let newRoot = root.left != null? root.left : root.right;
      // root.left = null;
      // root.right = null;
      // return newRoot;
      return root.left != null ? root.left : root.right;
    }
  }
  return root;
};
