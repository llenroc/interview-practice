package Microsoft;

public class intConvertBinary {


    public static void main(String[] args) {
        int num = 233;
        String bin = new String();
        bin = decToBin(num);
        System.out.println(bintoDec2("11101001"));

//        System.out.println(Integer.valueOf("5"));
    }

    static String decToBin(int num){
        if(num == 1)
            return "1";
        if(num == 0)
            return "0";

        return decToBin(num/2) + (num % 2);
    }

    static int bintoDec(String bin){
        int res = 0;

        for(int i = 0; i <= bin.length() - 1; i ++){
            if(bin.charAt(i) == '1'){
                res += (int) Math.pow(2.00,(double) bin.length() -1 - i);
            }
        }
        return res;
    }

    static int bintoDec2 (String bin){
        int res = 0, j = 0;
//        if(bin.length() == 1) return Integer.valueOf(bin);
        for(int i = bin.length()-1; i>=0; i--){
            res += Math.pow((bin.charAt(i) - '1' + 1)*2, j++);
        }
        return res;
    }

}
