var zigzagLevelOrder = function (root) {
    if (!root) return [];
    let result = [];
    let isOdd = true;
    let queue = [root];
    while (queue.length) {
        let lvSize = queue.length;
        let lvItems = [];
        while (lvSize > 0) {
            if (isOdd) {
                let node = queue.shift();
                lvItems.push(node.val);
                if (node.left) queue.push(node.left);
                if (node.right) queue.push(node.right);
            } else {
                let node = queue.pop();
                lvItems.push(node.val);
                if (node.right) queue.unshift(node.right);
                if (node.left) queue.unshift(node.left);
            }
            lvSize--;
        }
        result.push(lvItems);
        isOdd = !isOdd;
    }
    return result;
};