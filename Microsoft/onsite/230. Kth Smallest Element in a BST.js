var kthSmallest = function (root, k) {
    let number = 0;
    let count = k;

    helper(root);
    return number;

    function helper(node) {
        if (node.left != null) helper(node.left);
        count--;
        if (count === 0) {
            number = node.val;
            return;
        }
        if (node.right != null) helper(node.right);
    }
};