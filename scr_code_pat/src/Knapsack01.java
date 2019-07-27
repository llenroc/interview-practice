/**
 * Created by yizhaoyang on 6/21/17.
 */
public class Knapsack01 {


    public static void main(String[] args) {
        System.out.printf("lala");
    }

    public static int bottomUp(int[] v, int[] w,int W){
        int K[][] = new int[v.length + 1][W + 1];

        // j是我们目前的总共重量 i是我们value 和weight的选择区间
        for(int i =0; i <= v.length; i++){
            for(int j = 0; j <= W; j++){
                if(i == 0 || j == 0) continue;
                if(w[i] > j){
                    K[i][j] = K[i - 1][j];
                }else{
                    // the reason that we pick v[i - 1] and w[i - 1] is that both indexes of v and w starts from 0.
                    // It's in the same level just subtracted by 1
                    // current item + the optimal value we can pick without current item(i) given the rest of the weight
                    K[i][j] = Math.max(K[i - 1][j], v[i - 1] + K[i - 1][ j - w[i - 1]]);
                }
            }
        }
        return K[v.length][W];
    }
}
