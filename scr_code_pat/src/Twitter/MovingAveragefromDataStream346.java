package Twitter;

public class MovingAveragefromDataStream346 {
    private static int[] list;
    private static int num,i;
    private static long sum;
    /** Initialize your data structure here. */
    public MovingAveragefromDataStream346(int size) {
        list = new int[size];
        num = 0;
        i = 0;
        sum = 0;
    }

    public double next(int val) {
        if(num < list.length) num++;
        sum -= list[i];
        list[i] = val;
        sum +=val;
        i = (i  + 1)% list.length;
        return (double) sum / num;
    }
}
