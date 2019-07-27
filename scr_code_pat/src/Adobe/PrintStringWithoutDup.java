package Adobe;

public class PrintStringWithoutDup {

    public String printStringWithoutDup(String s){
        int[] dict = new int[26];
        int end = 0;
        StringBuilder sb = new StringBuilder();

        for(int i =0 ; i< s.length(); i++){
            char ch = s.charAt(i);
            dict[ch - 'a']++;
            if(dict[ch - 'a'] != 1) continue;
            sb.append(ch);
        }
        return sb.toString();


        // 如何用bit做 一个int储存

    }

    public static void main(String[] args) {


    }
}
