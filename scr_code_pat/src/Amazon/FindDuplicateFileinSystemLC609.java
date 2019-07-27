package Amazon;

import java.util.*;

/**
 * Created by yizhaoyang on 7/26/17.
 */
public class FindDuplicateFileinSystemLC609 {
    public class Solution {
        public List < List < String >> findDuplicate(String[] paths) {
            HashMap < String, List < String >> map = new HashMap < > ();
            for (String path: paths) {
                String[] values = path.split(" ");
                for (int i = 1; i < values.length; i++) {
                    String[] name_cont = values[i].split("\\(");
                    name_cont[1] = name_cont[1].replace(")", "");
                    List< String > list = map.getOrDefault(name_cont[1], new ArrayList < String > ());
                    list.add(values[0] + "/" + name_cont[0]);
                    map.put(name_cont[1], list);
                }
            }
            List < List < String >> res = new ArrayList < > ();
            for (String key: map.keySet()) {
                if (map.get(key).size() > 1)
                    res.add(map.get(key));
            }
            return res;
        }
    }
}
