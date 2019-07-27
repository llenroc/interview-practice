package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yizhaoyang on 9/25/17.
 */
public class LC252MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return true;

        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b ){
                return a.start - b.start;
            }
        });

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < intervals[i - 1].end){
                return false;
            }
        }
        return true;
    }


    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args) {
        List list = new ArrayList<>(5);

    }
}
