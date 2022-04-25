package com.Google;

public class KadaneAlgo {

	public static int maxSumSubArray(int[] nums) {
		int n = nums.length;
		int minSum = 0,totalSum = 0, sum = 0;
		for(int i=0; i<n;i++) totalSum += nums[i];
        
        for(int i=0; i<n;i++) {
            sum += nums[i];
            if(sum > 0) {
                minSum = Math.min(minSum, sum);
                sum = 0;
            }
            minSum = Math.min(minSum, sum);
        }
        
		return minSum < 0 ? totalSum - minSum : totalSum;
	}
	public static void main(String[] args) {
		int[] A = {5,3,5};
		System.out.println(maxSumSubArray(A));

	}

}
