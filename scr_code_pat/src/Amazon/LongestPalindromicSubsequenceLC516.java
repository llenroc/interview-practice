package Amazon;

/**
 * Created by yizhaoyang on 7/30/17.
 */
public class LongestPalindromicSubsequenceLC516 {

    /*
    dp[i][j] store the length of the longest palindromic subsequence of substring(i,j). So how can we get it?
If s.charAt(i) == s.charAt(j), that means we can pick these two char and the longest palindromic subsequence
in substring(i+1, j-1) to form a longer subsequence that is palindromic, right

If s.charAt(i) != s.charAt(j), what's the possible result can be? It lives in the substring(i+1, j) and substring(i, j-1),
 we pick the bigger one from them.


     */

    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }


    public static void main(String[] args) {
        String[] arr = new String[6];
        System.out.println(arr[0]);
    }
}
