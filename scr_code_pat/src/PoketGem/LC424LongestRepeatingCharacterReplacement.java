package PoketGem;

public class LC424LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            // store the frequency of each letter
            count[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(end) - 'A']);
            // has to mnius maxinum frequency of a certain letter
            // since we don't need to replace the letter with maxinum frequency
            // Then as end increase, the whole substring from 0 to end will violate the rule,
            // so we need to update start accordingly (slide the window).
            // We move start to the right until the whole string satisfy the constraint again.
            while (end - start + 1 - maxCount > k) {
                // exclude the letter in the window
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
