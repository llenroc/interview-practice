import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by yizhaoyang on 6/13/17.
 */
public class Practice {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }



    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static int locate(int root, int cur, int childSize) {

        childSize /= 2;
        int right = root - 1;			// right = root - 1
        int left = root - 1 - childSize; // left = root - 1 - childSize/2
        childSize--;
        if (right == cur || left == cur)
            return root;
        else {
            if (cur <= left)
                return locate(left,cur,childSize);
            else
                return locate(right,cur,childSize);
        }
    }

    public static int[] answer(int h, int[] q) {

        int root = (int)Math.pow(2,h) - 1;
        int[] result = new int[q.length];

        for (int i = 0 ; i < q.length ; i++) {
            if (q[i] < root && q[i] >=1)
                result[i] = locate(root,q[i],root-1);
            else
                result[i] = -1;
        }

        return result;
    }

    public static List<List<Integer>> allPairs(int[] arr, int target) {
        // Write your solution here.
        List<List<Integer>> res = new ArrayList<>();
        if(arr == null || arr.length <= 1) return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            List<Integer> list = map.get(target - arr[i]);
            if(list != null){
                for(int j : list){
                    res.add(Arrays.asList(j,i));
                }
            }
            if(!map.containsKey(arr[i])){
                map.put(arr[i], new ArrayList<Integer>());
            }
            map.get(arr[i]).add(i);


        }
        return res;
    }
    public static void main(String[] args) {

        System.out.println(allPairs(new int[]{3,9,1,2,3},4).toString());

    }
}
