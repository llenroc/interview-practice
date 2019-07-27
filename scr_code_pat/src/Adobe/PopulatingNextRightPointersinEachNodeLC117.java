package Adobe;

public class PopulatingNextRightPointersinEachNodeLC117 {

    /*
         1
       /  \
      2    3
     / \  / \
    4  5  6  7

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL


     */

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }


    //based on level order traversal
    public void connect(TreeLinkNode root) {

        TreeLinkNode head = null; //head of the next level
        TreeLinkNode pre = null; //the leading node on the next level
        TreeLinkNode cur = root;  //current node of current level


        while( cur !=null){
            while(cur !=null){
                if(cur.left != null){
                    if(pre !=null){
                        pre.next = cur.left;
                    }else{
                        head = cur.left;
                    }
                    pre = cur.left;
                }
                if(cur.right !=null){
                    if(pre != null){
                        pre.next = cur.right;
                    }else{
                        head = cur.right;
                    }
                    pre = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            pre = null;
            head = null;
        }
    }
}
