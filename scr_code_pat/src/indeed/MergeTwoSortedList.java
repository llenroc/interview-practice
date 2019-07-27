package indeed;

public class MergeTwoSortedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode node = null;

        if(l1.val < l2.val){
            node = l1;
            merge(l1.next,l2);
        }
//        else if(l1.val == l2.val){     non-repetitive
//            node = l1;
//            merge(l1.next,l2.next);
//        }
        else{
            node = l2;
            merge(l1,l2.next);
        }
        return node;
    }

}
