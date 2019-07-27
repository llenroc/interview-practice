package Uber;

import java.util.LinkedList;
import java.util.List;

public class PhoneNumberLC17 {
    public List<String> letterCombinations(String digits) {
        //利用queque的特征一直储存但是抛弃，直到最后一位数的前一些之前不断关起来的值才会保存。
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.length() == 0) {
            return ans;
        }

        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");

        for(int i = 0 ; i < digits.length() ; i++){
            int index = digits.charAt(i) - '0';
            while(ans.peek().length() == i){
                String cur = ans.remove();
                for(char ch: mapping[index].toCharArray()){
                    ans.add(cur + ch);
                }
            }
        }
        return ans;

    }
}
