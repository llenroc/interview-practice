package Google;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by yizhaoyang on 6/22/17.
 */
public class wallsAndGatesLC286 {
    // 典型 bfs题目
    public void wallsAndGates(int[][] rooms) {

        if(rooms.length == 0|| rooms[0].length == 0 ) return;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i< rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0)
                    queue.add(new int[]{i , j});
            }
        }

        while(!queue.isEmpty()){
            int[] current = queue.remove();
            int row = current[0], col = current[1];

            if(row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE){
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row - 1, col});
            }
            if(col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE){
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }
            if(row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE){
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row+1, col});
            }
            if(col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE){
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[]{row,col+1});
            }
        }
    }
}
