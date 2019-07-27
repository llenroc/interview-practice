package Adobe;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTree(words);

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board,i,j,root,res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode node, List<String> res){
        char c= board[i][j];
        if(c == '#' || node.next[c - 'a'] == null) return;
        node = node.next[c - 'a'];
        if(node.word != null){
            res.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        if(i > 0) dfs(board, i - 1,j, node,res);
        if(j > 0) dfs(board, i,j - 1, node,res);
        if(i < board.length - 1)dfs(board, i + 1,j, node,res);
        if(j < board[0].length - 1)dfs(board, i,j + 1, node,res);
        board[i][j] = c;
    }

    public TrieNode buildTree(String[] words){
        TrieNode root = new TrieNode();
        for(String w: words){
            TrieNode cur = root;
            for(char c: w.toCharArray()){
                if(cur.next[c - 'a'] == null)cur.next[c - 'a'] = new TrieNode();
                cur = cur.next[c - 'a'];
            }
            cur.word = w;
        }
        return root;
    }

    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }

}
