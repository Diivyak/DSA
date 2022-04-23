package com.algoexpert;

public class NumberOfWaysToMakeChange {

	public static int numberOfWaysToMakeChange(int n, int[] denoms) {
	    int len = denoms.length;
			int[][] dp = new int[len+1][n+1];
			dp[0][0] = 1;
			for(int i=1; i<=len;i++) {
				for(int j=0; j<=n;j++) {
				
					dp[i][j] = dp[i-1][j] ;
					if(j >= denoms[i-1]) Math.min(dp[i][j], dp[i][j-denoms[i-1]]);
				}
			}
	    return dp[len][n];
	  }
	public static void main(String[] args) {
		int n = 10;
		int[] A = {1,5,10,25};
		
		System.out.println(numberOfWaysToMakeChange(n, A));

	}

}
