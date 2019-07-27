package indeed;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedArray {


    public static int[] merge(int[] a1, int[]a2){
        if(a1 == null || a2 == null || a1.length == 0|| a2.length == 0) return null;

        List<Integer> list = new ArrayList<>();
        int i =0, j = 0;

        while(i < a1.length || j < a2.length){
            if(i == a1.length){
                list.add(a2[j++]);
                continue;
            }
            if(j == a2.length){
                list.add(a1[i++]);
                continue;
            }
            if(a1[i] == a2[j]){
                list.add(a1[i++]);
                j++;
            }else if(a1[i] < a2[j]) list.add(a1[i++]);
            else list.add(a2[j++]);
        }

        int[] res = new int[list.size()];

        for (int k = 0; k < res.length; k++) {
            res[k] = list.get(k);
        }

        return res;

    }

    public static void main(String[] args) {
        int[] a1 = {2,4,6,8,9,32,42};
        int[] a2= {1,3,5,15};

        int[] res = merge(a1,a2);

        System.out.println(res.length);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}
