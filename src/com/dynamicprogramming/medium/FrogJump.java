package com.dynamicprogramming.medium;

public class FrogJump {

	public static int minCost(int[] cost) {
		int n = cost.length;
		int[] dp = new int[n];
		
		dp[0] = 0;dp[1] = Math.abs(cost[0]-cost[1]);
		for(int i=2; i<n; i++) {
			dp[i] = Math.min(dp[i-2] + Math.abs(cost[i] - cost[i-2]), dp[i-1] + Math.abs(cost[i] - cost[i-1]));
		}
		return dp[n-1];
	}
	public static void main(String[] args) {
//		int[] A = {10, 20, 30 ,10};
//		int[] A = {10, 50 ,10};
//		int[] A = {7, 4, 4, 2, 6 ,6 ,3, 4 };
		int[] A = {4, 8 ,3 ,10, 4 ,4 };
		System.out.println(minCost(A));

	}

}
