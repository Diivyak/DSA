package com.dynamicprogramming.easy;

public class CoinExchange {
	
	public static int minCoins(int[] arr, int sum, int i, int count) {
		if(sum ==0) {
			return count;
		}
		if(i>= arr.length || sum < arr[i]) {
			return Integer.MAX_VALUE;
		}
		
		return Math.min(minCoins(arr, sum-arr[i], i,count+1), minCoins(arr, sum, i+1, count));
		
	}
	public static void main(String[] args) {
		int[] A = {1,2,3};
		System.out.println(minCoins(A, 5, 0,0));

	}

}
