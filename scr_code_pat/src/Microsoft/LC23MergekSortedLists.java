package Microsoft;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC23MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                return o1.val - o2.val;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode cur=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            cur.next=queue.poll();
            cur=cur.next;
            if (cur.next!=null)
                queue.add(cur.next);
        }
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
