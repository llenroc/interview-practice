package Google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhaoyang on 6/23/17.
 */
public class EncodeDecodeStringsLC271 {
    public class Codec {

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

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
}
