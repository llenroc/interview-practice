package Google;

/**
 * Created by yizhaoyang on 6/25/17.
 */
public class LongestSubstringMostKCharactersLC340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];     // there are 256 ASCII characters in the world
        int i = 0;  // i will be behind j
        int num = 0;
        int res = 0;

        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)] == 0) {    // if count[s.charAt(j)] == 0, we know that it is a distinct character
                num++;
            }
            count[s.charAt(j)]++;
            while (num > k && i < s.length()) {     // sliding window
                count[s.charAt(i)]--;
                if (count[s.charAt(i)] == 0){
                    num--;
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
