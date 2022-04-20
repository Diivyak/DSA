package com.Google;

public class BuySellStock1 {

	public static int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = prices[0];
        int profit = 0;
        
        for(int i=1; i<n;i++) {
            profit = Math.max(profit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return profit < 0 ? 0 : profit;
        
    }
	public static void main(String[] args) {
		int[] prices = {7,6,4,3,1};
		
		System.out.println(maxProfit(prices));

	}

}
