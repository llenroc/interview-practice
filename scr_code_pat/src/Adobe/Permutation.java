package Adobe;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<String> permutations(String set) {
        // Write your solution here
        List<String> res= new ArrayList<>();
        if(set == null) return res;
        char[] arr = set.toCharArray();
        dfs(res, arr, 0);
        return res;
    }

    private void dfs(List<String> list, char[] arr, int index){
        if(index == arr.length){
            list.add(new String(arr));
            return;
        }
        for(int i = index; i < arr.length; i++){
            swap(arr, i, index);
            dfs(list, arr, index + 1);
            swap(arr, i, index);
        }
    }

    private void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }

    private <E> void swapp(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }
}
