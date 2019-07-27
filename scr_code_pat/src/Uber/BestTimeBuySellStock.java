package Uber;

public class BestTimeBuySellStock {
    public int maxProfit(int prices[]) {
        int min = Integer.MAX_VALUE;
        int max =0;

        for(int i = 0; i< prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else if(prices[i] - min > max){
                max = prices[i] - min;
            }

        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        if(prices.length == 0) return 0;
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
}
