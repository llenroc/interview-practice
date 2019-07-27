import java.util.*;

public class MergekSortedLists {

    /***
     *
     * merge K sorted list
     */
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
            ListNode temp = queue.poll();
            cur.next= temp;
            cur=cur.next;
            if (temp.next!=null)
                queue.add(cur.next);
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /***
     *  merge k sorted array
     */
    public int[] mergeKSortedArray(int[][] arr){

        PriorityQueue<QueueNode> pq = new PriorityQueue<>();


        int size = 0;
        for(int i =0; i < arr.length; i++){
            size += arr[i].length;
            pq.offer(new QueueNode(i,arr[i][0],0));
        }

        int[] res = new int[size];
        int i= 0;

        while(!pq.isEmpty()){
            QueueNode cur = pq.poll();
            res[i] = cur.val;
            if(cur.index + 1 < arr[cur.arrayIndex].length){
                pq.offer(new QueueNode(cur.arrayIndex, arr[cur.arrayIndex][cur.index + 1], cur.index + 1));
            }
            i++;
        }
        return res;
    }

    private class QueueNode implements Comparable<QueueNode>{
        int arrayIndex;
        int val;
        int index;

        public QueueNode(int arrayIndex, int val, int index) {
            this.arrayIndex = arrayIndex;
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(QueueNode other) {
            if(this.val < other.val) return -1;
            else if(this.val > other.val) return 1;
            return 0;
        }
    }
}


