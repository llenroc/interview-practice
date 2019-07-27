package Adobe;

import java.util.*;

public class PrintNodesTopViewofBT {
    TreeNode root;

    // Constructors
    public PrintNodesTopViewofBT()  { root = null; }
    public PrintNodesTopViewofBT(TreeNode n) { root = n; }

    // This method prints nodes in top view of binary tree
    public void printTopView(TreeNode root) {
        // base case
        if (root == null) {  return;  }

        List<Integer> res =new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();


        q.offer(new Node(root,0));

        while(!q.isEmpty()){
            Node cur = q.poll();
            if(!set.contains(cur.hd)){
                res.add(cur.node.val);
                System.out.println(cur.node.val);
                set.add(cur.hd);
            }
            if(cur.node.left != null){
                q.offer(new Node(cur.node.left,cur.hd -1));
            }
            if(cur.node.right!= null){
                q.offer(new Node(cur.node.right,cur.hd + 1));
            }

        }


        System.out.println(res.toString());

    }

    public static void main(String[]args)
    {
        /* Create following Binary Tree
             1
           /  \
          2    3
           \
            4
             \
              5
               \
                6*/
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        PrintNodesTopViewofBT t = new PrintNodesTopViewofBT(root);
        System.out.println("Following are nodes in top view of Binary Tree");
        t.printTopView(root);
    }
}


// Class for a tree node
class TreeNode
{
    // Members
    int val;
    TreeNode left, right;

    // Constructor
    public TreeNode(int val)
    {
        this.val = val;
        left = right = null;
    }
}

// A class to represent a queue item. The queue is used to do Level
// order traversal. Every Queue item contains node and horizontal
// distance of node from root
class Node
{
    TreeNode node;
    int hd;
    public Node(TreeNode n, int h)
    {
        node = n;
        hd = h;
    }
}