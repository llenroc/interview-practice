package Amazon.OA2018;

import java.util.ArrayList;
import java.util.List;

public class KPermutation {

    public static List<String> kPermutation(String s, int k){
        List<String> res = new ArrayList<>();
        helper(s.toCharArray(),res,k,0);
        return res;
    }


    private static void helper(char[] arr, List<String> res, int k, int index){
        if(index == k){
            String ans = new String(arr).substring(0,k);
            res.add(ans);
            return;
        }

        for(int i = index; i < arr.length; i++){
            swap(arr,index, i);
            helper(arr,res,k,index + 1);
            swap(arr, i, index);
        }
    }


    private static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }


    public static void main(String[] args) {
        List<String> list = kPermutation("abc",2);

        System.out.println(list.toString());
    }
}
