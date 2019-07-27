package Amazon;

/**
 * Created by yizhaoyang on 9/11/17.
 */
public class LC141LinkedListCycle {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }


        public boolean hasCycle(ListNode head) {

        // extra space
        //         Set<ListNode> list = new HashSet<ListNode>();
        //         while(head != null) {
        //             if(list.contains(head)) {
        //                 return true;
        //             } else {
        //                 list.add(head);
        //             }
        //             head = head.next;
        //         }
        //         return false;

        /*

        Use two pointers, walker and runner.
        walker moves step by step. runner moves two steps at time.
        if the Linked List has a cycle walker and runner will meet at some
        point.
         */
            if(head==null) return false;
            ListNode walker = head;
            ListNode runner = head;
            while(runner.next!=null && runner.next.next!=null) {
                walker = walker.next;
                runner = runner.next.next;
                if(walker==runner) return true;
            }
            return false;
        }
    }
}
