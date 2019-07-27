package Uber;

import java.util.ArrayList;
import java.util.List;

public class EncodeandDecodeStringsLC271 {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String each:strs){
            sb.append(each.length()).append("/").append(each);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < s.length()){
            int slash = s.indexOf("/",i);
            int count = Integer.parseInt(s.substring(i,slash));
            res.add(s.substring(slash+1,slash + count + 1));
            i =slash + count + 1;
        }
        return res;
    }
}
