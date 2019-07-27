package Amazon.OA;

/**
 * Created by yizhaoyang on 9/22/17.
 */
import java.util.*;

public class FriendCircle {
    public static void main(String[] args) {
//
//        assert true == Arrays.equals(
//                new String[] {"friend3", "friend4", "friend5"}
//                , new FriendFriendCircle().findLargestFriendCircle(new String[][]{
//                        {"friend1", "friend2"},
//                        {"friend3", "friend4"},
//                        {"friend4", "friend5"},
//                }));
//
//        assert true == Arrays.equals(
//                new String[] {"friend1", "friend2"}
//                , new FriendFriendCircle().findLargestFriendCircle(new String[][]{
//        {"friend1", "friend2"},
//        {"friend3", "friend4"},
//                }));
//

    }

    private String[] findLargestFriendCircle(String[][] arr1) {

        Map<String, String> unionKeys = new HashMap<>();
        for(String []pair:arr1) {
            unionKeys.put(pair[0],pair[0]);
            unionKeys.put(pair[1],pair[1]);
        }


        for(String[] pair: arr1) {
            String unionKey = null, other = null;
            String key0 = unionKeys.get(pair[0]), key1 = unionKeys.get(pair[1]);
            if(key0.compareTo(key1) < 0) {
                unionKey = key0;
                other = pair[1];
            } else {
                unionKey = key1;
                other = pair[0];
            }
            unionKeys.put(other, unionKey);

        }

        Map<String, Integer> counts = new HashMap<>();
        for(Map.Entry<String, String> ent : unionKeys.entrySet()) {
            counts.put(ent.getValue(), counts.getOrDefault(ent.getValue(), 0) + 1);
        }

        int max = -1;
        String maxKey = null;
        for(Map.Entry<String, Integer> ent : counts.entrySet()) {
            if(ent.getValue() > max || (ent.getValue() == max && ent.getKey().compareTo(maxKey) < 0)) {
                max = ent.getValue();
                maxKey = ent.getKey();
            }
        }

        String[] res = new String[max];
        for(Map.Entry<String, String> ent : unionKeys.entrySet()) {
            if(ent.getValue().equals(maxKey)) {
                res[--max] = ent.getKey();
            }
        }

        Arrays.sort(res);
        System.out.println(Arrays.toString(res));

        return res;
    }

}
