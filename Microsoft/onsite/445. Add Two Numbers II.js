
var addTwoNumbers = function (l1, l2) {
    const stack1 = [];
    const stack2 = [];
    const stack = [];
    let cur1 = l1;
    let cur2 = l2;
    let curried = 0;
    while (cur1) {
        stack1.push(cur1.val);
        cur1 = cur1.next;
    }
    while (cur2) {
        stack2.push(cur2.val);
        cur2 = cur2.next;
    }
    let a = null;
    let b = null;
    while (stack1.length > 0 || stack2.length > 0 || curried === 1) {
        a = Number(stack1.pop()) || 0;
        b = Number(stack2.pop()) || 0;

        stack.unshift((a + b + curried) % 10);

        if (a + b + curried >= 10) {
            curried = 1;
        } else {
            curried = 0;
        }
    }
    const dummy = new ListNode();
    let current = dummy;
    while (stack.length > 0) {
        current.next = new ListNode(stack.shift(), null);
        current = current.next;
    }
    return dummy.next;
};