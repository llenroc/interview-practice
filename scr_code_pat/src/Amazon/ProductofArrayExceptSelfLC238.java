package Amazon;

/**
 * Created by yizhaoyang on 7/28/17.
 */
public class ProductofArrayExceptSelfLC238 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] res = productExceptSelf(arr);
        for (int i: res
             ) {
            System.out.print(i + " ");
        }
    }


    /*
    /*
  nums   = [1, 2, 3, 4]
  output = product of nums[left of i] * product of nums[right of i]

    output = [
            24, // left: init=1     nums[i]=1  right: 2 * 3 * 4
            12, // left: 1          nums[i]=2  right: 3 * 4
            8,  // left: 1 * 2      nums[i]=3  right: 4
            6,  // left: 1 * 2 * 3  nums[i]=4  right: init=1
            ]



     */

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
