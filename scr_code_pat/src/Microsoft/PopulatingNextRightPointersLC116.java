package Microsoft;

/**
 * Created by yizhaoyang on 6/26/17.
 */
public class PopulatingNextRightPointersLC116 {

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

    public class Solution {
        public void connect(TreeLinkNode root) {

            TreeLinkNode level_start=root;
            // 每一层 （上下）
            while(level_start!=null){

                TreeLinkNode cur=level_start;
                // 横向位移
                while(cur!=null){
                    if(cur.left!=null) cur.left.next=cur.right;
                    if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left; // 看图 level3 cur = 2 cur.next = 3 的时候

                    cur=cur.next;
                }
                level_start=level_start.left;
            }
        }
    }
}
