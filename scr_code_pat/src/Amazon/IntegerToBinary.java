package Amazon;

/**
 * Created by yizhaoyang on 7/25/17.
 */
public class IntegerToBinary {

    public static void main(String[] args) {

//        System.out.println(toBinary(6));
        numToBin(6);
    }

    public static String convert(int n){
        StringBuilder sb= new StringBuilder();
        int operator = 1;
        int i = 0;

        while(Math.pow(2,i) <= n){

            String binary = (operator & n) == Math.pow(2,i)? "1" : "0";
            sb.append(binary);
            i++;
        }
        return sb.toString();
    }

    public static String toBinary(int number){
        StringBuilder sb = new StringBuilder();

        if(number == 0)
            return "0";
        while(number>=1){
            sb.append(number%2);
            number = number / 2;
        }

        return sb.reverse().toString();

    }




















    public static void numToBin ( int num){
       String res = "";
        while(num >= 1){
            if(num % 2 == 0) res = "0" + res;
            else res = "1" + res;
            num = num/ 2;
        }
        System.out.println("result :" + res);
    }
























}





