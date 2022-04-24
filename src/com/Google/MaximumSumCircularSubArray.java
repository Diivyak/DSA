package com.Google;

public class MaximumSumCircularSubArray {

	public static int maxSubarraySumCircular(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0; i<n;i++)  sum += nums[i];
        int[] dp = new int[n];
        
        for(int i=0; i<n;i++) {
        	if(i!= 0)
            dp[i] = Math.max(nums[i], Math.max(sum - nums[i], dp[i-1]));
        	else
        		dp[i] =  nums[i] > 0 ? Math.max(nums[i], sum - nums[i]) : Math.max(nums[i], sum + nums[i]);
        }
        return dp[n-1];
        
    }
	public static void main(String[] args) {
		int[] arr = {5,-3,5};
		System.out.println(maxSubarraySumCircular(arr));

	}

}
