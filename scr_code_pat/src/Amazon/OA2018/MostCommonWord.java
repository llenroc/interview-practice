package Amazon.OA2018;

import java.util.*;

public class MostCommonWord {

    public static List<String> mostCommonWord(String paragraph, String[] banned) {

        List<String> temp = Arrays.asList(banned);
        Set<String> set = new HashSet<>(temp);
        String[] list = paragraph.replaceAll("[!?',;.]","").toLowerCase().split(" ");
        Map<String, Integer> map = new HashMap<>();

        List<String> res = new ArrayList<>();

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
            int freq = entry.getValue();

            if(freq > max && !set.contains(word)){
                res = new ArrayList<>();
                max = entry.getValue();
            }
            if(freq == max && !set.contains(word)){
                res.add(word);
            }
        }

        return res;
    }

}
