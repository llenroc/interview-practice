/**
 * Created by yizhaoyang on 16/12/2016.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {9, 8, 6, 4, 5, 3, 7, 2, 1};
        int[] copy = new int[a.length];
        sort(a,copy,0,a.length-1);
        for(int num:a){
            System.out.print(num+ " ");
        }
    }


    public static void sort(int[] arr, int[] copy, int lo, int hi){
        if(lo >= hi) return;
        int mi = lo + (hi - lo)/2;  //???
        sort(arr,copy,lo,mi);
        sort(arr,copy,mi + 1, hi);
        merge(arr,copy,lo,hi);
    }



    private static void merge(int[] arr, int[] copy, int lo, int hi){
        // copy data
        for(int k = lo; k <= hi ; k++){
            copy[k] = arr[k];
        }

        int mid = lo + (hi - lo)/2;
        int i = lo, j = mid + 1;
        for(int k = lo; k<= hi; k++){
            if( i > mid) arr[k] = copy[j++];
            else if( j > hi) arr[k] = copy[i++];
            else if (copy[i] < copy[j]) arr[k] = copy[i++];
            else arr[k] = copy[j++];
        }
        /*
                   lo = 0 hi = 10
                    i = 0  j = 6
                     i                 j
                arr: 7, 2, 1, 4, 5, 3, 7, 2, 1, 5 , 9

                     i                 j
               copy: 9, 8, 6, 4, 5, 3, 7, 2, 1, 5 , 9




         */
    }



}
