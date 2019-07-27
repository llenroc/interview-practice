package Amazon;

import java.util.*;

/**
 * Created by yizhaoyang on 7/28/17.
 */
public class LFUCacheLC460 {
    private HashMap<Integer, Integer> vals;
    private HashMap<Integer, Integer> counts;  // key: key   value: key's frequency
    private HashMap<Integer, LinkedHashSet<Integer>> lists; // key: frequency   value: keys with given frequency
    private int cap;
    private int min = -1;   // min frequency
    public LFUCacheLC460(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }


    public int get(int key) {
        if(!vals.containsKey(key))
            return -1;
        int count = counts.get(key);
        counts.put(key, count+1);
        lists.get(count).remove(key);
        if(count==min && lists.get(count).size()==0)
            min++;
        if(!lists.containsKey(count+1))  // create the new level of frequency
            lists.put(count+1, new LinkedHashSet<>());
        lists.get(count+1).add(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if(cap<=0)
            return;
        if(vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }
        if(vals.size() >= cap) {
            int evit = lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            vals.remove(evit);
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;        // reset frequency to 1
        lists.get(1).add(key);
    }
}
