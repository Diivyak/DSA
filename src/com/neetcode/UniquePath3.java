package com.neetcode;

public class UniquePath3 {

	public static boolean[][] visited;
    public static boolean isValid(int i, int j, int n, int m) {
        if(i >= n || i < 0 || j>= m || j <0)
            return false;
        return true;
    }
    public static int[] xDir = {-1,0,0,1};
    public static int[] yDir = {0,-1,1,0};
    public static int count;
    public static void dfs(int[][] grid, int i, int j, int n, int m) {
        if(grid[i][j] == 2){
        	boolean allVisited = true;
            for(int l= 0; l<n;l++) {
                for(int h = 0; h<m;h++) {
                    if(grid[l][h] ==0 && !visited[l][h])  {
                        allVisited = false;
                        break;
                    }
                }
            }
            if(allVisited)
                count++;
            return;
        }
        visited[i][j] = true;
        for(int k=0; k<4;k++) {
            int i1 = i+xDir[k];
            int j1 = j+yDir[k];
            System.out.println(i1+"-"+j1);
            if(isValid(i1, j1, n, m) && !visited[i1][j1] && grid[i1][j1] != -1) {
//            	visited[i1][j1] = true;
                dfs(grid, i1, j1, n,m);
//                visited[i1][j1] = false;
            }
        }
        visited[i][j] = false;
    }
    public static int uniquePathsIII(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        visited = new boolean[row][col];
        count = 0;
        for(int i=0; i<row; i++) {
        	for(int j=0; j<col;j++) {
        		if(grid[i][j] == 1) {
        			dfs(grid,i,j,row, col);
        		}
        	}
        }
        
        return count;
    }
	public static void main(String[] args) {
		int[][] arr = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
//		int[][] arr = {{0,1},{2,0}};
		System.out.println(uniquePathsIII(arr));
	}

}
