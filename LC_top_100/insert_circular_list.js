var insert = function (head, insertVal) {
  if (!head) {
    let newNode = new Node(insertVal, null);
    newNode.next = newNode;
    return newNode;
  }

  let prev = head;
  let curr = head.next;
  let toInsert = false;

  do {
    // case 1: fall within the normal cycle
    if (prev.val <= insertVal && curr.val >= insertVal) {
      toInsert = true;
    } else if (prev.val > curr.value) {
      //case 2: fall outside of cycle
      if (insertVal <= curr.val || insertVal >= prev.val) {
        toInsert = true;
      }
    }

    if (toInsert) {
      prev.next = new Node(insertVal, curr);
      return head;
    }

    prev = curr;
    curr = curr.next;
  } while (prev != head);

  //case 3 if uniform number
  prev.next = new Node(insertVal, curr);
  return head;
};
