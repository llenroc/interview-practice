package Microsoft;

public class LC208ImplementTrie_PrefixTree {
    TrieNode root;
    /** Initialize your data structure here. */
    public LC208ImplementTrie_PrefixTree() {
        root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()){
            if(cur.next[c - 'a'] == null){
                cur.next[c - 'a'] = new TrieNode(c);
            }
            cur = cur.next[c - 'a'];
        }
        cur.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()){
            if(cur.next[c - 'a'] == null) return false;
            cur = cur.next[c - 'a'];
        }
        return cur.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c: prefix.toCharArray()){
            if(cur.next[c- 'a'] == null) return false;
            cur = cur.next[c- 'a'];
        }
        return true;
    }

    class TrieNode{
        TrieNode[] next;
        char val;
        boolean end;

        public TrieNode(char ch){
            next = new TrieNode[26];
            end = false;
            val = ch;
        }
    }
}
