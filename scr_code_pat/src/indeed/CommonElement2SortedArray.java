package indeed;

public class CommonElement2SortedArray {


    public static int findCommonElement(int[] a1, int[] a2){
        if(a1 == null || a2 == null || a1.length == 0|| a2.length == 0) return -1;

        int i = 0,j = 0;
        int len = Math.min(a1.length, a2.length);

        while(i < len || j < len){
            int v1 = a1[i];
            int v2 = a2[j];
            if(v1 == v2) return v1;
            if( v1 < v2) i++;
            else j++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a1 = {2,4,6,8,9,32,42};
        int[] a2= {1,3,5,15};

        System.out.println(findCommonElement(a1,a2));
    }

}
