package Amazon.OA;

/**
 * Created by yizhaoyang on 9/19/17.
 */



import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;


public class kNearestPoint {

    public CPoint[] Solution(CPoint[] array, int k) {

        /*

         Problem: There is a Amazon app designed to deliver a bunch of items to the closest customers with random locations.
         And it ask us to implement a method that
         Find the k closest pickup points to the origin where the truck is

         When I look at the problem like find the maximum or minimum k numbers in a list or a array
         the first ADT that comes to my mind is Priorityqueue
         It is easy . Once we define the comparator, it help us sort the list of numbers in descending or ascending order.

         So. regarding this problem, we can definitely use Priorityqueue Min heap to the store the k neareast points.

         Improvement: ignore Math.sqrt() and the return type will change to int
                       Thus, we can simplify the compare method in comparator to just one line
                       getDistance for a minus getDistance for b for min heap
                       getDistance for b minus getDistance for a for max heap

        Overall, it will be simpler



        Alternative:

        Asides from using PriorityQueue, I also thought about using the sorting algorithm
        Arrays.sort() give us the quick sort.

        And this idea enlightens me that QuickSelect is a perfect match for this question.
        It's supposed
        to find the kth smallest element in an unordered list,
        It will find k smallest point without completely sorting the array. And all the elements that before the one in the index k
        are both smaller than k element. But as I said, it's not completely sorted.
        And it have a obvious advantage is that it's time complexity can down to O(n) on average.

         https://en.wikipedia.org/wiki/Quickselect

         */

        // Time Complexity: O(nlog(n))


        // edge cases
        if(array == null || array.length == 0){
            return array;
        }

        if(k <= 0){
            return new CPoint[0];
        }

        // if k > array's length return sorted array
        if(k > array.length){
            k = array.length;
        }

        // define origin
        CPoint origin = new CPoint();
        origin.x = 0;
        origin.y = 0;

//
//        Arrays.sort(array, new Comparator<CPoint>() {
//            @Override
//            public int compare(CPoint a, CPoint b) {
//                return getDistance(a, origin) - getDistance(b, origin);
//            }
//        });


        // and here we have the result array
        CPoint[] res = new CPoint[k];

        //initialize pq
        PriorityQueue<CPoint> pq = new PriorityQueue<> (k, new Comparator<CPoint> () {

            /*
            instead of:
            return (int) getDistance(a, origin) - getDistance(b, origin);

            because of the data losing
            if the result of getDistance(a, origin) - getDistance(b, origin) is nearly 0 like 0.3
            then it will be rounded to 0 which ends of making them equal to each others. But in face, there
            is a difference b/w.

             */

            // this is a standard way for double comparison
            @Override
            public int compare(CPoint a, CPoint b) {
                if(getDistance(a, origin) - getDistance(b, origin) < 0){
                    return -1;
                }
                if((getDistance(a, origin) - getDistance(b, origin) > 0)){
                    return 1;
                }
                return 0;
            }

//            @Override
//            public int compare(CPoint a, CPoint b) {
//                return（int） getDistance(a, origin) - getDistance(b, origin);
//            }
        });

        //now we put all the points into pq
        for(CPoint p : array){
            // Priority Queue is implemented using Heap Data Structures and Heap has O(log(n)) time complexity to insert and delete element.
            pq.offer(p);
        }

        //get the first k nearest points from pq, set them into the array and return.
        for(int i = 0; i < k; i++){
            res[i] = pq.poll();
        }

        return res;
    }

    // formula of finding the distance b/w two points is: sqrt((a.x - b.x)^2 + (a.y - b.y)^2)
    // we can ignore the Math.sqrt actually. This won't make any changes.
    private double getDistance(CPoint a, CPoint b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }



//    private int getDistance(CPoint a, CPoint b) {
//        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
//    }

    /*
        SOME THOUGHTS

        different approaches: we can also sort the entire list by using divide and conquer.
        Time: Nlog(N)

     */

    private class CPoint{
        int x;
        int y;
    }
}