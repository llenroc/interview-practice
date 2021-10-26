/**
 * // Definition for a Node.
 * function Node(val, neighbors) {
 *    this.val = val === undefined ? 0 : val;
 *    this.neighbors = neighbors === undefined ? [] : neighbors;
 * };
 */

/**
 * @param {Node} node
 * @return {Node}
 */
let visited = new Map();
var cloneGraph = function (node) {
    if (!node) return node;
    if (visited.has(node)) {
        return visited.get(node);
    }

    let newNode = new Node(node.val, []);
    visited.set(node, newNode);
    for (let neighbor of node.neighbors) {
        newNode.neighbors.push(cloneGraph(neighbor));
    }

    return newNode;
};
