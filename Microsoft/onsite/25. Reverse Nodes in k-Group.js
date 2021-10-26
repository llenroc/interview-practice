/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function (head, k) {
    let newHead;
    let tmpTail;
    let curr = head;
    while (curr != null) {
        let count = 0;
        curr = head;
        while (count < k && curr != null) {
            curr = curr.next
            count++;
        }
        if (count === k) {
            let revHead = reverseKlist(head, k);
            if (newHead == null) newHead = revHead;
            if (tmpTail != null) tmpTail.next = revHead;
            tmpTail = head;
            head = curr;
        }
    }
    if (tmpTail != null) tmpTail.next = head;
    return newHead != null ? newHead : head;
};

var reverseKlist = (head, k) => {
    let prev = null;
    let curr = head;
    while (k > 0) {
        let tmp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = tmp;
        k--;
    }
    return prev;
}