package com.dynamicprogramming.medium;

public class MaximumSumOfNonAdjacentElements {

	public static int getMaxNonAdjEleSum(int[] arr) {
		int n = arr.length;
		int[] maxSumArr = new int[n];
		maxSumArr[0] = arr[0];
		for(int i=1; i<n;i++) {
			if(i == 1) {
				maxSumArr[i] = Math.max(maxSumArr[i-1], arr[i]);
				continue;
			}
			maxSumArr[i] = Math.max(maxSumArr[i-1], maxSumArr[i-2] +arr[i]);
		}
		return maxSumArr[n-1];
		
	}
	public static void main(String[] args) {
		// 
//		2
//		3
//		1 2 4
//		4
//		2 1 4 9
//		int[] arr = new int[]{10,20,30,60,80,1};
//		int[] arr = new int[]{1,2,4};
		int[] arr = new int[]{2,1,4,9};
		System.out.println(getMaxNonAdjEleSum(arr));
		

	}

}
