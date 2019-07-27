package Adobe;

/**
 * Created by yizhaoyang on 9/19/17.
 */
public class LongestPalindrome {
    //    abcdcbasadsadgsafsaf
    //

    /*
    This question ask us to find the longest palindromic substring in a string.
    Obviously the simplest way is to pick all possible starting and ending positions for a substring, and verify if it is a palindrome
    But obviously it will takes huge cost to perform such operation
    the time complexity can take up to O n^3
    so there's a chance that we can improve

    So when I consider that how to avoid such unnecessary re-computation while validating palindromes,
    Dynamic programming pops in my mind.
    since it breaks complex problem down into a collection of
     simpler sub-problems,  and storing each of their solutions for the future use, which means
     when you solve one of the sub-problem, all you have to do is to refer to solution of one step before and choose the optimal choice based on
     previous solution.


    So I define sub problem P(i,j) as following:

    P(i,j)={
            true if the substring Si…Sj is a palindrome
            false   otherwise
            }

     So after setting up the sub-problem, the thing becomes easy. We only need to find a way to how to set it true
​​
     Consider the case 'ababa'. pointing at the first and last 'a'
                        i   j

     so let's suppose that if we already knew that 'bab' is a palindrome, and the characters pointing at i and j are also the same

     we find out that 'ababa' must be a palindrome based on the this example

     So we can say that P(i,j)=  P(i+1,j−1) and Si == Sj

     For the base case we can define if Si = Sj and the length between them is less or equals to 3
       like aba aa







     Time complexity O(n^2) to scan the String
     since we iterate the pointer i throughout the entire string and at each step of i we also iterate the pointer j to the end
     So that's a classical n^2 solution

     And undoubtedly since we build up the table,
     Space complexity O(n^2)

    Alternative: dp for longest common substring  On^2
                Manacher's Algorithm On
     */


    public String longestPalindrome(String s) {
        // first we check whether the input is valid
        // edge case
        if(s == null || s.length() == 0){
            return s;
        }


        String res = "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        // After that, it's time to scan the entire string
        // so we picking the starting pointer i by iterating from the end of the String
        for(int i = n - 1; i >= 0; i--){
            // and picking the ending pointer j starts from the i to the end of the string
            for(int j = i; j < n; j++){
                // within the start point and end point
                // first we check that whether i and j can form a palindrome
                // like I mentioned before
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1] )){
                    dp[i][j] = true;
                }

                // And after this step it's time for us to update
                // if i and j can form a palindrome and has the length that is larger than our res string
                // if that's the case, we update
                if(dp[i][j] && (res.length() < j - i + 1 )){
                    res= s.substring(i,j+ 1);
                }
            }
            
        }

        // In the end, we return our result
        return res;
    }



    private int lo, maxLen;

    /*  there's a another solution.
        Since a palindrome can be build up by expanding the left and right with same character, we can use this rule to write our method.

        we iterate the string from start to the end, the detect what is the longest possible palindrome pointer i can form.
        pointer i represents the middle character of a palindrome

        and we create extendPalindrome method to find out the longest palindrome pointer at each i

        It runs in O(n^2) in worst case but is better than dp on average.
    */
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }


    /*


       dp(i, j) represents whether s(i ... j) can form a palindromic substring, dp(i, j) is true
    when s(i) equals to s(j) and s(i+1 ... j-1) is a palindromic substring. When we found a palindrome,
    check if it's the longest one.
     */
}
