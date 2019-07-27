package Uber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordPatternLC290 {
    public boolean wordPattern(String pattern, String str) {
        String[] arr= str.split(" ");
        HashMap<Character, String> map = new HashMap<Character, String>();
        Set<String> set = new HashSet<>();

        if(arr.length!= pattern.length())
            return false;
        for(int i=0; i<arr.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(arr[i]))
                    return false;
            }else{
                if(map.containsValue(arr[i]))
//              if(set.contains(arr[i]))
                    return false;
                map.put(c, arr[i]);
//              set.add(arr[i]);
            }
        }
        return true;
    }
}
