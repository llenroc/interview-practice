package Uber;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersectionUnion {

    public List<int[]> intersect(int[][] a, int[][] b) {
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();

        while (i < a.length && j < b.length) {
            int lo = Math.max(b[j][0], a[i][0]);
            int hi = Math.min(a[i][1], b[j][1]);
            if (lo <= hi) {
                res.add(new int[]{lo, hi});
            }
            if (a[i][1] < b[j][1]) {
                i += 1;

            } else {
                j += 1;

            }
        }
        return res;
    }

    // Union
//    public List<Range> union(List<Range> l1, List<Range> l2) {
//        // sanity check
//        if (l1 == null || l1.size() == 0) {
//            return l2;
//        }
//        if (l2 == null || l2.size() == 0) {
//            return l1;
//        }
//
//        int n1 = l1.size();
//        int n2 = l2.size();
//        List<Range> result = new ArrayList<>(n1 + n2);
//
//        int i = 0;
//        int j = 0;
//        Range prev = null;
//
//        if (l1.get(i).start < l2.get(j).start) {
//            prev = l1.get(i++);
//        } else {
//            prev = l2.get(j++);
//        }
//
//        while (i < n1 || j < n2) {
//            Range curr = null;
//            if (i == n1) {
//                curr = l2.get(j++);
//            } else if (j == n2) {
//                curr = l1.get(i++);
//            } else if (l1.get(i).start < l2.get(j).start) {
//                curr = l1.get(i++);
//            } else {
//                curr = l2.get(j++);
//            }
//
//            if (prev.end < curr.start) {
//                result.add(prev);
//                prev = curr;
//            } else if (prev.end < curr.end) {
//                prev.end = cur.end;
//            }
//        }
//        result.add(prev);
//
//        return result;
//    }

}
