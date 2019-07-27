package PoketGem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139WordBreak {
    public boolean wordBreak(String s, List<String> dict) {
        Set<String> set = new HashSet<>(dict);
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for(int i=1; i <= s.length(); i++){ // i keeps track of the end index
            for(int j=0; j < i; j++){   // j keeps track of the start index before i
                if(f[j] && set.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}
