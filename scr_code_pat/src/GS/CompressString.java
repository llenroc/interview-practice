package GS;

public class CompressString {



    public static String summaryRanges(String s) {

        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        int fast = 0;
        while(fast < chars.length){
            int slow = fast;
            while(fast + 1 < chars.length && chars[fast + 1]== chars[fast]){
                fast++;
            }
            sb.append((fast - slow + 1)).append(chars[slow]);
            fast++;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(summaryRanges("aaabbbbbcctttgggsss"));
    }
}
