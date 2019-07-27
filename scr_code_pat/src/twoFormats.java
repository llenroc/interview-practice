import java.util.*;

/**
 * Created by yizhaoyang on 6/28/17.
 */
public class twoFormats {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }


    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();


        PriorityQueue<Interval> q= new PriorityQueue<Interval>(intervals.size(), new Comparator<Interval>(){
            public int compare(Interval a, Interval b){return a.end - b.end;}
        });

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if (i1.start != i2.start) {
                    return i1.start - i2.start;
                }
                return i1.end - i2.end;
            }
        });


    }

}
