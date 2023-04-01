class Solution {
  public int maxProfit(int[] prices) {
    // initalize minPrice with max value to obtain min val in array
    int minPrice = Integer.MAX_VALUE; 

    // initialize to keep track
    int maxProfit = 0;

    for (int price : prices) {
      // obtain the min price from array
      minPrice = Math.min(minPrice, price);

      // calculate profit
      int profit = price - minPrice;

      // obtain max profit of either current or already existing
      maxProfit = Math.max(maxProfit, profit);
    }

    return maxProfit;
  }
}