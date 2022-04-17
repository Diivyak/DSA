package com.dynamicprogramming.medium;

import java.util.Arrays;

public class FrongJumpAtmostK {

	public static int frogJumpAtmostK(int[] heights, int k) {
		int n = heights.length;
		int[] dp = new int[n];
		Arrays.fill(dp, (int)1e8);
		dp[0] = 0;
		for(int i=1; i<n;i++) {
			for(int j= k; j>=1; j--) {
				if(i-j >= 0)
					dp[i] = Math.min(dp[i], dp[i-j] + Math.abs(heights[i-j] - heights[i]));
			}
		}
		return dp[n-1];
	}
	public static void main(String[] args) {
		int[]  heights = {40, 10 ,20, 70, 80, 10, 20, 70, 80, 60};
		System.out.println(frogJumpAtmostK(heights,4));

	}

}
