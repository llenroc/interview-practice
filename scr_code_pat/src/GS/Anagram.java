package GS;

import java.util.*;

public class Anagram {

    public static boolean isAnagram(String s, String t) {
        s = s.toLowerCase();
        t = t.toLowerCase();
        int[] list = new int[26];
        for(char ch: s.toCharArray()){
            if(!Character.isLetter(ch)) continue;
            list[ch - 'a']++;
        }
        for(char ch: t.toCharArray()){
            if(!Character.isLetter(ch)) continue;
            list[ch - 'a']--;
            if(list[ch - 'a'] < 0) return false;
        }
        for(int num: list){
            if(num != 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String s1 = "cdabe*^#";
        String s2 = "a!b*c$d(e";

        System.out.println(isAnagram(s1,s2));
    }
}
