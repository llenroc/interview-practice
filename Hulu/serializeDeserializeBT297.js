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
 * preOrder string, put 'null' as null
 */
var serialize = function (root) {
  let result = '';
  buildString(root);
  return result;

  //pre - order
  function buildString(node) {
    if (node == null) {
      result += 'null ';
    } else {
      result += node.val + ' ';
      buildString(node.left);
      buildString(node.right);
    }
  }
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function (data) {
  if (!data || !data.length) return null;
  let queue = data.trim().split(' ');
  return buildTree();

  function buildTree() {
    let curr = queue.shift();
    if (curr === 'null') return null;
    let newNode = new TreeNode(Number(curr));
    newNode.left = buildTree();
    newNode.right = buildTree();
    return newNode;
  }
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
