package Uber;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EncodingDecodingString {
    public int compress(char[] arr) {
        if(arr == null || arr.length == 0) return 0;

        int i = 0;
        int fast = 0;
        List<Integer> list = new ArrayList<>();
        while(fast < arr.length){
            int slow = fast;
            while(fast + 1 < arr.length && arr[fast + 1] == arr[fast]){
                fast++;
            }
            arr[i++] = arr[fast];
            if(fast != slow){
                char[] value = String.valueOf(fast - slow + 1).toCharArray();
                for(int j = 0; j < value.length; j++){
                    arr[i++] = value[j];
                }
                fast++;
            }else{
                fast++;
            }
        }
        return i;
    }

     public int compress2(char[] chars) {
         int indexAns = 0, index = 0;
         while(index < chars.length){
             char currentChar = chars[index];
             int count = 0;
             while(index < chars.length && chars[index] == currentChar){
                 index++;
                 count++;
             }
             chars[indexAns++] = currentChar;
             if(count != 1)
                 for(char c : Integer.toString(count).toCharArray())
                     chars[indexAns++] = c;
         }
         return indexAns;
     }



    // s = "3[a]2[bc]", return "aaabcbc".
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
