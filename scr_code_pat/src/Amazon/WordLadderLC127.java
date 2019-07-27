package Amazon;

import java.util.*;


/**
 * Created by yizhaoyang on 7/28/17.
 */
public class WordLadderLC127 {

    public static void main(String[] args) {
        String[] arr = new String[]{"most","fist","lost","cost","fish"};

        String b = "lost";
        String e = "cost";
        System.out.println(ladderLength(b,e,Arrays.asList(arr)));

    }


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
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

    //The above code can still speed up if we also begin from end.
    // Once we meet the same word from start and end, we know we are done.
    public int ladderLength2(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }
}
