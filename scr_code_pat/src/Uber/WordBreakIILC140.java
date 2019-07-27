package Uber;

import java.util.*;

public class WordBreakIILC140 {

    // avoid re-computation
    HashMap<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if(s == null)  return new ArrayList<>();
        return dfs(s, new HashSet<>(wordDict));
    }

    public List<String> dfs(String s, Set<String> wordDict) {
        List<String> list = map.get(s);
        if(list != null) return list;

        list = new ArrayList<>();
        if(s.length() == 0){
            list.add("");
            return list;
        }

        for(String word: wordDict){
            if(s.startsWith(word)){
                List<String> temp = dfs(s.substring(word.length()), wordDict);
                for(String each : temp){
                    list.add( word + (each.length() == 0? "" : " " + each));
                }
            }
        }
        map.put(s,list);
        return list;
    }

}
