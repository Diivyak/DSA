package com.dynamicprogramming.medium;

public class ClimbingStairs {

	public static int waysToReachTop(int n) {
		if(n <= 2) {
			return n;
		}
		int[] ways = new int[n+1];
		ways[0] = 0; ways[1] = 1; ways[2] = 2;
		for(int i=3; i<=n;i++) {
			ways[i] = ways[i-1] +ways[i-2];
		}
		return ways[n];
	}
	public static void main(String[] args) {
		for(int i=0; i<=5;i++) 
			System.out.println(waysToReachTop(i));

	}

}
