package Amazon;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yizhaoyang on 7/22/17.
 */
public class LetterCombinationsPhoneNumberLC17 {
    public List<String> letterCombinations(String digits) {
        //利用queque的特征一直储存但是抛弃，直到最后一位数的前一些之前不断关起来的值才会保存。
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.length() == 0) {
            return ans;
        }
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");

        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            // 这个 condition就是check 你现在在第几轮 刚开始是0轮所以 ans.peek().length()应该是零
            // 走了一轮过后 就应该加长度为1的  这样避免加新的
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;

    }

}
