package Adobe;

public class ProductofArrayExceptSelfLC238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int temp = 1;
        for(int i = 0; i<res.length;i++){
            res[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for(int i = nums.length - 1; i >=0; i--){
            res[i] *= temp;
            temp *= nums[i];
        }
        return res;
    }
}
