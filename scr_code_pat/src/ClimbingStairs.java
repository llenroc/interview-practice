/**
 * Created by yizhaoyang on 6/23/17.
 */
public class ClimbingStairs {


    public static int recursive(int n, int m){
        if(n == 0) return 1;
        if(n < 0) return 0;
        int sum = 0;
        for (int i = 1; i <= m; i++) {
            sum += recursive(n - i,m);
        }
        return sum;
    }

    static int countWays(int s, int m)
    {
        return recursive(s, m);
    }



    // dp solution
    static int countWaysUtil(int n, int m)
    {
        int res[] = new int[n];
        res[0] = 1; res[1] = 1;
        for (int i=2; i<n; i++)
        {
            res[i] = 0;
            for (int j=1; j<=m && j<=i; j++)
                res[i] += res[i-j];
        }
        return res[n-1];
    }



//    public static void main (String args[])
//    {
//        int m = 2,n = 2;
//        System.out.println("Number of ways = "+ countWaysUtil(n,m));
//    }

    public static void main(String[] args)
    {
        int n = 8, m = 3;
        System.out.println("Nuber of ways = " + countWaysUtil(n + 1, m));
    }
}
