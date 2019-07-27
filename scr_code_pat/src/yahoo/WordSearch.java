package yahoo;

public class WordSearch {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) return true;
        visited = new boolean[board.length][board[0].length];
        char[] wordList = word.toCharArray();
        for(int rows = 0; rows < board.length; rows++){
            for(int cols = 0; cols < board[0].length; cols++){
                if(board[rows][cols] == wordList[0]){
                    // 一定注意是 如果结果是true 才 return 要不然的话碰见false的情况就不往下转了
                    if(dfs(board,wordList,rows,cols, 0)) return true;
                    // return recurse(board,wordList,rows,cols,0);
                }
            }
        }
        return false;
    }



    private boolean dfs(char[][] board, char[] word, int row, int col, int index){
        if(index == word.length) return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if( board[row][col] != word[index] ||index >= word.length || visited[row][col]) return false;
        visited[row][col] = true;
        if( dfs(board,word,row + 1,col,index +1) ||
                dfs(board,word,row - 1,col,index +1) ||
                dfs(board,word,row,col + 1,index +1) ||
                dfs(board,word,row,col - 1,index +1)
                ){
            visited[row][col] = false;
            return true;
        }
        visited[row][col] = false;
        return false;
    }
}
