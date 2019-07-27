package Uber;

import java.util.*;

public class WordLadderLC127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList), vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int len =1;
        while(!q.isEmpty()) { // 迭代 长度
            int level = q.size();
            for (int i = 0; i< level; i++) { //检查 当前 这一层（这个长度）neighbor

                String w = q.poll();
                if (w.equals(endWord)) return len;

                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();    // 这个要放在里面 因为每次更新一个ch 所以要重新initialize一次 要不然 把之前的也储存了
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == w.charAt(j)) continue;
                        ch[j] = c;
                        String nb = String.valueOf(ch); // charArray  to String
                        if (dict.contains(nb) && !vis.contains(nb)) {
                            q.offer(nb);
                            vis.add(nb);
                        }
                    }
                }
            }
            len++;  // 增加长度
        }
        return 0;
    }
}
