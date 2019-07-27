// =======================
// Recursive approach
//=========================
class Node {
    constructor(val) {
        this.val = val;
        this.right;
        this.left;
    }
}


function recursivePreorder(node) {
    if (!node) return;

    console.log(node.val);
    recursivePreorder(node.left);
    recursivePreorder(node.right);
}


function recursiveInorder(node) {
    if (!node) return;

    recursiveInorder(node.left);
    console.log(node.val);
    recursiveInorder(node.right);
}


function recursivePostorder(node) {
    if (!node) return;

    recursivePostorder(node.left);
    recursivePostorder(node.right);
    console.log(node.val);
}


// ==========================================
// Iterative approach
// ===========================================
function interativePreorder(node) {
    if (!node) return [];

    let result = [];
    let stack = [];
    stack.push(node);

    while (stack.length) {
        let currNode = stack.pop();
        result.push(currNode.val);

        if (currNode.right) stack.push(currNode.right);
        if (currNode.left) stack.push(currNode.left);
    }
    return result;
}


function interativeInorder(node) {
    if (!node) return [];

    let result = [];
    let stack = [];
    let curr = node;

    while (node && stack.length) {
        if (curr) {
            stack.push(curr);
            curr = curr.left
        } else {
            let tmp = stack.pop()
            result.push(tmp.val);
            curr = tmp.right;
        }
    }
    return result;
}


function interativePostorder(node) {
    if (!node) return [];

    let result = [];
    let stack = [];
    stack.push(node);

    while (stack.length) {
        let currNode = stack.pop();
        result.unshift(currNode.val);

        if (currNode.left) stack.push(currNode.left);
        if (currNode.right) stack.push(currNode.right);
    }
    return result;
}

// Serialize / deserialize
