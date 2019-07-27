package Uber;

public class FirstUniqueCharacterinStringLC387 {
    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }


    public static int firstUniqChar2(char[] arr){
        int map = 0;

        for(int i = 0; i < arr.length; i++){
            map |= 1 << (arr[i] - 'a');
        }

        for(int i = 0; i < arr.length; i++){
            int value =  1 << (arr[i] - 'a') & map;
            if(value == 0){
                return i;
            }
        }
        return -1;
    }
}
