/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} target
 * @param {number} K
 * @return {number[]}
 */

/* 
1, build a undirected gragh using treenodes as verticles, 
and the parent-child relations as edges
2, do BFS with source verticle(target) to find all verticles with distance k to it
*/
var distanceK = function(root, target, k) {
  let map = new Map();
  let res = [];
  if (root == null || k < 0) return res;
  buildMap(root, null);
  if ((!map, has(target))) return res;
  let visited = new Set();
  let queue = [];
  queue.push(target);
  while (queue.length) {
    let size = queue.length;
    if (k === 0) {
      for (let i = 0; i < size; i++) {
        res.push(queue.shift().val);
      }
      return res;
    }
    for (let i = 0; i < size; i++) {
      let node = queue.shift();
      for (let next of map.get(node)) {
        if (visited.has(next)) continue;
        visited.add(next);
        queue.push(next);
      }
    }
    k--;
  }

  function buildMap(node, parent) {
    if (node === null) return;
    if (!map.has(node)) {
      map.set(node, []);
      if (parent != null) {
        map.get(node).push(parent);
        map.get(parent).push(node);
      }
      buildMap(node.left, node);
      buildMap(node.right, node);
    }
  }
};

class TreeNode {
  constructor(val) {
    this.val = val;
    this.left = this.right = null;
  }
}
