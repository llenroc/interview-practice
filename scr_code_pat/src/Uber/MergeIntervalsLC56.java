package Uber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervalsLC56 {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) return null;
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0) return res;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        int start = intervals.get(0).start, end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }

        }
        res.add(new Interval(start, end));
        return res;
    }






    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
