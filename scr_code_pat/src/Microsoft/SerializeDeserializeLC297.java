package Microsoft;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yizhaoyang on 6/23/17.
 */
public class SerializeDeserializeLC297 {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public class Codec {
        /*
        Here I use typical BFS method to handle a binary tree. I use string n to represent null values.
        The string of the binary tree in the example will be "1 2 3 n n 4 5 n n n n ".
        When deserialize the string, I assign left and right child for each not-null node, and add the not-null children to the queue, waiting to be handled later.
        用 bfs 横向扫描

         */
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null) return "";
            Queue<TreeNode> q = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            q.add(root);

            while(!q.isEmpty()){
                TreeNode cur = q.remove();
                if(cur == null){
                    sb.append("null ");
                    continue;
                }
                sb.append(cur.val).append(" ");
                q.add(cur.left);
                q.add(cur.right);
            }
            return sb.toString();
        }

        public TreeNode deserialize(String data) {
            if (data == "") return null;
            Queue<TreeNode> q = new LinkedList<>();
            String[] values = data.split(" ");
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            q.add(root);
            for (int i = 1; i < values.length; i++) {
                TreeNode parent = q.poll();
                if (!values[i].equals("null")) {
                    TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                    parent.left = left;
                    q.offer(left);
                }
                if (!values[++i].equals("null")) {
                    TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                    parent.right = right;
                    q.offer(right);
                }
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
