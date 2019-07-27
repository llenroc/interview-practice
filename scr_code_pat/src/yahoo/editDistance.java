package yahoo;

public class editDistance {
    public int editDistance(String one, String two) {
        // Write your solution here

        int[][] dp = new int[one.length() + 1][two.length() + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }else if(one.charAt(i - 1) == two.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j - 1]);
                }
            }
        }
        return dp[one.length()][two.length()];
    }
}
