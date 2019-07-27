package GS;

public class SecondSmallest {

    public static int secondSmallest(int[] nums) {
        Integer s1 = null;
        Integer s2 = null;
        for (Integer n : nums) {
//            if (n.equals(s1) || n.equals(s2) ) continue;
            if (s1 == null || n <  s1) {
                s2 = s1;
                s1 = n;
            } else if (s2 == null || n < s2) {
                s2 = n;
            }
        }
        return s2;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1};
        System.out.println(secondSmallest(nums));

    }
}
