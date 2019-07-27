package Amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yizhaoyang on 7/25/17.
 */
public class NameDictionary {

    TrieNode root;

    public static void main(String[] args) {

    }


    public NameDictionary(){

        root = new TrieNode();

    }

//    public void insert(String word){
//        TrieNode current = root;
//
//        for(int i = 0; i < word.length(); i++){
//            char ch = word.charAt(i);
//            TrieNode node = current.children.get(ch);
//            if(node == null){
//                node = new TrieNode();
//                current.children.put(ch,node);
//            }
//            current = node;
//        }
//
//    }
//
//



    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;
        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }
}
