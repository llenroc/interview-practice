package Adobe;

public class ReverseNodesinkGroupLC25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while(cur != null && count != k){
            cur = cur.next;
            count++;
        }

        if(count == k){
            cur = reverseKGroup(cur,k);

            ListNode pre = cur;
            while(count >0){
                ListNode temp = head.next;
                head.next = pre;
                pre = head;
                head = temp;
                count--;
            }
            head = pre;

        }
        return head;

    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
