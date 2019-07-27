package yahoo;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementLC169 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> list = new HashMap<Integer,Integer>();
        for(int num: nums) {
            if(!list.containsKey(num)){
                list.put(num,1);
            } else{
                list.put(num,list.get(num) + 1);
            }

            if(list.get(num) > (nums.length / 2)) {
                return num;
            }
        }
        return -1;
    }
}
