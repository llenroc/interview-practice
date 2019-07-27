package GS;

import java.util.*;

public class Pair {

    static int getPairsCount(int[] arr, int sum)
    {

        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        // Store counts of all elements in map hm
        for (int i=0; i<n; i++){
            // initializing value to 0, if key not found
            if(!map.containsKey(arr[i]))
                map.put(arr[i],0);

            map.put(arr[i], map.get(arr[i])+1);
        }
        int twice_count = 0;

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (int i=0; i<n; i++)
        {
            if(map.get(sum-arr[i]) != null)
                twice_count += map.get(sum-arr[i]);

            // if (arr[i], arr[i]) pair satisfies the condition,
            // then we need to ensure that the count is
            // decreased by one such that the (arr[i], arr[i])
            // pair is not considered
            if (sum-arr[i] == arr[i])
                twice_count--;
        }

        // return the half of twice_count
        return twice_count/2;
    }

    public static void main(String[] args) {
//        System.out.println(getPairsCount(new int[]{1,1,1}, 2));
    }
}
