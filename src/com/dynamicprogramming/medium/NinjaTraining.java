package com.dynamicprogramming.medium;

public class NinjaTraining {

	/*
	 * Problem Statement :
	 * 
	 * Ninja is planing this ‘N’ days-long training schedule. Each
	 * day, he can perform any one of these three activities. (Running, Fighting
	 * Practice or Learning New Moves). Each activity has some merit points on each
	 * day. As Ninja has to improve all his skills, he can’t do the same activity in
	 * two consecutive days. Can you help Ninja find out the maximum merit points
	 * Ninja can earn? You are given a 2D array of size N*3 ‘POINTS’ with the points
	 * corresponding to each day and activity. Your task is to calculate the maximum
	 * number of merit points that Ninja can earn. For Example If the given ‘POINTS’
	 * array is [[1,2,5], [3 ,1 ,1] ,[3,3,3] ],the answer will be 11 as 5 + 3 + 3.
	 * Input Format: The first line of the input contains an integer, 'T,’ denoting
	 * the number of test cases.
	 * 
	 * The first line of each test case contains a single integer,' N’, denoting the
	 * number of days.
	 * 
	 * The next ‘N’ lines of each test case have 3 integers corresponding to
	 * POINTS[i]. Output Format: For each test case, return an integer corresponding
	 * to the maximum coins Ninja can collect. Note: You do not need to print
	 * anything. It has already been taken care of. Just implement the given
	 * function. Constraints: 1 <= T <= 10 1 <= N <= 100000. 1 <= values of POINTS
	 * arrays <= 100 .
	 * 
	 * Time limit: 1 sec Sample Input 1: 2 3 1 2 5 3 1 1 3 3 3 3 10 40 70 20 50 80
	 * 30 60 90
	 */
	public static int ninjaTraining(int n, int points[][]) {
		int[][] prev = new int[n][4];
		
		prev[0][0] = Math.max(points[0][1], points[0][2]);
		prev[0][1] = Math.max(points[0][0], points[0][2]);
		prev[0][2] = Math.max(points[0][1], points[0][0]);
		prev[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
		
		for(int i=1; i<n;i++) {
			for(int j=0; j<4;j++) {
				prev[i][j] = 0;
				for(int k=0;k<3;k++){
					if(j != k)
						prev[i][j] = Math.max(prev[i][j], prev[i-1][k] + points[i][k]);
				}
				
			}
		}
		return prev[n-1][3];
    }
	public static void main(String[] args) {
//		3
//		1 2 5 
//		3 1 1
//		3 3 3
//		4
//		3
//		1 2 5 
//		3 1 1
//		3 3 3
//		3
//		10 40 70
//		20 50 80
//		30 60 90
//		3
//		18 11 19
//		4 13 7
//		1 8 13
//		2
//		10 50 1
//		5 100 11
//		int[][] points = {{1,2,5},{3,1,1},{3,3,3}};
//		int[][] points = {{10,40,70},{20,50,80},{30,60,90}};
//		int[][] points = {{10,40,70},{20,50,80},{30,60,90}};
		int[][] points = {{10,50,1},{5,100,11}};
		System.out.println(ninjaTraining(2, points));

	}

}
