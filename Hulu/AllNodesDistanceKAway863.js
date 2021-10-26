class TreeNode {
  constructor(val) {
    this.val = val;
    this.left = this.right = null;
  }
}
/**
 * Definition for a binary tree node.
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} target
 * @param {number} K
 * @return {number[]}
 */
var distanceK = function(root, target, K) {
  // edge cases
  if (root == null || target == null) return [];
  let result = [];

  //buildMap, key: node, value: [...neighbors]
  let map = new Map();
  buildMap(root, null);
  if (!map.has(target)) return [];

  //bfs
  let queue = [];
  let visited = new Set();
  queue.push(target);
  visited.add(target);

  while (queue.length !== 0) {
    let size = queue.length;
    if (K === 0) {
      for (let i = 0; i < size; i++) {
        result.push(queue.shift().val);
      }
    }

    for (let i = 0; i < size; i++) {
      let node = queue.shift();
      let list = map.get(node);
      if (list == null) {
        console.log('list null');
      }
      for (let n of list) {
        if (!visited.has(n)) {
          visited.add(n);
          queue.push(n);
        }
      }
    }
    K--;
  }
  return result;

  function buildMap(node, parent) {
    if (node == null) return;
    // if(!map.has(node)) {
    //     map.set(node, []);
    //     if(parent != null) {
    //         map.get(node).push(parent);
    //         map.get(parent).push(node);
    //     }
    //     buildMap(node.left, node);
    //     buildMap(node.right, node);
    // }
    if (!map.has(node)) map.set(node, []);
    if (parent != null) {
      let parentList = map.get(parent) || [];
      parentList.push(node);
      map.set(parent, parentList);
      let nodeList = map.get(node) || [];
      nodeList.push(parent);
      map.set(node, nodeList);
    }
    buildMap(node.left, node);
    buildMap(node.right, node);
  }
};

let n3 = new TreeNode(3);
let n5 = new TreeNode(5);
let n1 = new TreeNode(1);
let n6 = new TreeNode(6);
let n2 = new TreeNode(2);
let n0 = new TreeNode(0);
let n8 = new TreeNode(8);
let n7 = new TreeNode(7);
let n4 = new TreeNode(4);

n2.left = n7;
n2.right = n4;
n5.left = n6;
n5.right = n2;
n1.left = n0;
n1.right = n8;
n3.left = n5;
n3.right = n1;

console.log(distanceK(n3, n5, 2));
