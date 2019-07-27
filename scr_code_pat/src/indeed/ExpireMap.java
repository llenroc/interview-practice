package indeed;


import java.util.*;


//public class ExpireMap<K, V> {
//    // fields
//    Map map = new HashMap<K, Data>();
//
//
//    public void put(K key, V value, long durationMillis) {
//        long startTime = System.currentTimeMillis();
//        Data data = new Data(value, durationMillis, startTime);
//        map.put(key, data);
//    }
//
//    public V get(K key) {
//        Data data = (Data) map.get(key);
//        if (data == null) return null;
//        if (data.startTime + data.duration <= System.currentTimeMillis()) {
//            return (V) data.value;
//        } else {
//            map.remove(key);
//            return null;
//        }
//    }
//
//    private class Data<V> {
//        // fields
//        V value;
//        long duration;
//        long startTime;
//
//        // methods
//        public Data (V value, long duration, long startTime) {
//            this.value = value;
//            this.duration = duration;
//            this.startTime = startTime;
//        }
//    }
//
//}


public class ExpireMap<K,V> {

    Map<K,Data> map;
    PriorityQueue<Data> pq;



    public ExpireMap() {
        this.map =  new HashMap<>();

        pq = new PriorityQueue<>( new Comparator<Data>(){
            @Override
            public int compare(Data a, Data b){
                return (int) ((a.start + a.duration) -(b.start + b.duration));
            }
        });

    }


    public void put(K key, V value, long duration) {

        Data data = new Data(key, value, duration);
        map.put(key, data);
        pq.offer(data);
        remove(System.currentTimeMillis());
    }

    public V get(K key) {
        Data data = map.get(key);
        remove(System.currentTimeMillis());
        if(data == null  || data.isExpired()){
            return null;
        }
        return data.value;
    }

    public void remove(long input){
        while(pq.peek().start +pq.peek().duration < input){
            Data temp = pq.poll();
            map.remove(temp.key);
        }
    }


    class Data{
        long start;
        long duration;
        K key;
        V value;

        public Data( K key, V value, long duration){
            start = System.currentTimeMillis();
            this.duration = duration;
            this.key = key;
            this.value = value;
        }

        public boolean isExpired(){
            return System.currentTimeMillis() > duration + start;
        }
    }
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());

    }
}


