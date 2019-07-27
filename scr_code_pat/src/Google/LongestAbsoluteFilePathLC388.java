package Google;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by yizhaoyang on 6/25/17.
 */
public class LongestAbsoluteFilePathLC388 {

    /*
        这道题要想这个实物图
        dir
        subdir1
            file1.ext
            subsubdir1
        subdir2
            subsubdir2
                file2.ext
        dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext


     */

    public static void main(String[] args) {
        String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(lengthLongestPath(s));
    }

    public static int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for(String s:input.split("\n")){
            int lev = s.lastIndexOf("\t")+1; // number of "\t"
            while(lev + 1<stack.size()) stack.pop(); // find parent  一个\t代表前面有几个东西 所以一直pop 直到lev + 1 = stack.size()； 因为加了个0在最开始
            int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"   因为这里要peek  所以一开始一定要加
            stack.push(len);
            // check if it is file
            if(s.contains(".")) maxLen = Math.max(maxLen, len-1);
        }
        return maxLen;
    }
}
