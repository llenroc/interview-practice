package Amazon;

import java.util.*;

/**
 * Created by yizhaoyang on 7/22/17.
 */
public class GroupAnagramsLC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);  //name is just sorted pattern
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<String>());
            }
            map.get(keyStr).add(s);
        }
        //List<List<String>> res = map.values();
        return new ArrayList<List<String>>(map.values());
    }
}
