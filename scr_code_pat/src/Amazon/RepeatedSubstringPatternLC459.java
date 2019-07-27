package Amazon;

/**
 * Created by yizhaoyang on 8/1/17.
 */
public class RepeatedSubstringPatternLC459 {
    public boolean repeatedSubstringPattern(String str) {
        int l = str.length();
        for(int i = l / 2; i >= 1; i--){
            if(l % i == 0){
                int count = l / i;
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < count; j++){
                    sb.append(str.substring(0,i));
                }
                if(sb.toString().equals(str)) return true;
            }
        }
        return false;
    }
}
