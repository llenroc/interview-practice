package Adobe;

import java.util.LinkedList;
import java.util.Queue;

public class matrixBFS {
    /***
     *
     * 1: Given NXN matrix filled with 1,0,2,3.
     * 1(Source)
     * 2(Destination)
     * 3(Blank cell)
     * 0(wall)
     * Write a code to identify whether there is a path possible from source to destination, traversing through blank cells only. You can traverse up, down, right and left
     *
     * https://www.geeksforgeeks.org/find-whether-path-two-cells-matrix/
     */

    public static int bfs(int[][] matrix,Cell start, Cell end){
        int n = matrix.length;
        boolean[][] visited = new boolean[n][n];

        Queue<Cell> q = new LinkedList<>();
        q.offer(start);

        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Cell cur = q.poll();

                if(cur.x == end.x && cur.y == end.y){
                    return level;
                }
                int x = cur.x, y = cur.y;
                visited[x][y] = true;

                System.out.println("x" + x + "   y " + y);
                if(x - 1 >= 0 && !visited[x - 1][y] && (matrix[x - 1][y] != 0)){
                    q.offer(new Cell(x -1, y));
                }
                if(x + 1 < n && !visited[x + 1][y] && (matrix[x + 1][y] != 0)){
                    q.offer(new Cell(x +1, y));
                }
                if(y - 1 >= 0 && !visited[x][y - 1] && (matrix[x][y - 1] != 0)){
                    q.offer(new Cell(x, y - 1));
                }
                if(y + 1 < n && !visited[x][y + 1] && (matrix[x][y + 1] != 0)){
                    q.offer(new Cell(x, y + 1));
                }
            }
            level++;
        }
        return -1;
    }


    static class Cell{
        int x;
        int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] M = {{ 0 , 3 , 1 , 0 },
                     { 3 , 0 , 3 , 3 },
                     { 2 , 3 , 0 , 3 },
                     { 0 , 3 , 3 , 3 }};

        System.out.println(bfs(M,new Cell(0,2), new Cell(2,0)));

    }
}
