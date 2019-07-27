package Microsoft;

public class LC443StringCompression {

    public int compress(char[] chars) {
        if(chars == null || chars.length == 0) return 0;

        int slow = 0;
        int count = 0;

        for(int fast = 0; fast < chars.length; fast++){
            count++;
            if(fast == chars.length - 1 || chars[fast] != chars[fast + 1]){
                chars[slow] = chars[fast];
                slow++;
                if(count > 1){
                    char[] temp = String.valueOf(count).toCharArray();
                    for(int i =0; i < temp.length; i++){
                        chars[slow] = temp[i];
                        slow++;
                    }
                }
                count = 0;
            }



        }
        return slow;
    }
}
