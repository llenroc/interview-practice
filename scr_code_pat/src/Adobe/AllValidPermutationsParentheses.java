package Adobe;

import java.util.ArrayList;
import java.util.List;

public class AllValidPermutationsParentheses {
    public List<String> validParentheses(int n) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), 0,0,n);
        return res;
    }

    private void helper(List<String> res, StringBuilder sb, int open, int close, int n){
        if(open + close == 2 * n){
            res.add(sb.toString());
            return;
        }
        if(open < n){
            sb.append("(");
            helper(res,sb,open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open){
            sb.append(")");
            helper(res,sb,open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
