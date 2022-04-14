package com.dynamicprogramming.medium;

public class SubSetSum {
	
	public static boolean hasSubSetSum(int[] arr, int sum) {
		int n = arr.length;
		boolean[][] dp = new boolean[n+1][sum+1];
		for(int i=0; i<= n;i++) {
			dp[i][0] = true;
		}
		for(int i=1; i<=n;i++) {
			for(int j=1; j<=sum;j++) {
				if(j - arr[i-1] >= 0) {
					dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][sum];
	}
	public static void main(String[] args) {
		int[] A = {1};
		int sum = 1;
		System.out.println(hasSubSetSum(A, sum));

	}

}
