import java.util.ArrayList;
import java.util.List;

public class CombinationsOfCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, coins, target, new ArrayList<Integer>(), 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] coins, int target,
                     List<Integer> list, int index) {
        if (index == coins.length) {
            if (target == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        } else {
            int len = target / coins[index];
            for (int i = 0; i <= len; i++) {
                list.add(i);
                dfs(res, coins, target - i * coins[index], list, index + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    // 提前一步
    private void dfs2(List<List<Integer>> res, int[] coins, int target,
                      List<Integer> list, int index) {
        if (index == coins.length - 1) {
            if (target % coins[index] == 0) {
                list.add(target / coins[index]);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return;
            } else {
                int len = target / coins[index];
                for (int i = 0; i <= len; i++) {
                    list.add(i);
                    dfs2(res, coins, target - i * coins[index], list, index + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}