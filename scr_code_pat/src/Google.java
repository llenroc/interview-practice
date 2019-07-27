import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by yizhaoyang on 6/3/17.
 */
public class Google {


    public static void main(String[] args) {
        String s = "h\tey";
        StringBuilder sb = new StringBuilder(s);
        sb.insert(0,"s");

        s = "\t\t\tdirname";

        Map<Integer,Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });





        System.out.println(s.lastIndexOf("\t"));
    }

    public int[] solution1(String a, String b){
        String[] bb = b.split(" ");
        String[] aa = a.split(" ");
        int[] result = new int[bb.length];
        int[] a_arr = helper1(aa);
        int[] b_arr = helper1(bb);

        for(int i = 0; i < b_arr.length; i++) {
            int count = 0;
            for (int j = 0; j < a_arr.length; j++) {
                if (b_arr[i] > a_arr[j])
                    count += 1;
            }
            result[i] = count;
        }
        return result;


    }

    public int[] helper1(String[] arr){
        int[] result = new int[arr.length];


        for(int i = 0; i < arr.length; i++){
            int count =1;
            String temp = arr[i];
            char min = temp.charAt(0);
            for(int j = 1; j < temp.length(); j++){
                if(temp.charAt(j) < min){
                    min = temp.charAt(j);
                    count = 1;
                }else{
                    count += 1;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public int[] solution2(int[] A, int k){
        if(A.length <= k) return A;
        int max_i = 0;
        int max_j = k - 1;

        for(int i = 1; i <= A.length - k; i++){
            for(int j = 0; j < k; j++){
                if(A[max_i + j] == A[i + j]){
                    continue;
                }else if (A[max_i + j] < A[i + j]){
                    max_i = i;
                    max_j = i + k;
                }else{
                   break;
                }
            }
        }

        int[] result = new int[k];
        for(int x = 0; x < k; x++)
            result[x] = A[max_i + x];
        return  result;
    }



}
