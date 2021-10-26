/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
class TreeNode {
  constructor(val) {
    this.val = val;
    this.left = this.right = null;
  }
}

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 *
 * we utilize preorder to help us, we serialize the root to preorder string
 * return string seperated by space
 *
 */
var serialize = function(root) {
  let result = '';
  buildStr(root);
  return result;

  function buildStr(node) {
    if (node == null) return;

    result += node.val + ' ';
    buildStr(node.left);
    buildStr(node.right);
  }
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 *
 *  we wanna get the division index, such that [root], leftNodes....., rightNodes....
 */

var deserialize = function(data) {
  if (data == null || !data.length) return null;
  let queue = data.trim().split(' ');
  return buildBst(Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER);

  function buildBst(min, max) {
    if (!queue.length) return null;

    let val = Number(queue[0]);
    if (val < min || val > max) return null;
    queue.shift();
    let newNode = new TreeNode(val);
    newNode.left = buildBst(min, val);
    newNode.right = buildBst(val, max);
    return newNode;
  }
};

var deserialize1 = function(data) {
  if (data == null || !data.length) return null;
  let nodes = data.trim().split(' ');
  return buildBst(0, nodes.length - 1);

  function buildBst(low, high) {
    //base case
    if (low > high) return null;

    let newNode = new TreeNode(Number(nodes[low]));
    let index = findDivision(newNode, low + 1, high);
    newNode.left = buildBst(low + 1, index - 1);
    newNode.right = buildBst(index, high);

    return newNode;
  }

  function findDivision(node, low, high) {
    let i;
    for (i = low; i <= high; i++) {
      if (node.val < Number(nodes[i])) break;
    }
    return i;
  }
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
