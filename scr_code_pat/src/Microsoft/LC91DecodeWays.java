package Microsoft;

public class LC91DecodeWays {



    /*
    I used a dp array of size n + 1 to save subproblem solutions. dp[0] means an empty string will have one way to decode, dp[1] means the way to decode a string of size 1.
     I then check one digit and two digit combination and save the results along the way. In the end, dp[n] will be the end result.


     */
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];//num of ways of decoding s.substring(0, i)
        //means an empty string will have one way to decode
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
