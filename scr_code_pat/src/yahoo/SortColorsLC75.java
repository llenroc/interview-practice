package yahoo;

public class SortColorsLC75 {
    // 1.
    // The idea is to sweep all 0s to the left and all 2s to the right, then all 1s are left in the middle.
    public void sortColors(int A[], int n) {
        int second=n-1, zero=0;
        for (int i=0; i<=second; i++) {
            while (A[i]==2 && i<second) swap(A, i, second--);
            while (A[i]==0 && i>zero) swap(A, i,zero++);
        }
    }

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

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }

    // 2.
    // two pass O(m+n) space
    void sortColors1(int A[], int n) {
        int num0 = 0, num1 = 0, num2 = 0;

        for(int i = 0; i < n; i++) {
            if (A[i] == 0) ++num0;
            else if (A[i] == 1) ++num1;
            else if (A[i] == 2) ++num2;
        }

        for(int i = 0; i < num0; ++i) A[i] = 0;
        for(int i = 0; i < num1; ++i) A[num0+i] = 1;
        for(int i = 0; i < num2; ++i) A[num0+num1+i] = 2;
    }


    // 4 colors
    // time O(kn)
    public void sortColors2(int[] colors, int k) {
        int pivotL = 0;
        int pivotR = colors.length - 1;
        int i = 0;
        int min = 1, max = k;
        while (min < max) {
            while (i <= pivotR) {
                if (colors[i] == min) {
                    swap(colors, pivotL, i);
                    i++;
                    pivotL++;
                } else if (colors[i] == max) {
                    swap(colors, pivotR, i);
                    pivotR--;
                } else {
                    i++;
                }
                // printArray(colors);
            }
            i = pivotL;
            min++;
            max--;
        }
    }
}
