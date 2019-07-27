package Google.OA;

import java.util.TreeSet;

public class KEmptySlots {
        public static int kEmptySlots(int[] flowers, int k) {
            TreeSet<Integer> active = new TreeSet(); // store the positions of flowers, and the flowers are added in the order of they blooming
            int day = 0;
            for (int flower: flowers) {
                day++;
                active.add(flower);
                Integer lower = active.lower(flower);
                System.out.println("lower" + lower);
                Integer higher = active.higher(flower);
                System.out.println("higher" + higher);
                if (lower != null && flower - lower - 1 == k ||
                        higher != null && higher - flower - 1 == k)
                    return day;
            }
            return -1;
        }


    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2};
        System.out.println(kEmptySlots(arr,1));
    }
}
