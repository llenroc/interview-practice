package Google;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhaoyang on 6/28/17.
 */
public class WordBreakLC139 {
    public static boolean wordBreak(String s, List<String> dict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }


    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aaa");
        System.out.println(wordBreak(s,list));
    }
}
