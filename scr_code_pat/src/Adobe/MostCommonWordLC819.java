package Adobe;

import java.util.*;

public class MostCommonWordLC819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> temp = Arrays.asList(banned);
        Set<String> set = new HashSet<>(temp);
        String[] list = paragraph.replaceAll("[!?',;.]","").toLowerCase().split(" ");
        Map<String, Integer> map = new HashMap<>();
        String res = "";
        for(String each: list){
            if(!map.containsKey(each)){
                map.put(each,1);
            }else{
                map.put(each, map.get(each) + 1);
            }
        }

        int max = 0;

        for(Map.Entry<String,Integer> entry: map.entrySet()){
            String word = entry.getKey();
            if(entry.getValue() > max && !set.contains(word)){
                res = word;
                max = entry.getValue();
            }
        }

        return res;
    }
}
