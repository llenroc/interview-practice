package Adobe;

public class SortListLC148 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fast = head, slow = head, pre = null;

        while(fast!= null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next =null;
        ListNode left = sortList(head);
        ListNode right =sortList(slow);
        return merge(left,right);
    }

    private ListNode merge (ListNode l1, ListNode l2){
        ListNode res = new ListNode(1), cur =res;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null){
            cur.next = l1;
        }
        if(l2 != null){
            cur.next = l2;
        }
        return res.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
