class solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // create hashmap key: element value: frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int val = map.getOrDefault(num, 0) + 1;
            map.put(num, val);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}