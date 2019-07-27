package PoketGem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC347TopKFrequentElements
{




    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num) + 1);
            }
        }

//        for (int n : nums) {
//            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
//        }


        // corner case: if there is only one number in nums, we need the bucket has index 1. 因为1个element frequency也有1
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for(int key: map.keySet()){
            int freq = map.get(key);
            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }


        List<Integer> res = new ArrayList<>();
        for(int pos = buckets.length-1; pos >= 0; pos--){
            if(buckets[pos] != null){
                for(int i = 0; i < buckets[pos].size() && res.size() < k; i++)
                    res.add(buckets[pos].get(i));
            }
        }
        return res;
    }
}
