package Amazon;

import java.util.Stack;

/**
 * Created by yizhaoyang on 9/12/17.
 */
public class LC42TrappingRainWater {


    /*
    The main idea is : if we want to find out how much water on a bar(bot), we need to find
    out the left larger bar's index (il), and right larger bar's index(ir), so that the water is
    (min(A[il],A[ir])-A[bot])*(ir-il-1), use min since only the lower boundary can hold water,
    and we also need to handle the edge case that there is no il.

    To implement this we use a stack that store the indices with decreasing bar height,
    once we find a bar who's height is larger, then let the top of the stack be bot,
    the cur bar is ir, and the previous bar is il.


     */
    public static int trap(int[] A) {
        if (A==null) return 0;
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, maxWater = 0, maxBotWater = 0;
        while (i < A.length){
            if(!s.isEmpty()) {
                System.out.println("condition: i " + i + "__ " + A[i] + " s.peek " + s.peek() + "__" + A[s.peek()]);
            }
            if (s.isEmpty() || A[i]<=A[s.peek()]){
                s.push(i++);
            }
            else {


                //先 pop的是 bot 再peek的是 left bar
                //这是横线的加面积
                int bot = s.pop();


                maxBotWater = s.isEmpty()? // empty means no il
                        0      :    (Math.min(A[s.peek()],A[i])-A[bot])*(i-s.peek()-1);

                // debug
//                if(!s.isEmpty()) {
//                    System.out.println("left bar is: " + s.peek() + "__" + A[s.peek()]);
//                    System.out.println("right bar is: " + i + "__" + A[i]);
//                    System.out.println("bot is: " + bot + "__" + A[bot]);
//                    System.out.println("width is: " + (i - s.peek() - 1));
//                    System.out.println("Area is: " + maxBotWater);
//                    System.out.println();
//                    System.out.println();
//                }
                maxWater += maxBotWater;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
}
