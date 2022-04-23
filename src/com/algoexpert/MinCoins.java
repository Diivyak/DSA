package com.algoexpert;

public class MinCoins {

	public static int minNumCoins(int n , int[] denoms) {
		
		int len = denoms.length;
		int[][] dp = new int[len+1][n+1];
		int M = Integer.MAX_VALUE;
		for(int i=1; i<=n;i++) dp[0][i] = Integer.MAX_VALUE;
		for(int i=1; i<=len;i++) dp[i][0] = Integer.MAX_VALUE;
		
		
		for(int i=1; i<=len;i++) {
			for(int j=1;j<=n;j++) {
				dp[i][j] = (j >= denoms[i-1]) ? Math.min(dp[i-1][j],dp[i-1][j-denoms[i-1]] == M ? M: 1+ dp[i-1][j-denoms[i-1]]) 
						: dp[i-1][j]; 
			}
		}
		return dp[len][n] == Integer.MAX_VALUE ? -1 : dp[len][n];
	}
	public static void main(String[] args) {
		int n = 11;
		int[] A = {1,2,5};
		
		System.out.println(minNumCoins(n, A));
	}

}
