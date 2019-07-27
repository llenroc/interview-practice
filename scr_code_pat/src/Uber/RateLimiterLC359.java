package Uber;

import java.util.*;

public class RateLimiterLC359 {

    /** Initialize your data structure here. */
    private static final int MAX_TIME_WINDOW = 10;

    Queue<TimeMsg> msgQueue;
    public RateLimiterLC359() {
        msgQueue = new LinkedList<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {

        while (!msgQueue.isEmpty() && timestamp - msgQueue.peek().timestamp >= MAX_TIME_WINDOW) {
            msgQueue.poll();
        }

        Iterator<TimeMsg> iter = msgQueue.iterator();
        while (iter.hasNext()) {
            TimeMsg tm = iter.next();
            if (tm.msg.equals(message)) return false;
        }


        msgQueue.offer(new TimeMsg(timestamp, message));

        return true;
    }

    class TimeMsg {
        int timestamp;
        String msg;
        public TimeMsg(int timestamp, String msg) {
            this.timestamp = timestamp;
            this.msg = msg;
        }
    }



    //不同的id 多个用户
    Queue<Node> q = new ArrayDeque<>();
    Map<String,Integer> dict = new HashMap<>(); // ip, called Times


    public boolean ipLimiter(double timestamp, String ip, int callTimes){
        while ( !q.isEmpty() && timestamp - q.peek().time >= 1){
            Node t = q.poll();
            dict.remove(t.ip);
        }
        if(!dict.containsKey(ip)){
            if(callTimes > 100){
                return false;
            }
            q.offer(new Node(timestamp, ip));
            dict.put(ip,callTimes);
            return true;
        }else{
            if(dict.get(ip) + callTimes <= 100){
                dict.put(ip, dict.get(ip) + callTimes);
                return true;
            }
        }
        return false;
    }

    private static class Node{
        double time;
        String ip;
        public Node(double t, String ip){
            this.time = t;
            this.ip = ip;
        }
    }
}
