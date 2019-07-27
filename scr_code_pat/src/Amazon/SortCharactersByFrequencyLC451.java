package Amazon;

import java.util.*;

/**
 * Created by yizhaoyang on 7/28/17.
 */
public class SortCharactersByFrequencyLC451 {

    public class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
            PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                    map.size(), new Comparator<Map.Entry<Character, Integer>>() {
                        @Override
                        public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
                            return b.getValue() - a.getValue();
                        }
                    }
            );
            pq.addAll(map.entrySet());
            StringBuilder sb = new StringBuilder();
            while (!pq.isEmpty()) {
                Map.Entry e = pq.poll();
                for (int i = 0; i < (int)e.getValue(); i++) {
                    sb.append(e.getKey());
                }
            }
            return sb.toString();
        }
    }
}
