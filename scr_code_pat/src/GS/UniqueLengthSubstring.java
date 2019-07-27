package GS;

import java.util.*;

public class UniqueLengthSubstring {



//    public static String[] uniqueSubString (String s, int k){
//        if(s == null || s.length() == 0) return null;
//        Set<Character> set = new HashSet<>();
//        List<String> list = new ArrayList<>();
//
//        int i = 0;
//
//        for(int j = 0; j< s.length(); j++){
//            set.add(s.charAt(j));
//            while(set.size() > k){
//                set.remove(s.charAt(i));
//                i++;
//            }
//            if(set.size() == k){
//                list.add(s.substring(i,j + 1));
//            }
//        }
//
//        return list.toArray(new String[list.size()]);
//    }

    public static String[] uniqueSubString (String s, int k){
        if(s == null || s.length() == 0) return null;
        Set<String> set = new TreeSet<>();

        int i = 0;

        for(int j = 0; j< s.length(); j++){
            if( j - i  + 1 == k){
                String cur = s.substring(i,j + 1);
                set.add(cur);
                i++;
            }
        }
        String[] res = new String[set.size()];
        i =0;
        for(String each: set){
            res[i++] = each;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababacc";
        String[] list = uniqueSubString(s,3);
        for (String each: list
             ) {
            System.out.print(each + " ");
        }
        System.out.println();
        char[] ch = {'b','z','t','e','s','.','!','@',' '};
        Arrays.sort(ch);
        for (char c: ch
             ) {
            System.out.print(c + " ");
        }

    }
}
