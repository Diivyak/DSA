package com.neetcode;

public class MinimumSizeSubarraySum {

	public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        
        for(r = 0; r<n;r++) {
        	sum += nums[r];
        	while(target <= sum) {
        		minLen = Math.min(minLen,  r-l+1);
        		sum -= nums[l];
        		l++;
        	}
        }
        return minLen == Integer.MAX_VALUE ?  0 : minLen;
    }
	public static void main(String[] args) {
//		int[] arr = {2,3,1,2,4,3};
		int[] arr = {1,2,3,4,5};
//		15
//		[1,2,3,4,5]
		
//		System.out.println(minSubArrayLen(7, arr));
		System.out.println(minSubArrayLen(15, arr));
	}

}
