package Amazon.OA2018;

import jdk.nashorn.api.tree.Tree;

public class DistanceBWTwoNode {
    public static void main(String[] args) {
        System.out.println(distanceOfTwoNode(new int[]{1,2,3,4,5,6,7},1,4));
    }

    public static int distanceOfTwoNode(int[] arr, int p ,int q){
        TreeNode root = constructBST(arr,0,arr.length - 1);
        TreeNode lca = LCA(root, new TreeNode(p), new TreeNode(q));
        int d1 = getDistance(lca,new TreeNode(p));
        System.out.println("d1" + d1);
        int d2 = getDistance(lca,new TreeNode(q));
        System.out.println("d2" + d2);
        if(lca.val == p){
            return d2;
        }else if(lca.val == q){
            return d1;
        }else{
            return Math.abs(d1 + d2);
        }

    }


    private static int getDistance(TreeNode root, TreeNode target){
        int count = 0;
        while(root.val != target.val){
            if(root.val < target.val){
                root = root.right;
            }else if(root.val > target.val){
                root = root.left;
            }
            count++;
        }
        return count;
    }

    private static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        if(root.val < p.val && root.val < q.val){
            return LCA(root.right,p,q);
        }else if(root.val > p.val && root.val > q.val){
            return LCA(root.left,p,q);
        }else{
            return root;
        }

    }


    private static TreeNode constructBST(int[] arr, int i, int j){
        if(i > j){
            return null;
        }
        int mid = i + (j - i) / 2;
        TreeNode cur = new TreeNode(arr[mid]);
        cur.left = constructBST(arr,i, mid - 1);
        cur.right = constructBST(arr,mid + 1, j);
        return cur;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
