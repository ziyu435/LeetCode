public class OnePassSolution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int minprice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    // 1. Focus on the profit, instead of the minprice and maxpricce.
    // 2. Iterate the prices in order to find the minprice,
    //    and in the meantime, to find the max profit.
    // 3. If the price is not the min price, then it could be a positive profit relative to the minprice.
    //    We maintain the profit.
    // 4. It is possible that the minprice could be the last day.
    //    However, it doesn't matter.
    //    Because the maxprofit wouldn't be updated when we iterate to the last day.
}

//public class Solution {
//     public int maxProfit(int[] prices) {
//         int maxprofit = 0;
//         for(int i = 0; i < prices.length - 1; i++) {
//             for(int j = i + 1; j < prices.length; j++) {
//                 int profit = prices[j] - prices[i];
//                 if (maxprofit < profit) {
//                     maxprofit = profit;
//                 }
//             }
//         }
//         return maxprofit;
//     }
// }


