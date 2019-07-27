package Microsoft;

import java.util.Stack;


//https://www.youtube.com/watch?v=ZmnqCZp9bBs
public class LC84LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : heights[i]);
            if(s.isEmpty() || h >= heights[s.peek()]){
                s.push(i);
            }else{
                int top = heights[s.pop()];
                if(s.isEmpty()){
                    maxArea = Math.max(maxArea, top * i);
                }else{
                    maxArea = Math.max(maxArea, top * (i - 1 - s.peek()));
                }
                i--;
            }

        }
        return maxArea;
    }
}
