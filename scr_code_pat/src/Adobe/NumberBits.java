package Adobe;

public class NumberBits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0, test = 1;

        for(int i = 0; i < 32; i++){
            if((n & test) != 0)
                count++;
            test <<= 1;
        }
        return count;
    }

    public static int hammingWeight2(int n) {
        int ones = 0;
        while(n!=0) {
            ones = ones + (n & 1);
            n = n>>>1;
        }
        return ones;
    }
}
