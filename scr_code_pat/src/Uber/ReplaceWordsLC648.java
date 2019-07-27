package Uber;

import java.util.List;

public class ReplaceWordsLC648 {
    public String replaceWords(List<String> dict, String sentence) {
        String[] tokens = sentence.split(" ");
        TrieNode trie = buildTrie(dict);
        return replaceWords(tokens, trie);
    }

    private String replaceWords(String[] tokens, TrieNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String token : tokens) {
            stringBuilder.append(getShortestReplacement(token, root));
            stringBuilder.append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length()-1);
    }

    private String getShortestReplacement(String token, TrieNode root) {
        TrieNode temp = root;
        StringBuilder sb = new StringBuilder();
        for(char c: token.toCharArray()){
            if(temp.children[c - 'a'] != null){
                sb.append(c);
                if(temp.children[c - 'a'].isWord) return sb.toString();
                temp = temp.children[c - 'a'];
            }else{
                return token;
            }
        }
        return token;
    }

    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode(' ');
        for(String each: dict){
            TrieNode temp = root;
            for(Character c: each.toCharArray()){
                if(temp.children[c - 'a'] == null){
                    temp.children[c - 'a'] = new TrieNode(c);
                }
                temp = temp.children[c - 'a'];
            }
            temp.isWord = true;
        }
        return root;
    }

    private class TrieNode {
        char val;
        TrieNode[] children;
        boolean isWord;

        public TrieNode(char val) {
            this.val = val;
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
}
