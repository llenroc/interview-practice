package Google;

import java.util.List;

/**
 * Created by yizhaoyang on 6/24/17.
 */
public class WordSquareLC422 {
    // 这个其实就是把它想成了一个2Darray
    /*
    Input:
        [
          "abcd",
          "bnrt",
          "crmy",
          "dtye"
        ]
     */
    public class Solution {
        public boolean validWordSquare(List<String> words) {
            if(words == null || words.size() == 0){
                return true;
            }
            int n = words.size();
            for(int i=0; i<n; i++){
                for(int j=0; j<words.get(i).length(); j++){
                    if(j >= n || words.get(j).length() <= i || words.get(j).charAt(i) != words.get(i).charAt(j))
                        return false;
                }
            }
            return true;
        }
    }
}
