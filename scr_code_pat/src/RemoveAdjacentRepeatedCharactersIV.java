import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAdjacentRepeatedCharactersIV {
    public static String deDup(String input) {
        // Write your solution here
        if(input == null || input.length() <= 1) return input;
        Deque<Character> stack = new ArrayDeque<>();
        char[] arr = input.toCharArray();
        int j = 1;
        stack.offerLast(arr[0]);
        while(j < arr.length){
            if(stack.isEmpty() || arr[j] != stack.peekLast()){
                stack.offerLast(arr[j++]);
            }else{
                int pre = stack.pollLast();
                while(j < arr.length && arr[j] == pre){
                    j++;
                }
            }
        }

        StringBuilder sb =new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pollFirst());
        }
        return sb.toString();

    }

    public static String deDup2(String input) {
        // Write your solution here
        if(input == null || input.length() <= 1) return input;

        char[] arr = input.toCharArray();
        int end = 0;
        int j = 1;
        while(j < arr.length){
            if(end == -1|| arr[end] != arr[j]){
                end++;
                arr[end] = arr[j++];
            }else{
                int pre = arr[end];
                end--;
                while(j < arr.length && arr[j] == pre){
                    j++;
                }
            }
        }

        return new String(arr, 0 ,end + 1);

    }

    public static void main(String[] args) {
        String s = "bxyyz";
        System.out.println(deDup2(s));
    }
}
