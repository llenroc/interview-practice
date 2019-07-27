package GS;

public class ClimbStairs3 {


    public static int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] step = new int[n];
        step[0]=1;
        step[1]=2;
        step[2]=3;
        for(int i = 3; i < step.length; i++) {
            step[i] = step[i - 1] + step[i - 2] + step[i - 3];
        }
        return step[n - 1];
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(8));
    }
}
