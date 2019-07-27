package Amazon.OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yizhaoyang on 9/19/17.
 */
public class WindowSum {

    public class WinSum {
        public List<Integer> GetSum(List<Integer> A, int k) {
            List<Integer> res = new ArrayList<>();

            // corner cases
            if(A == null || A.size() == 0 || k > A.size() || k <= 0){
                return res;
            }

            int length = A.size();
            for (int i = 0; i < length - k + 1; i++) {
                int sum = 0;
                for (int j = 0; j < k; j++) {
                    sum += A.get(i + j);
                }
                res.add(i,sum);
//                res.add(sum);
            }
            return res;
        }
    }




    public static int[] solution2 (int[] array, int k ){
        if(array == null || array.length < k || k <= 0) return null;
        int[] res = new int[array.length - k + 1];

        for(int i = 0; i < k; i++){
            res[0] += array[i];
        }

        for(int i = 1; i < res.length; i++){
            res[i] = res[i - 1] - array[i - 1] + array[i + k - 1];
        }
        return res;
    }


    public static void main(String[] args) {
        Integer[] array1 = {1,2,3,4,5,6,7,8,9,10};
        int[] array2 = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> list =new ArrayList<>(Arrays.asList(array1));

//        List<Integer> res = Solution(list,3);
//        int[] arr = solution2(array2,3);
//        System.out.println(res.toString());


    }
}
