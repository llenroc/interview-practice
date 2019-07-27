package yahoo;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i <nums.length; i++){
            if(map.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }




    // all pairs of index
    public List<List<Integer>> allPairs(int[] arr, int target) {
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
                map.put(arr[i], new ArrayList<>());
            }
            // 这里没有else条件
            map.get(arr[i]).add(i);


        }
        return res;
    }

    // all pairs of value(contains duplicate)
    public List<List<Integer>> allPairs3(int[] arr, int target) {
        // Write your solution here.
        List<List<Integer>> res = new ArrayList<>();
        // key: number value : frequency
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            Integer count = map.get(arr[i]);
            if(arr[i] * 2 == target && count != null && count == 1){
                res.add(Arrays.asList(arr[i],arr[i]));
            }else if(map.containsKey(target - arr[i]) && count == null ){
                res.add(Arrays.asList(target - arr[i], arr[i]));
            }
            if(count == null){
                map.put(arr[i],1);
            }else{
                map.put(arr[i],count + 1);
            }
        }
        return res;
    }

}
