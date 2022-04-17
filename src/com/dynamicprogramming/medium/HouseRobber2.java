package com.dynamicprogramming.medium;

public class HouseRobber2 {

	public static int getMaxMoney(int[] arr) {
		int n = arr.length;
		int ans = Integer.MIN_VALUE;
		int[] dp = new int[n];
		dp[0] = arr[0];
		for(int i=1; i<n-1;i++) {
			dp[i] = Math.max(dp[i-1], i-2 >= 0 ? dp[i-2]+arr[i] : arr[i]);
		}
		
		ans = dp[n-2];
		dp[0] = 0;
		dp[1]= arr[1];
		for(int i=2;i<n;i++) {
			dp[i] = Math.max(dp[i-1], i-2 >= 0 ? dp[i-2]+arr[i] : arr[i]);
		}
		return Math.max(ans,  dp[n-1]);
	}
	public static void main(String[] args) {
//		2 3 2
//		4
//		1 3 2 1
//		int[] A = {10,20,30, 60,70,40};
//		int[] A = {2,3,2};
		int[] A = {1,3,2,1};
		System.out.println(getMaxMoney(A));

	}

}
