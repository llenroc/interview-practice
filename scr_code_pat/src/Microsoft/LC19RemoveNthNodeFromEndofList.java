package Microsoft;

public class LC19RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        int len = 0;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        len -= n;
        cur = dummy;
        while(len >0){
            cur = cur.next;
            len--;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
