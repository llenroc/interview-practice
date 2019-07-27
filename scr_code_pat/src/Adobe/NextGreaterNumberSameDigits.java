package Adobe;

import java.util.Arrays;
/***


 Following are few observations about the next greater number.
 1) If all digits sorted in descending order, then output is always “Not Possible”. For example, 4321.
 2) If all digits are sorted in ascending order, then we need to swap last two digits. For example, 1234.
 3) For other cases, we need to process the number from rightmost side (why? because we need to find the smallest of all greater numbers)

 You can now try developing an algorithm yourself.

 Following is the algorithm for finding the next greater number.
 I) Traverse the given number from rightmost digit, keep traversing till you find a digit which is smaller than the previously traversed digit.
 For example, if the input number is “534976”, we stop at 4 because 4 is smaller than next digit 9.
 If we do not find such a digit, then output is “Not Possible”.

 ***/
public class NextGreaterNumberSameDigits {

    // Utility function to swap two digit
    static void swap(char ar[], int i, int j)
    {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    static void findNext(char ar[], int n)
    {
        int i;

        // I) Start from the right most digit
        // and find the first digit that is smaller
        // than the digit next to it.
        for (i = n - 1; i > 0; i--)
        {
            if (ar[i] > ar[i - 1]) {
                break;
            }
        }

        // If no such digit is found, then all
        // digits are in descending order means
        // there cannot be a greater number with
        // same set of digits
        if (i == 0)
        {
            System.out.println("Not possible");
        }
        else
        {
            int x = ar[i - 1], min = i;

            // II) Find the smallest digit on right
            // side of (i-1)'th digit that is greater
            // than number[i-1]
            for (int j = i + 1; j < n; j++)
            {
                if (ar[j] > x && ar[j] < ar[min])
                {
                    min = j;
                }
            }
            // III) Swap the above found smallest
            // digit with number[i-1]
            swap(ar, i - 1, min);

            // IV) Sort the digits after (i-1)
            // in ascending order
            Arrays.sort(ar, i, n);
            System.out.print("Next number with same" +
                    " set of digits is ");
            for (i = 0; i < n; i++)
                System.out.print(ar[i]);
        }
    }
}
