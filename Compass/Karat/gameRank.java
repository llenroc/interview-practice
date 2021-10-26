public static List<String> getOrder(String[] games) {
    LinkedList<String> res = new LinkedList<>();
    if (games == null || games.length == 0) return res;
    Map<String, Integer> inDegree = new HashMap<>();
    Map<String, List<String>> graph = new HashMap<>();
    for (String game : games) {
        String[] team = game.split(" beat ");
        inDegree.put(team[1], inDegree.getOrDefault(team[1], 0));
        inDegree.put(team[0], inDegree.getOrDefault(team[0], 0) + 1);
        graph.computeIfAbsent(team[1], x -> new ArrayList<>()).add(team[0]);
    }
    Queue<String> queue = new LinkedList<>();
    Iterator<Map.Entry<String, Integer>> iterator = inDegree.entrySet().iterator();
    while (iterator.hasNext()) {
        Map.Entry<String, Integer> entry = iterator.next();
         if (entry.getValue() == 0) {
             queue.offer(entry.getKey());
             iterator.remove();
         }
    }

    while (!queue.isEmpty()) {
        String curr = queue.poll();
        List<String> next = graph.get(curr);
        res.addFirst(curr);
        if (next == null || next.size() == 0) continue;
        for (String n : next) {
            inDegree.put(n, inDegree.get(n) - 1);
            if (inDegree.get(n) == 0) {
                inDegree.remove(n);
                queue.offer(n);
            }
        }
    }
    return res;
}
