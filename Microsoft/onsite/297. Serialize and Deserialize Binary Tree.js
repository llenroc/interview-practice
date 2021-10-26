var serialize = function (root) {
    let str = "";
    build(root);
    return str;

    function build(node) {
        if (!node) {
            str += "null ";
            return;
        }

        str += (`${node.val} `);
        build(node.left);
        build(node.right);
    }
};

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