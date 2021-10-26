
var bstFromPreorder = function (preorder) {
    let index = 0;

    return helper(Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER);

    function helper(min, max) {
        if (index === preorder.length) return null;
        let currVal = preorder[index];
        if (currVal < min || currVal > max) return null;

        index++;
        let node = new TreeNode(currVal);
        node.left = helper(min, currVal);
        node.right = helper(currVal, max);
        return node;
    }
};