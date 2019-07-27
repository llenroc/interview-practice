package Uber;

import java.util.*;

public class GroupShiftedStringsLC249 {
    public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ret = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strings) {
            String key = "";
            for(int i = 1; i < s.length(); i++) {
                int offset = s.charAt(i) - s.charAt(i - 1);
                key += offset < 0 ? offset + 26 : offset;
            }
            if(!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        for(List<String> ss : map.values()) {
            Collections.sort(ss);
            ret.add(ss);
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"abc","bcd","xyz"};
        System.out.println(groupStrings(arr).toString());
    }
}
