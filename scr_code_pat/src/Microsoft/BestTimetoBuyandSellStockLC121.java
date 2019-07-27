package Microsoft;

public class BestTimetoBuyandSellStockLC121 {



    /*
    Say you have an array for which the ith element is the price of a given stock on day i.

    If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

     */
    public int maxProfit(int prices[]) {
        int min = Integer.MAX_VALUE;
        int max =0;

        for(int i = 0; i< prices.length; i++){
            // 如果当前的值比min小 更新min
            if(prices[i] < min){
                min = prices[i];
            }else if(prices[i] - min > max){ // 如果 不比min小 说明 prices[i] - min 有差值 检查是否大于max 更新max
                max = prices[i] - min;
            }

        }
        return max;
    }

    /*
     You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
      However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

     */
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
