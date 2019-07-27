package yahoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSumIILC113 {
    private List<List<Integer>> resultList = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null) return resultList;
        Stack<Integer> path = new Stack<Integer>();
        pathSumInner(root, sum, path);
        return resultList;
    }

    private void pathSumInner(TreeNode root, int sum, List<Integer> path){
        if(root == null) return;
        path.add(root.val);

        if(root.left == null && root.right == null){
            if(sum == root.val){
                resultList.add(new ArrayList<Integer>(path));
            }
        }

        pathSumInner(root.left, sum - root.val,path);
        pathSumInner(root.right, sum - root.val,path);

        path.remove(path.size() - 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
