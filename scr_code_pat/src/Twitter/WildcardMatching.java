package Twitter;

public class WildcardMatching {
    public boolean isMatch(String str, String pattern) {
        if(str==null || pattern == null) return false;
        int s = 0, p = 0, sMark = -1, star = -1;
        while(s < str.length()){
            if(p < pattern.length() && (str.charAt(s) == pattern.charAt(p) || pattern.charAt(p) == '?' )){
                s++;
                p++;
            }else if(p < pattern.length() && pattern.charAt(p) == '*'){
                sMark = s;
                star = p;
                p++;
            }else if(star != -1){
                sMark++;
                s = sMark;
                p = star + 1;
            }else{
                return false;
            }
        }
        if(p < pattern.length() && pattern.charAt(p) == '*'){
            p++;
        }
        return p == pattern.length();
    }
}
