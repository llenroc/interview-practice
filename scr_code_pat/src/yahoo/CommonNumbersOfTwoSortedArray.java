package yahoo;

import java.util.ArrayList;
import java.util.List;

public class CommonNumbersOfTwoSortedArray {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        if(A == null || B == null) return res;
        int i = 0, j = 0 ;

        while(i< A.size() && j < B.size()){
            if(A.get(i) == B.get(j)){
                res.add(A.get(i));
                i++;
                j++;
            }else if(A.get(i) < B.get(j)){
                i++;
            }else{
                j++;
            }
        }
        return res;

    }
}
