package Amazon;

/**
 * Created by yizhaoyang on 7/23/17.
 */
public class BestTimeBuySellLC121 {
    public int maxProfit(int prices[]) {
        // int minprice = Integer.MAX_VALUE;
        // int maxprofit = 0;
        // for (int i = 0; i < prices.length; i++) {
        //     if (prices[i] < minprice)
        //         minprice = prices[i];
        //     else if (prices[i] - minprice > maxprofit)
        //         maxprofit = prices[i] - minprice;
        // }
        // return maxprofit;

        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0 ; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else if(prices[i] - min > max){
                max = prices[i] - min;
            }
        }
        return max;
    }
}
