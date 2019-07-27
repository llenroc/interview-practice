package Microsoft;

import java.util.*;

public class SkylineLC218 {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b:buildings) {
            // start point has negative height value
            height.add(new int[]{b[0], -b[2]});
            // end point has normal height value
            height.add(new int[]{b[1], b[2]});
        }

        Collections.sort(height, (a,b) ->{
            if(a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        pq.offer(0);
        int pre = 0;
        for(int[] h: height){
            if(h[1] < 0){
                pq.offer(-h[1]);
            }else{
                pq.remove(h[1]);
            }

            int cur = pq.peek();
            if(pre != cur){
                result.add(new int[]{h[0],cur});
                pre = cur;
            }
        }
        return result;
    }
}
