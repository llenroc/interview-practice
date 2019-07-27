package Adobe;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<Integer>> nqueens(int n) {
        // Write your solution here.
        List<List<Integer>> res = new ArrayList<>();
        dfs(n,res,new ArrayList<>());
        return res;
    }

    private void dfs(int n, List<List<Integer>> res, List<Integer> cur){
        if(cur.size() == n){
            res.add(new ArrayList(cur));
            return;
        }
        for(int col = 0;col < n; col++){
            if(isValid(cur,col)){
                cur.add(col);
                dfs(n,res,cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isValid(List<Integer> cur, int col){
        int row = cur.size();
        for(int i = 0; i < row; i++){
            if(cur.get(i) == col || Math.abs(cur.get(i) - col) == row - i) return false;
        }
        return true;
    }
}
