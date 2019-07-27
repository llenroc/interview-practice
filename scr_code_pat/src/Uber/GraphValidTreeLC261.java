package Uber;

import java.util.Arrays;

public class GraphValidTreeLC261 {
    public boolean validTree(int n, int[][] edges) {

        int[] arr = new int[n];
        Arrays.fill(arr, -1);

        for(int[] each: edges){
            int x = find(arr, each[0]);
            int y = find(arr, each[1]);

            if(x == y) return false;
            arr[y] = x;
        }

        return edges.length == n - 1;
    }

    private int find(int[] arr , int id){
        if(arr[id] == -1) return id;
        return find(arr, arr[id]);
    }

}
