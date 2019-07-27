package Amazon.OA;

/**
 * Created by yizhaoyang on 9/19/17.
 */
public class OverlapRectangle {
    public static boolean check(Node topLeftA, Node topLeftB, Node bottomRightA, Node
            bottomRightB) {
    //if one is above another or x value range does not overlap
    //line overlap is considered as overlap
        if(topLeftA.x > bottomRightB.x || topLeftB.x > bottomRightA.x || bottomRightA.y >
                topLeftB.y || bottomRightB.y > topLeftA.y){
            return false;
        }
        return true;
    }
    public static class Node {
        double x;
        double y;
        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }


//    public boolean doOverlap(Point l1, Point r1, Point l2, Point r2)
//    {
//        // If one rectangle is on left side of other
//        if (l1.x >= r2.x || l2.x >= r1.x)
//            return false;
//        // If one rectangle is above other
//        if (l1.y <= r2.y || l2.y <= r1.y)
//            return false;
//        return true;
//    }
//
//
//    private class Point{
//        int x;
//        int y;
//    }
}
