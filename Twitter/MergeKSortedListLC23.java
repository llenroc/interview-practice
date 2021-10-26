import java.util.*;

class MergeKSortedListLC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        ListNode head = result;

        // we put each ListNode into priorityqueu, minheap
        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            minheap.offer(node);
        }

        // pop the top of minheap, chain it to list, and put ListNode.next back if there
        // is any
        while (!minheap.isEmpty()) {
            ListNode curr = minheap.poll();
            // ListNode newNode = new ListNode(curr.val);
            head.next = curr;
            if (curr.next != null) {
                minheap.offer(curr.next);
            }
            head = head.next;
        }
        return result.next;
    }

}

public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}