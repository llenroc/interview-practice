import java.util.Random;

/**
 * Created by yizhaoyang on 6/16/17.
 */
public class QUICKSORT {

    public static void main(String[] args) {
        int[] a = {1,3,2};
        quickSort(a,0,a.length - 1);
        for (int each: a) {
            System.out.print(each + " ");
        }
    }

    public static void quickSort(int[] arr, int left, int right ) {
        if(left >= right) return;
        int pivotIndex = partition(arr, left,right);
        quickSort(arr,left, pivotIndex -1);
        quickSort(arr,pivotIndex+1, right);
    }

    public static int partition(int[] arr, int left, int right){
        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left +1);
//        int pivotIndex = left;
        swap(arr,pivotIndex,right);
        int leftBound = left, rightBound = right -1;
        while(leftBound <= rightBound){
            if(arr[leftBound] < arr[right]){
                leftBound++;
            }else if(arr[rightBound] > arr[right]){
                rightBound--;
            }else{
                swap(arr, leftBound++, rightBound--);
            }
        }
        swap(arr,leftBound, right);
        return leftBound;
    }

//    public static void quickSort(int[] a, int lo, int hi){
//        int i = lo, j = hi;
//        int pivot = a[lo + (hi - lo) / 2];
//
//
//        /*
//        after sorting it will be like
//
//
//        start
//        lo . . . . . . . . . . . . . . .hi
//        i                               j
//
//        after
//        lo . . . . . . . . . . . . . . .hi
//                     j i
//
//        if( lo < j )       if( i < hi)
//        sort(lo,j)         sort(i hi)
//
//
//         */
//        while( i <= j){
//
//            while (a[j] > pivot){
//                j--;
//            }
//            while (a[i] < pivot){
//                i++;
//            }
//            if(i <= j){
//                swap(a,i,j);
//                i++;
//                j--;
//            }
//        }
//
//        if( lo < j ){
//            quickSort(a,lo,j);
//        }
//        if( i < hi){
//            quickSort(a,i,hi);
//        }
//    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
