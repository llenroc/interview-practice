package Uber;

public class minimumWindowSubstringLC76 {
    public String minWindow(String s, String t) {
        String result = "";
        if(s==""||t.length()>s.length())
            return result;
        int[] map = new int[128];
        int start = 0;
        int minStart = 0;
        int end = 0;
        int count = t.length();
        int minLength = Integer.MAX_VALUE;
        for(char temp:t.toCharArray()){
            map[temp]++;
        }
        while(end<s.length()){
            if(map[s.charAt(end)]>0)
                count--;
            map[s.charAt(end)]--;
            end++;
            while(count==0){
                if (end - start < minLength) {
                    minStart = start;
                    minLength = end - start;
                }
                map[s.charAt(start)]++;
                if (map[s.charAt(start)] > 0)
                    count++;
                start++;
            }
        }
        return (minLength==Integer.MAX_VALUE)?"":s.substring(minStart, minStart+minLength);
    }
}
