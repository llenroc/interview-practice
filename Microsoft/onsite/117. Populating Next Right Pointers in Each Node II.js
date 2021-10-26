
// O(n) space solution
var connect = function (root) {
    if (root == null) return root;
    let queue = [];
    queue.push(root);
    while (queue.length > 0) {
        let size = queue.length;
        for (let i = 0; i < size; i++) {
            let node = queue.shift();
            if (i < size - 1) {
                node.next = queue[queue.length - 1];
            }

            if (node.left != null) {
                queue.push(node.left);
            }
            if (node.right != null) {
                queue.push(node.right);
            }
        }
    }
    return root;
};

// O(1) space
var connect = function (root) {
    if (!root) return null;
    let prev = null;
    let leftMost = root;
    let curr;
    let processChild = (node) => {
        if (!node) return;

        if (prev) {
            prev.next = node;
        } else {
            leftMost = node;
        }
        prev = node;
    }
    while (leftMost) {
        curr = leftMost;
        leftMost = null;
        prev = null;

        while (curr) {
            processChild(curr.left);
            processChild(curr.right);
            curr = curr.next;
        }
    }
    return root;
};