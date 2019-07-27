package Adobe;

public class MergeSortedArrayLC88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int k = m + n - 1;
        m = m-1;
        n = n-1;
        while( m >= 0 || n >= 0){
            if(n < 0 ) break;
            else if(m < 0){
                nums1[k--] =nums2[n--];
            }else if(nums1[m] < nums2[n]){
                nums1[k--] = nums2[n--];
            }else{
                nums1[k--] = nums1[m--];
            }
        }
    }
}
