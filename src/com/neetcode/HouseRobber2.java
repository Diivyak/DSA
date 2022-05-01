package com.neetcode;

public class HouseRobber2 {

	public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int max = Integer.MIN_VALUE;
        int[] amount = new int[n];
        amount[0] = nums[0];
        for(int i=1; i<n-1; i++) {
            if(i==1) {
                amount[i] = Math.max(nums[i], amount[i-1]);
            }else{
                amount[i] = Math.max(amount[i-1], amount[i-2]+nums[i]);
            }
        }
        max = amount[n-2];
        amount[0]= 0;
        for(int i=1; i<n;i++) {
            if(i==1) amount[i] = nums[i];
            else amount[i] = Math.max(nums[i]+amount[i-2], amount[i-1]);
        }
        max = Math.max(max, amount[n-1]);
        return max;
        
    }
	public static void main(String[] args) {
		int[] nums = {1,2,3,1};
		System.out.println(rob(nums));

	}

}
