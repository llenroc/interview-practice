import java.util.*;

public class ReachableBusiness {
    public Business a = new Business("A", new HashMap<Business, Integer>());
    public Business b = new Business("B", new HashMap<Business, Integer>());
    public Business c = new Business("C", new HashMap<Business, Integer>());
    public Business d = new Business("D", new HashMap<Business, Integer>());
    public Business e = new Business("E", new HashMap<Business, Integer>());
    public Business f = new Business("F", new HashMap<Business, Integer>());
    public Business g = new Business("G", new HashMap<Business, Integer>());
    public Business h = new Business("H", new HashMap<Business, Integer>());

    public ReachableBusiness() {
        a.nearby_business.put(b, 2);
        a.nearby_business.put(c, 4);
        b.nearby_business.put(a, 2);
        b.nearby_business.put(d, 5);
        c.nearby_business.put(a, 4);
    }

    private class Business {
        public String name;
        public HashMap<Business, Integer> nearby_business;

        public Business(String name, HashMap<Business, Integer> nearby_business) {
            this.name = name;
            this.nearby_business = nearby_business;
        }
    }

    public List<String> find_reachable_businesses(Business starting_business, int distance) {
        List<String> rb = new ArrayList<>();
        HashMap<String, Integer> dis = new HashMap<>();
        dis.put(starting_business.name, 0);
        HashSet<String> visited = new HashSet<>();
        Queue<Business> q = new LinkedList<>();
        q.add(starting_business);

        while (!q.isEmpty()) {
            Business root = q.poll();
            visited.add(root.name);
            for (Business bu: root.nearby_business.keySet()) {
                if (!visited.contains(bu.name)) {
                    q.add(bu);
                    if (dis.containsKey(bu.name)) {
                        int newdis = dis.get(root.name) + root.nearby_business.get(bu);
                        if (newdis < dis.get(bu.name)) {
                            dis.put(bu.name, newdis);
                        }
                    } else {
                        dis.put(bu.name, root.nearby_business.get(bu));
                    }
                }
            }
        }

        for (String name: dis.keySet()) {
            if (dis.get(name) <= distance && !name.equals(starting_business.name)) {
                rb.add(name);
            }
        }
        return rb;
    }

    public void output() {
        List<String> res = find_reachable_businesses(a, 7);
        for (String s: res)
            System.out.print(s + " ");
        System.out.println("");
    }
}
