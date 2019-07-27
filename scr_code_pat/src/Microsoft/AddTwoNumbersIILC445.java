package Microsoft;

import java.util.Stack;

public class AddTwoNumbersIILC445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.add(l2.val);
            l2 = l2.next;
        }

        ListNode pre = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int v1 = (s1.isEmpty()) ? 0 : s1.pop();
            int v2 = (s2.isEmpty()) ? 0 : s2.pop();
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            ListNode cur = new ListNode(sum % 10);
            cur.next = pre;
            pre = cur;
        }


        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
