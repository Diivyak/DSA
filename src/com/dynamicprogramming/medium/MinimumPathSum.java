package com.dynamicprogramming.medium;

import java.util.Arrays;

public class MinimumPathSum {

	/*
	 * Problem Statement Ninjaland is a country in the shape of a 2-Dimensional grid
	 * 'GRID', with 'N' rows and 'M' columns. Each point in the grid has some cost
	 * associated with it. Find a path from top left i.e. (0, 0) to the bottom right
	 * i.e. ('N' - 1, 'M' - 1) which minimizes the sum of the cost of all the
	 * numbers along the path. You need to tell the minimum sum of that path. Note:
	 * You can only move down or right at any point in time. Input Format : The
	 * first line contains an integer 'T' denoting the number of test cases.
	 * 
	 * The first line of each test case contains two space-separated integers 'N'
	 * and ‘M’ representing the number of rows and number of columns in the grid,
	 * respectively.
	 * 
	 * Next 'N' lines will have 'M' space-separated integers, each line denotes cost
	 * values of that row. Output Format: For each test case, print the minimum sum
	 * of the path from top left to bottom right. Note: You don't need to print
	 * anything, it has already been taken care of. Just implement the given
	 * function. Follow Up: Can you solve this in O(1) space complexity?
	 * Constraints: 1 <= T <= 100 1 <= N, M <= 10^2 1 <= GRID[i][j] <= 10^5
	 * 
	 * Where 'GRID[i][j]' denotes the value of the cell in the matrix.
	 * 
	 * Time limit: 1 sec Sample Input 1: 2 2 3 5 9 6 11 5 2 1 1 5 Sample Output 1:
	 * 21 5
	 */
	public static int getMinPathSum(int[][] grid) {
		int rows = grid.length, cols = grid[0].length;

		int[][] ways = new int[rows][cols];

		for (int i = 0; i < cols; i++)
			ways[0][i] = (i != 0) ? ways[0][i - 1] + grid[0][i] : grid[0][i];

		for (int i = 1; i < rows; i++)
			ways[i][0] = ways[i - 1][0] + grid[i][0];

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				ways[i][j] = grid[i][j] + Math.min(ways[i - 1][j], ways[i][j - 1]);
			}
		}
		return ways[rows - 1][cols - 1];
	}

	public static int getMinPathsumUsingTwoArrays(int[][] grid) {
		int rows = grid.length, cols = grid[0].length;

		int[] prev = new int[cols];
		Arrays.fill(prev, Integer.MAX_VALUE);
		int[] curr = new int[cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == 0 && j == 0) {
					curr[j] = grid[i][j];
					continue;
				}
				curr[j] = (j - 1) >= 0 ? (Math.min(prev[j], curr[j - 1]) + grid[i][j]) : (grid[i][j] + prev[j]);
			}
			prev = curr.clone();
		}

		return prev[cols - 1];
	}

	public static void main(String[] args) {
		int[][] grid = { { 5, 9, 6 }, { 11, 5, 2 } };
		System.out.println(getMinPathSum(grid)+"=="+getMinPathsumUsingTwoArrays(grid));
	}

}
