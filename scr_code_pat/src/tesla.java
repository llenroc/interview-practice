import java.util.ArrayList;
import java.util.List;

public class tesla {

    static String res;
    public static List<String> combination(int a, int b){
        List<String> list = new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        helper(list,sb,a,b);
        return list;
    }

    private static void helper(List<String> list, StringBuilder sb, int a , int b) {
        if(a == 0 && b == 0) {
            list.add(sb.toString());
            return;
        }
//        if(a > 0 && (sb.length() < 3 || sb.charAt(sb.length() - 2) != 'a')){
        if(a > 0 && check(sb.toString(), 'a')){
            sb.append('a');
            helper(list, sb, a - 1, b);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(b > 0 && check(sb.toString(), 'b')) {
            sb.append('b');
            helper(list, sb, a, b - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static boolean check(String s, char c){
        if(s.length() < 2) {
            return true;
        }
        int count = 0;
        for(int i = s.length() - 1; i >= s.length() - 2; i--){
            if(s.charAt(i) == c) count++;
        }
        return count < 2;
    }

    public static void main(String[] args) {
        List<String> list = combination(5,3);
        System.out.println(list);
    }
}
