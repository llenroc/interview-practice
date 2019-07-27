package yahoo;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k %nums.length;
        swap(nums, 0, nums.length - 1);
        swap(nums,0,k - 1);
        swap(nums,k, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j){
        int temp = 0;
        while(i <j){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
