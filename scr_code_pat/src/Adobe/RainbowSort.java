package Adobe;

public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        // Write your solution here
        int neg = 0;
        int zero = 0;
        int one = array.length - 1;

        while(zero <= one){
            if(array[zero] == -1){
                swap(array,neg++, zero++);
            }else if(array[zero] == 0){
                zero++;
            }else{
                swap(array,zero, one--);
            }
        }
        return array;
    }


    public void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] =   temp;
    }
}
