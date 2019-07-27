package Amazon.OA2018;

import java.util.*;

public class AgressiveRating {


    public static Map<Integer,Double> rating(List<Result> ratings){
        Map<Integer,Double> res = new HashMap<>();
        if(ratings == null || ratings.size() == 0){
            return res;
        }

        int denum = 5;
        Map<Integer,PriorityQueue<Double>> map = new HashMap<>();

        for(Result each : ratings){
            int id = each.id;
            double rating = each.rating;

            if(!map.containsKey(id)){
                PriorityQueue<Double> pq = new PriorityQueue<>(new Comparator<Double>(){
                    @Override
                    public int compare(Double o1, Double o2){
//                        if(o1 == o2){
//                            return 0;
//                        }if(o1 < o2){
//                            return -1;
//                        }else{
//                            return 1;
//                        }
                        return o1.compareTo(o2);
                    }
                });
                pq.offer(rating);
                map.put(id,pq);
            }else{
                PriorityQueue<Double> pq = map.get(id);
                pq.offer(rating);
                if(pq.size() > denum){
                    pq.poll();
                }
            }
        }


        for(Map.Entry<Integer,PriorityQueue<Double>> entry: map.entrySet()){
            PriorityQueue<Double> pq = entry.getValue();
            int id = entry.getKey();

            double total = 0.0;
            while(!pq.isEmpty()){
                total += pq.poll();
            }
            double score = total / denum;
            res.put(id,score);
        }
        return res;

    }

    public static void main(String[] args) {
        List<Result> list = new ArrayList<>();
        list.add(new Result(1,1.0));
        list.add(new Result(1,2.0));
        list.add(new Result(1,3.0));
        list.add(new Result(1,4.0));
        list.add(new Result(1,5.0));
        list.add(new Result(1,5.0));
        list.add(new Result(1,6.0));
        list.add(new Result(2,2.0));
        list.add(new Result(2,4.0));
        list.add(new Result(2,6.0));
        list.add(new Result(2,8.0));
        list.add(new Result(2,10.0));
        list.add(new Result(2,25.0));
        list.add(new Result(2,20.0));

        Map<Integer,Double> map = rating(list);

        System.out.println(map.toString());


    }


    private static class Result{
        int id;
        double rating;
        public Result(int id, double rating) {
            this.id = id;
            this.rating = rating;
        }
    }
}
