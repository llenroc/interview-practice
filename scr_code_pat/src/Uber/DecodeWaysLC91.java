package Uber;

public class DecodeWaysLC91 {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        // i 是右边界 不包括自己

        int n = s.length();
        int[] dp = new int[n+1];//num of ways of decoding s.substring(0, i)
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;


        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if (first >= 1 && first <= 9) {//can form a one-digit num
                dp[i] += dp[i-1];
            }
            if (second >= 10 && second <= 26) {//can form a two-digit num
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
