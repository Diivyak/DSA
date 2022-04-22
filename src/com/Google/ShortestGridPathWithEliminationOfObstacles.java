package com.Google;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestGridPathWithEliminationOfObstacles {

	public static int[][] lives;
    public static int minPathSum;
    public static int[] xDir= {0,1,-1, 0};
    public static int[] yDir= {1,0,0, -1};
    
    public static boolean isValid(int i, int j, int n, int m) {
        if(i >= 0 && i < n && j >= 0 && j < m) return true;
        return false;
    }

    public static int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        lives = new int[n][m];
        for(int i=0; i<n;i++) Arrays.fill(lives[i], -1);
        
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{0,0,k,0});
        
        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int r = arr[0], c = arr[1], l = arr[2], dist = arr[3];
            if(r == n-1 && c == m-1)  return dist;
            
            if(grid[r][c] == 1) l--;
            
            for(int h=0; h<4;h++) {
                int i1 = r + xDir[h];
                int j1 = c + yDir[h];
                if(isValid(i1, j1, n, m) && lives[i1][j1] < l) {
                    q.add(new int[]{i1, j1, l, dist+1});
                    lives[i1][j1] = l;
                }
            }
        }
        return -1;
    }
	public static void main(String[] args) {
		int[][] grid = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
		System.out.println(shortestPath(grid, 1));

	}

}
