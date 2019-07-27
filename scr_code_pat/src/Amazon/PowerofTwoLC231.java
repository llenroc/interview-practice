package Amazon;

/**
 * Created by yizhaoyang on 8/1/17.
 */
public class PowerofTwoLC231 {
    public boolean isPowerOfTwo(int n) {
        if(n > 1){
            while(n % 2 == 0){
                n = n /2;
            }
        }
        return n == 1;
    }
}
