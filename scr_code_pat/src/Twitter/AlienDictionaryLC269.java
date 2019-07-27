package Twitter;

import java.util.*;

public class AlienDictionaryLC269 {
    public String alienOrder(String[] words) {
        // key是pre value是successor
        // x -> set: y,z,t,w means x comes before all the letters in the set.
        Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
        // degree , how many letters come before the key
        Map<Character, Integer> degree=new HashMap<Character, Integer>();
        String result="";
        if(words==null || words.length==0) return result;
        // set how many elements in the degree
        for(String s: words){
            for(char c: s.toCharArray()){
                degree.put(c,0);
            }
        }
        // rule,  comparing the adjacent words, the first character in both words at the same position
        // that is different between two adjacent words reflect the lexicographical order
        for(int i=0; i<words.length-1; i++){
            String cur=words[i];
            String next=words[i+1];
            int length=Math.min(cur.length(), next.length());
            for(int j=0; j<length; j++){
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                if(c1!=c2){
                    Set<Character> set=new HashSet<Character>();
                    if(map.containsKey(c1)) set=map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }

        // BFS
        Queue<Character> q=new LinkedList<Character>();
        for(char c: degree.keySet()){
            if(degree.get(c)==0) q.add(c);
        }
        while(!q.isEmpty()){
            char c=q.remove();
            result+=c;
            if(map.containsKey(c)){
                for(char c2: map.get(c)){
                    degree.put(c2,degree.get(c2)-1);
                    if(degree.get(c2)==0) q.add(c2);
                }
            }
        }
        if(result.length()!=degree.size()) return "";
        return result;
    }
}
