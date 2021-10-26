/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {TreeNode}
 *
 *
 * use fast, slow pointer for mid. and then revursively look into left right sub problems
 *
 *
 */
var sortedListToBST = function(head) {
  if (head == null) return null;
  return helper(head, null);

  function helper(head, tail) {
    if (head === tail) {
      return null;
    }
    let slow = head;
    let fast = head;
    while (fast != tail && fast.next != tail) {
      slow = slow.next;
      fast = fast.next.next;
    }
    let newNode = new TreeNode(slow.val);
    newNode.left = helper(head, slow);
    newNode.right = helper(slow.next, tail);
    return newNode;
  }
};
