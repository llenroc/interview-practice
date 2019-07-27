package GS;

public class ReverseSentence {

    public static String reververSentence(String s){
        if(s == null || s.length() == 0) return "";
        String[] list = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(String each: list){
            sb.append(reverse(each.toCharArray()) + " ");
        }
        return sb.toString().trim();
    }

    private static String reverse(char[] arr){
        int i =0, j = arr.length -1;
        while(i< j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        String s = "hello world";
        System.out.println(reververSentence(s));


    }
}
