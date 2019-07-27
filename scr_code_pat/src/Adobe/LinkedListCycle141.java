package Adobe;

public class LinkedListCycle141 {
    public static boolean hasCycle(ListNode head) {

        if(head==null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner!=null && runner.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner) return true;
        }
        System.out.println(walker.val);

        return false;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next= new ListNode(3);
        node.next.next.next= new ListNode(4);
        node.next.next.next.next= new ListNode(5);
        hasCycle(node);
    }
}
