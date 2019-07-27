/**
 * Created by yizhaoyang on 7/28/17.
 */
public class RangeSumQueryMutableLC307 {



    // segment tree

    int[] tree;
    int n;
    public RangeSumQueryMutableLC307(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }



    /*

    We will use a very effective bottom-up approach to build segment tree.
    We already know from the above that if some node pp holds the sum of [i \ldots j][i…j] range,
    its left and right children hold the sum for range [i .... (i + j) /2 ]and [ (i + j) /2 + 1, j]respectively.

    Therefore to find the sum of node pp, we need to calculate the sum of its right and left child in advance.
    We begin from the leaves, initialize them with input array elements a[0, 1, \ldots, n-1]a[0,1,…,n−1]. Then
     we move upward to the higher level to calculate the parents' sum till we get to the root of the segment tree.

     */
    private void buildTree(int[] nums) {
        for (int i = n, j = 0;  i < 2 * n; i++,  j++)
            tree[i] = nums[j];
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }


    /*\
    When we update the array at some index ii we need to rebuild the segment tree,
    because there are tree nodes which contain the sum of the modified element. Again we will use a bottom-up approach.
    We update the leaf node that stores a[i]a[i]. From there we will follow the path up to the root updating the value of
    each parent as a sum of its children values.
     */
    public void update(int pos, int val) {
        pos += n;
        tree[pos] = val;
        while (pos > 0) {
            int left = pos;
            int right = pos;
            if (pos % 2 == 0) {
                right = pos + 1;
            } else {
                left = pos - 1;
            }
            // parent is updated after child is updated
            tree[pos / 2] = tree[left] + tree[right];
            pos /= 2;
        }
    }


    public int sumRange(int l, int r) {
        // get leaf with value 'l'
        l += n;
        // get leaf with value 'r'
        r += n;
        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) {
                sum += tree[l];
                l++;
            }
            if ((r % 2) == 0) {
                sum += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] arr = {5,1,2,3,4,5,6,7,8};
        RangeSumQueryMutableLC307 rs = new RangeSumQueryMutableLC307(arr);
        for(int each: rs.tree){
            System.out.print(each + " ");
        }


    }

}
