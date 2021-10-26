import java.util.*;

/*
给一个list， list 的element包含： 发送方，接收方和message. 求收到message频率最高的k个receiver）follow up 比较多，
但‍‍‍‌‍‍‌‌‍‌‌‌‍‍‍‌‌‍是就这题目也没什么花样，譬如，换成sender，boundary case譬如两人频率都是10， 怎么处理（我感觉是按需求来处理）
 */

public class TopKMessage {

    class Love {
        String sender;
        String receiver;
        String message;

        Love(String s, String r, String m) {
            sender = s;
            receiver = r;
            message = m;
        }
    }

    public List<String> getTopK(List<Love> messageList, int k) {
        List<String> result = new ArrayList<>();
        // edge cases
        if (messageList == null || k <= 0)
            return result;

        // assume duplicate only count once
        // construct the map, <String receiver, Set>
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for (Love message : messageList) {
            HashSet<String> set = map.getOrDefault(message.receiver, new HashSet<>());
            if (!set.contains(message.sender))
                set.add(message.sender);
            map.put(message.receiver, set);
        }

        // create minheap, with comparator of the set size
        PriorityQueue<Map.Entry<String, HashSet<String>>> minheap = new PriorityQueue<>(
                (o1, o2) -> o1.getValue().size() - o2.getValue().size());
        for (Map.Entry<String, HashSet<String>> entry : map.entrySet()) {
            minheap.offer(entry);
            if (minheap.size() > k)
                minheap.poll();
        }

        // reverse the order if needed
        while (!minheap.isEmpty()) {
            result.add(minheap.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {

    }

    /*
     * follow up: 1) edge cases 2) duplicate 3) common function to get top k
     * sender/receiver
     */
}
