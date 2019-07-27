package Uber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSumsLC373 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b)->a[0]+a[1]-b[0]-b[1]);
        List<int[]> res = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return res;
        for(int i=0; i<nums1.length && i<k; i++) que.offer(new int[]{nums1[i], nums2[0], 0});
        while(k-- > 0 && !que.isEmpty()){
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            if(cur[2] == nums2.length-1) continue;
            que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
        }
        return res;
    }


    public int kthSum(int[] A, int[] B, int k) {
        // Write your solution here

        PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>(){
            @Override
            public int compare(Cell a, Cell b){
                int sum1 = A[a.a1Idx] + B[a.a2Idx];
                int sum2 = A[b.a1Idx] + B[b.a2Idx];
                return Integer.compare(sum1,sum2);
            }
        });
        boolean[][] visited = new boolean[A.length][B.length];
        pq.offer(new Cell(0,0));
        visited[0][0] = true;
        for(int i = 0; i < k - 1; i++){
            Cell cur = pq.poll();
            if(cur.a1Idx + 1< A.length && !visited[cur.a1Idx + 1][cur.a2Idx]){
                visited[cur.a1Idx + 1][cur.a2Idx] = true;
                pq.offer(new Cell(cur.a1Idx + 1,cur.a2Idx));
            }
            if(cur.a2Idx + 1< B.length && !visited[cur.a1Idx][cur.a2Idx + 1]){
                visited[cur.a1Idx][cur.a2Idx + 1] = true;
                pq.offer(new Cell(cur.a1Idx,cur.a2Idx + 1));
            }
        }
        Cell res = pq.peek();
        return A[res.a1Idx] + B[res.a2Idx];
    }

    public class Cell{
        int a1Idx;
        int a2Idx;
        public Cell(int i1, int i2){
            a1Idx = i1;
            a2Idx = i2;
        }
    }

    class Node{
        int x;
        int y;
        int val;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
