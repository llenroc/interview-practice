package PoketGem;

public class LC28ImplementstrStr {
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) { // i keep track of the first same character position if there occurs a substring same as needle
            for (int j = 0; ; j++) { // j iterates entire needle
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
