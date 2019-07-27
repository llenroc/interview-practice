import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinStringLC438 {

    public List<Integer> allAnagrams(String t, String s) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        if(s == null || t ==null) return res;
        if(s.length() < t.length()) return res;

        Map<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else{
                map.put(c,1);
            }
        }

        int match = 0;
        for(int i = 0; i < s.length() ; i++){
            char cur = s.charAt(i);

            if(map.containsKey(cur)){
                int count = map.get(cur);
                count--;
                map.put(cur, count);
                if(count == 0){
                    match++;
                }
            }

            if(i >= t.length()){
                char remove = s.charAt(i - t.length());
                Integer count = map.get(remove);
                if(count != null){
                    if(count == 0) match--;
                    count++;
                    map.put(remove,count);
                }
            }

            if(match == map.size()){
                res.add(i - t.length() + 1);
            }
        }
        return res;
    }
}
