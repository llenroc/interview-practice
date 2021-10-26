function connect(root) {
  let head; // head of next level
  let prev; // next level traverse pointer
  let curr = root; // curr node

  // traverse down levels
  while (curr) {
    // traverse within level
    while (curr) {
      if (curr.left) {
        if (prev) {
          prev.next = curr.left;
        } else {
          head = curr.left;
        }
        prev = curr.left;
      }

      if (curr.right) {
        if (prev) {
          prev.next = curr.right;
        } else {
          head = curr.right;
        }
        prev = curr.right;
      }
      curr = curr.next;
    }
    curr = head;
    prev = null;
    head = null;
  }
}
