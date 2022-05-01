package com.neetcode;

public class HouseRobber {

	public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        dp[0] = nums[0];
        for(int i=1; i<n;i++) {
            if(i==1) {
                dp[i] = Math.max(dp[0], nums[i]);
            }
            else 
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            
        }
        return dp[n-1];
    }
	public static void main(String[] args) {
		int[] arr = {1,2,3,1};
		
		System.out.println(rob(arr));

	}

}
