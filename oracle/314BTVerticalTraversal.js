/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 * 
 * 
 * 
 * 1, BFS, put node, col into queue at the same time
   2, Every left child access col - 1 while right child col + 1
   3, This maps node into different col buckets
   4, Get col boundary min and max on the fly
   5, Retrieve result from cols  
 * 
 * 
 */
var verticalOrder = function(root) {
    if(root == null) return [];

    let nodeQueue = [];
    let colQueue = [];
    let result = [];
    let map = new Map();
    let min = 0;
    let max = 0;
    nodeQueue.push(root);
    colQueue.push(0);

    while(nodeQueue.length !== 0) {
        let node = nodeQueue.shift();
        let col = colQueue.shift();

        let list = map.get(col) || [];
        list.push(node.val);
        map.set(col, list);

        if(node.left != null) {
            nodeQueue.push(node.left);
            colQueue.push(col - 1);
            min = Math.min(min, col - 1);
        }
        if(node.right != null) {
            nodeQueue.push(node.right);
            colQueue.push(col + 1);
            max = Math.max(max, col + 1);
        }
    }

    for(let i = min; i <= max; i++) {
        result.push(map.get(i));
    }
    return result;
};