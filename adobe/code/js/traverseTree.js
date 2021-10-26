function inOrder(root) {
  let stack = [];
  let list = [];
  let curr = root;

  while (curr || stack.length) {
    if (curr) {
      stack.push(curr);
      curr = curr.left;
    } else {
      let tmp = stack.pop();
      list.push(tmp.val);
      curr = tmp.right;
    }
  }
  return list;
}

function preOrder(root) {
  let list = [];
  let stack = [];
  stack.push(root);

  while (stack.length) {
    let curr = stack.pop();
    list.add(curr.val);

    if (curr.right) stack.push(curr.right);
    if (curr.left) stack.push(curr.left);
  }
  return list;
}

function postOrder(root) {
  let list = [];
  let stack = [];
  stack.push(root);

  while (stack.length) {
    let curr = stack.pop();
    list.unshift(curr.val);

    if (curr.left) stack.push(curr.left);
    if (curr.right) stack.push(curr.right);
  }
  return list;
}
