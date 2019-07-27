import java.util.Random;

/**
 * Created by yizhaoyang on 10/9/17.
 */
public class QuickSelect {


    public static void SWAP(int x, int y) { int temp = x; x = y; y = temp; }


    // Partition using Lomuto partition scheme
    static int partition(int a[], int left, int right, int pivotIndex)
    {
        // Pick pivotIndex as pivot from the array
        int pivot = a[pivotIndex];

        // Move pivot to end
        SWAP(a[pivotIndex], a[right]);

        // elements less than pivot will be pushed to the left of pIndex
        // elements more than pivot will be pushed to the right of pIndex
        // equal elements can go either way
        int pIndex = left;
        int i;

        // each time we finds an element less than or equal to pivot, pIndex
        // is incremented and that element would be placed before the pivot.
        for (i = left; i < right; i++)
        {
            if (a[i] <= pivot)
            {
                SWAP(a[i], a[pIndex]);
                pIndex++;
            }
        }

        // Move pivot to its final place
        SWAP (a[pIndex], a[right]);

        // return pIndex (index of pivot element)
        return pIndex;
    }

    // Returns the k-th smallest element of list within left..right inclusive
// (i.e. left <= k <= right).
// The search space within the array is changing for each round - but the list
// is still the same size. Thus, k does not need to be updated with each round.
    static int quickselect(int A[], int left, int right, int k)
    {
        // If the array contains only one element, return that element
        if (left == right)
            return A[left];

        Random rand = new Random();

        // select a pivotIndex between left and right
        int pivotIndex = left + rand.nextInt() % (right - left + 1);

        pivotIndex = partition(A, left, right, pivotIndex);

        // The pivot is in its final sorted position
        if (k == pivotIndex)
            return A[k];

            // if k is less than the pivot index
        else if (k < pivotIndex)
            return quickselect(A, left, pivotIndex - 1, k);

            // if k is more than the pivot index
        else
            return quickselect(A, pivotIndex + 1, right, k);
    }


    // main function
    public static void main(String[] args) {
        int A[] = { 7, 4, 6, 3, 9, 1 };
        int k = 2;

        System.out.printf("K'th smallest element is %d", quickselect(A, 0, A.length - 1, k));


    }
}
