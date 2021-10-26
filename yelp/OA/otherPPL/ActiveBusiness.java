import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActiveBusiness {
    public List<Event> events;
    public int eventTypeAmount;

    private class Event{
        String type;
        int times;
        int biz_id;

        public Event(String type, int times, int biz_id) {
            this.type = type;
            this.times = times;
            this.biz_id = biz_id;
        }
    }

    /*private class Biz{
        int id;
        int photo_views;
        int ads;
        int page_views;
        int reviews;

        public Biz(int id, int photo_views, int ads, int page_views, int reviews){
            this.id = id;
            this.photo_views = photo_views;
            this.ads = ads;
            this.page_views = page_views;
            this.reviews = reviews;
        }
    }*/

    public ActiveBusiness(){
        events = new ArrayList<>();
        eventTypeAmount = 4;
        events.add(new Event("ads", 7, 3));
        events.add(new Event("ads", 8, 2));
        events.add(new Event("ads", 5, 1));
        events.add(new Event("page_views", 11, 2));
        events.add(new Event("page_views", 12, 3));
        events.add(new Event("photo_views", 10, 3));
        events.add(new Event("reviews", 7, 2));
    }

    public List<Integer> findActiveBusiness(List<Event> events) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer[]> bizs = new HashMap<>();
        int[] sum = new int[eventTypeAmount];
        int[] count = new int[eventTypeAmount];
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).type.equals("photo_views")) {
                sum[0] += events.get(i).times;
                count[0]++;
                if (!bizs.containsKey(events.get(i).biz_id)) {
                    Integer[] temp = {0, 0, 0, 0};
                    temp[0] = events.get(i).times;
                    bizs.put(events.get(i).biz_id, temp);
                } else {
                    Integer[] temp = bizs.get(events.get(i).biz_id);
                    temp[0] = events.get(i).times;
                    bizs.put(events.get(i).biz_id, temp);
                }
            } else if (events.get(i).type.equals("ads")) {
                sum[1] += events.get(i).times;
                count[1]++;
                if (!bizs.containsKey(events.get(i).biz_id)) {
                    Integer[] temp = {0, 0, 0, 0};
                    temp[1] = events.get(i).times;
                    bizs.put(events.get(i).biz_id, temp);
                } else {
                    Integer[] temp = bizs.get(events.get(i).biz_id);
                    temp[1] = events.get(i).times;
                    bizs.put(events.get(i).biz_id, temp);
                }
            } else if (events.get(i).type.equals("page_views")) {
                sum[2] += events.get(i).times;
                count[2]++;
                if (!bizs.containsKey(events.get(i).biz_id)) {
                    Integer[] temp = {0, 0, 0, 0};
                    temp[2] = events.get(i).times;
                    bizs.put(events.get(i).biz_id, temp);
                } else {
                    Integer[] temp = bizs.get(events.get(i).biz_id);
                    temp[2] = events.get(i).times;
                    bizs.put(events.get(i).biz_id, temp);
                }
            } else if (events.get(i).type.equals("reviews")) {
                sum[3] += events.get(i).times;
                count[3]++;
                if (!bizs.containsKey(events.get(i).biz_id)) {
                    Integer[] temp = {0, 0, 0, 0};
                    temp[3] = events.get(i).times;
                    bizs.put(events.get(i).biz_id, temp);
                } else {
                    Integer[] temp = bizs.get(events.get(i).biz_id);
                    temp[3] = events.get(i).times;
                    bizs.put(events.get(i).biz_id, temp);
                }
            }
        }
        double[] avg = new double[4];
        for (int i = 0; i < sum.length; i++) {
            if (count[i] != 0)
                avg[i] = sum[i] / count[i];
        }
        for (int i: bizs.keySet()) {
            Integer[] t = bizs.get(i);
            int c = 0;
            for (int j = 0; j < t.length; j++) {
                if (t[j] >= avg[j])
                    c++;
            }
            if (c >= 2)
                res.add(i);
        }
        return res;
    }

    public void output() {
        List<Integer> res = findActiveBusiness(events);
        for (Integer s: res)
            System.out.print(s + " ");
        System.out.println("");
    }
}
