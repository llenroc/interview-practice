package Adobe;

import java.util.*;

public class LFU {

    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> level;

    int cap;
    int min = -1;
    public LFU(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        level = new HashMap<>();
        level.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if(!vals.containsKey(key))
            return -1;
        int count = counts.get(key);
        counts.put(key, count+1);
        level.get(count).remove(key);
        //如果当前min frequency的那层是空的 min++
        if(count==min && level.get(count).size()==0)
            min++;
        if(!level.containsKey(count+1))
            level.put(count+1, new LinkedHashSet<>());
        level.get(count+1).add(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if(cap<=0)
            return;
        if(vals.containsKey(key)) {
            vals.put(key, value);
            //重新更新一次freq
            get(key);
            return;
        }
        if(vals.size() >= cap) {
            int evit = level.get(min).iterator().next();
            level.get(min).remove(evit);
            vals.remove(evit);
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        level.get(1).add(key);
    }
}
