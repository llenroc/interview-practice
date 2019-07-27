import java.util.*;

public class Paypal {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i <nums.length; i++){
            if(map.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }


    // all pairs of index
    public List<List<Integer>> allPairs(int[] arr, int target) {
        // Write your solution here.
        List<List<Integer>> res = new ArrayList<>();
        if(arr == null || arr.length <= 1) return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            List<Integer> list = map.get(target - arr[i]);
            if(list != null){
                for(int j : list){
                    res.add(Arrays.asList(j,i));
                }
            }
            if(!map.containsKey(arr[i])){
                map.put(arr[i], new ArrayList<>());
            }
            // 这里没有else条件
            map.get(arr[i]).add(i);
        }
        return res;
    }

    // all pairs of value(contains duplicate)
    public List<List<Integer>> allPairs3(int[] arr, int target) {
        // Write your solution here.
        List<List<Integer>> res = new ArrayList<>();
        // key: number value : frequency
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            Integer count = map.get(arr[i]);
            if(arr[i] * 2 == target && count != null && count == 1){
                res.add(Arrays.asList(arr[i],arr[i]));
            }else if(map.containsKey(target - arr[i]) && count == null ){
                res.add(Arrays.asList(target - arr[i], arr[i]));
            }
            if(count == null){
                map.put(arr[i],1);
            }else{
                map.put(arr[i],count + 1);
            }
        }
        return res;
    }
    // LCA
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);
        if(left != null &&  right!= null) return root;
        return (left== null)? right: left;
    }


    // merge interval
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

    // IntervalIntersectionUnion
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


    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }


    public static int firstUniqChar2(char[] arr){
        int map = 0;

        for(int i = 0; i < arr.length; i++){
            map |= 1 << (arr[i] - 'a');
        }

        for(int i = 0; i < arr.length; i++){
            int value =  1 << (arr[i] - 'a') & map;
            if(value == 0){
                return i;
            }
        }
        return -1;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while(cur != null && count != k){
            cur = cur.next;
            count++;
        }

        if(count == k){
            cur = reverseKGroup(cur,k);

            ListNode pre = cur;
            while(count >0){
                ListNode temp = head.next;
                head.next = pre;
                pre = head;
                head = temp;
                count--;
            }
            head = pre;

        }
        return head;

    }

    // Find All Anagrams in a String
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256];
        for(char c: p.toCharArray()){
            hash[c]++;
        }
        int left = 0, right = 0, count = p.length();

        while(right < s.length()){
            if(hash[s.charAt(right)] >=1 ){
                count--;
            }
            hash[s.charAt(right)]--;
            right++;

            if(count == 0){
                list.add(left);
            }
            if(right - left == p.length()){
                if(hash[s.charAt(left)]  >= 0){
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;

            }

        }
        return list;
    }


    // extra space   +-*/
    public static int calculate1(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        int re = 0;
        for (int i : stack) {
            re += i;
        }
        return re;
    }


    // O(1) space
    public int calculate(String s) {
        if (s == null) return 0;
        s = s.trim().replaceAll(" +", "");
        int length = s.length();

        int res = 0;
        long preVal = 0; // initial preVal is 0
        char sign = '+'; // initial sign is +
        int i = 0;
        while (i < length) {
            long curVal = 0;
            while (i < length && (int) s.charAt(i) <= 57 && (int) s.charAt(i) >= 48) { // int
                curVal = curVal * 10 + (s.charAt(i) - '0');
                i++;
            }
            if (sign == '+') {
                res += preVal;  // update res
                preVal = curVal;
            } else if (sign == '-') {
                res += preVal;  // update res
                preVal = -curVal;
            } else if (sign == '*') {
                preVal = preVal * curVal; // not update res, combine preVal & curVal and keep loop
            } else if (sign == '/') {
                preVal = preVal / curVal; // not update res, combine preVal & curVal and keep loop
            }
            if (i < length) { // getting new sign
                sign = s.charAt(i);
                i++;
            }
        }
        res += preVal;
        return res;
    }


    // +- ()
    public int calculate3(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (int) (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        if (number != 0) result += sign * number;
        return result;


    }


    public int basicCalculatorIII(String s) {
        int l1 = 0, o1 = 1;
        int l2 = 1, o2 = 1;

        Deque<Integer> stack = new ArrayDeque<>(); // stack to simulate recursion

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int num = c - '0';

                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(++i) - '0');
                }

                l2 = (o2 == 1 ? l2 * num : l2 / num);

            } else if (c == '(') {
                // First preserve current calculation status
                stack.offerFirst(l1); stack.offerFirst(o1);
                stack.offerFirst(l2); stack.offerFirst(o2);

                // Then reset it for next calculation
                l1 = 0; o1 = 1;
                l2 = 1; o2 = 1;

            } else if (c == ')') {
                // First preserve the result of current calculation
                int num = l1 + o1 * l2;

                // Then restore previous calculation status
                o2 = stack.poll(); l2 = stack.poll();
                o1 = stack.poll(); l1 = stack.poll();

                // Previous calculation status is now in effect
                l2 = (o2 == 1 ? l2 * num : l2 / num);

            } else if (c == '*' || c == '/') {
                o2 = (c == '*' ? 1 : -1);

            } else if (c == '+' || c == '-') {
                l1 = l1 + o1 * l2;
                o1 = (c == '+' ? 1 : -1);

                l2 = 1; o2 = 1;
            }
        }

        return (l1 + o1 * l2);
    }

    public String decodeString(String s) {
        Stack<Integer> countS = new Stack<>();
        Stack<String> resS = new Stack<>();
        int index = 0;
        String res= "";
        while(index < s.length()){
            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while(index < s.length() && Character.isDigit(s.charAt(index))){
                    count = count * 10 +  (s.charAt(index) - '0');
                    index++;
                }
                countS.push(count);
            }else if(s.charAt(index) == '['){
                resS.push(res);
                res = "";
                index++;
            }else if(s.charAt(index) == ']'){
                StringBuilder sb = new StringBuilder(resS.pop());
                int count = countS.pop();
                for(int i = 0; i< count; i++){
                    sb.append(res);
                }
                res = sb.toString();
                index++;
            }else{
                res += s.charAt(index);
                index++;
            }
        }
        return res;
    }





    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
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
