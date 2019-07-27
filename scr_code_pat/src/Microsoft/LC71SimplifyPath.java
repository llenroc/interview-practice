package Microsoft;

import java.util.Stack;

public class LC71SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();

        for(String each: path.split("/")){
            if(each.equals(".") || each.equals("")) continue;
            else if(each.equals("..")){
                if(! s.isEmpty()) s.pop();
            }
            else s.push(each);
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) sb.insert(0, "/" +s.pop());
        return sb.toString().isEmpty() ? "/" : sb.toString();
    }
}
