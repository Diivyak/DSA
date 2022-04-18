package com.dynamicprogramming.medium;

import java.util.Arrays;

public class MazeObstacles {

	/*
	 * Problem Statement Given a ‘N’ * ’M’ maze with obstacles, count and return the
	 * number of paths to reach the right-bottom cell from the top-left cell. A cell
	 * in the given maze has a value -1 if it is a blockage or dead-end, else 0.
	 * From a given cell, we are allowed to move to cells (i+1, j) and (i, j+1)
	 * only. Since the answer can be large, print it modulo 10^9 + 7. For Example :
	 * Consider the maze below : 0 0 0 0 -1 0 0 0 0
	 * 
	 * There are two ways to reach the bottom left corner -
	 * 
	 * (1, 1) -> (1, 2) -> (1, 3) -> (2, 3) -> (3, 3) (1, 1) -> (2, 1) -> (3, 1) ->
	 * (3, 2) -> (3, 3)
	 * 
	 * Hence the answer for the above test case is 2. Input Format : The first line
	 * contains a single integer ‘T’ denoting the number of test cases. Then each
	 * test case follows.
	 * 
	 * The first line of each test case contains integers ‘N’ and ‘M’ representing
	 * the size of the input grid.
	 * 
	 * Then ‘N’ lines follow, each of which contains ‘M’ space-separated integers
	 * denoting the elements of the matrix. Output Format : For each test case print
	 * an integer denoting the number of ways to reach the bottom right corner from
	 * the top-left corner modulo 10^9 + 7.
	 * 
	 * Output for each test case will be printed in a separate line. Note : You are
	 * not required to print anything; it has already been taken care of. Just
	 * implement the function. Constraints : T = 1to10 N,M = 1 to 200 (Inclusive)
	 * 
	 * Time Limit: 1 sec Sample Input 1 : 2
	 * 
	 * 2 2 0 0 0 0
	 * 
	 * 3 3 0 0 0 0 -1 0 0 0 0 Sample Output 1 : 2 2
	 */
	public static int getWays(int[][] grid) {
		int n = grid.length, m = grid[0].length;
		int[][] ways = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i - 1 >= 0 && j - 1 >= 0)
					ways[i][j] = grid[i][j] != -1 ? ways[i - 1][j] + ways[i][j - 1] : 0;
				else if (i - 1 < 0 && j - 1 >= 0)
					ways[i][j] = grid[i][j] != -1 ? ways[i][j - 1] : 0;
				else if (i - 1 >= 0 && j - 1 < 0)
					ways[i][j] = grid[i][j] != -1 ? ways[i - 1][j] : 0;
				else
					ways[i][j] = 1;
			}
		}
		return ways[n - 1][m - 1];
	}

	public static int getWaysUsingTwoArrays(int[][] grid) {
		int n = grid.length, m = grid[0].length;
		int[] prev = new int[m];
		int[] curr = new int[m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] != -1) {
					if (i == 0 && j == 0) {
						curr[j] = 1;
						continue;
					}
					curr[j] = j - 1 >= 0 ? curr[j - 1] + prev[j] : prev[j];
				}
			}
			prev = curr.clone();
			Arrays.fill(curr, 0);
		}
		return prev[m - 1];

	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, -1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		System.out.println(getWays(grid) + " == " + getWaysUsingTwoArrays(grid));

	}

}
