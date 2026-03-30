class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left = 0;
        int right = 1;

        while(left < prices.length && right < prices.length) {
            int profit = prices[right] - prices[left];
            maxProfit = Math.max(maxProfit, profit);

            if(prices[left] > prices[right]) {
                left = right;
            }
            right++;
        }

        return maxProfit;
    }
}
