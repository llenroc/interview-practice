package Adobe;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yizhaoyang on 6/23/17.
 */


public class TrieTree {



    private class TrieNode {
        char val;
        Map<Character, TrieNode> children;
        boolean endOfWord;
        public TrieNode(char val) {
            children = new HashMap<>();
            endOfWord = false;
            this.val = val;
        }
    }

    private final TrieNode root ;

    public TrieTree(){
        root = new TrieNode(' ');
    }


    public void insert(String word){
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                node = new TrieNode(ch);
                current.children.put(ch,node);
            }
            current = node;
        }

        current.endOfWord = true;

    }

    public boolean search(String word){
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);

            if(node == null) return  false;
            current = node;
        }
        return current.endOfWord;
    }

    public void delete(String word){
        delete(root,word,0);
    }

    public boolean delete(TrieNode current, String word, int index){
        if(index == word.length()){
            if(!current.endOfWord) return false;
            current.endOfWord = false;
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if(node == null){
            return false;
        }

        boolean shouldDeleteCurrentNode = delete(node,word,index+1);

        if(shouldDeleteCurrentNode){
            current.children.remove(ch);
            return current.children.size() == 0;
        }
        return false;
    }
}
