package Uber;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinationsLC254 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res= new ArrayList<>();
        helper(res, new ArrayList<Integer>(), n ,2);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> temp, int n, int start){
        if(n == 1){
            if(temp.size() > 1){
                res.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        for(int i = start; i <= n; i++){
            if(n % i == 0){
                temp.add(i);
                helper(res,temp, n / i, i);
                temp.remove(temp.size() -1);
            }
        }
    }
}
