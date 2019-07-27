import java.util.*;
import java.util.LinkedHashSet;

public class testingoa {
    public static List<String> mostCommonWord(String paragraph, String[] banned) {
        paragraph.split("'.");
        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        Map<String, Integer> map = new HashMap();

        int max = 0;

        List<String> res = new ArrayList<>();

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String current = word.toString();
                if (!banset.contains(current)) {
                    map.put(current, map.getOrDefault(current, 0) + 1);
                    if (map.get(current) >= max) {
                        if(map.get(current) > max){
                            res.clear();
                        }

                        res.add(current);
                        max = map.get(current);
                    }
                }
                word = new StringBuilder();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "Jack and Jill went to the market to buy bread and cheese. cheese is Jack's jill's favorite word";
        String[] arr = {""};
        System.out.println(mostCommonWord(s,arr));
    }
}
