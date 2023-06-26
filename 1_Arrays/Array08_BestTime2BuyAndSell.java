/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:
    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
    Input: prices = [7,6,4,3,1]
    Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

Constraints:

    1 <= prices.length <= 105
    0 <= prices[i] <= 104

*/

public class  Array08_BestTime2BuyAndSell {

    public static int maxProfit (int[] price) {     //TC -> O(n)
        int buyPrice = Integer.MAX_VALUE, maxProfit = 0;

        for(int i = 0; i < price.length; i++) {
            if(buyPrice < price[i]) {   //when our buying price is less than current day price ...... on that day we may be sell the stock --> we can calculate our maxProfit
                int profit = price[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {    //but when our buyPrice is greater than current day price...... we only can buy the stock
                buyPrice = price[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr1 = {7,1,5,3,6,4};
        int[] arr2 = {7,6,4,3,1};

        System.out.println("Maximum profit >> "+maxProfit(arr1));
    }
}