package PoketGem.OA;

import java.util.*;
import java.io.*;

public class RoyalNumber{


    public static void main(String[] args) {
        String[] names = { "ABC II",
                "ABC III",
                "ABC IX",
                "ABCd I",
                "a V",
                "a VI"};
        sort(names);
        printNames(names);

    }

    public static void sort(String[] names)
    {

        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] a = o1.split(" ");
                String[] b = o2.split(" ");
                if(a[0].equals(b[0])){
                    return romanToInt(a[1]) - romanToInt(b[1]);
                }
                return a[0].compareTo(b[0]);
            }
        });

    }

    public static void printNames(String[] names)
    {
        for(int l=0; l<names.length; l++)
        {
            System.out.println(names[l]);
        }
    }



    public static int romanToInt(String s) {
        int res = 0;
        for(int i = s.length() -1; i >=0; i--){
            char c = s.charAt(i);
            switch(c){
                case 'I':
                    res += (res >= 5? -1 : 1);
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10 * (res >= 50? -1 : 1);
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C' :
                    res += 100 * (res >= 500? -1:1);
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }

}
