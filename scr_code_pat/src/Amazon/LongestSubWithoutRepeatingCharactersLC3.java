package Amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yizhaoyang on 7/22/17.
 */
public class LongestSubWithoutRepeatingCharactersLC3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> test = new HashSet<Character>();
        int leng = s.length(), i = 0, j = 0,max = 0;
        while(j < leng) {
            if(!test.contains(s.charAt(j))) {
                test.add(s.charAt(j));
                j++;
                max = Math.max(max, j - i);
            } else {
                test.remove(s.charAt(i));
                i++;
            }
        }
        return max;

    }
}
