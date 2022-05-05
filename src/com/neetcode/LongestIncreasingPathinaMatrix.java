package com.neetcode;

import java.util.Arrays;

public class LongestIncreasingPathinaMatrix {

	public static boolean isValid(int i, int j, int n, int m) {
        if(i< 0|| i>= n || j<0 || j>= m)
            return false;
        return true;
    }
    public static int[] xDir = {-1,0,0,1};
    public static int[] yDir = {0,-1,1,0};

    public static int[][] lcp;
    public static int[][] lcp1;
    public static boolean[][] visited;
    public static void dfs(int i, int j, int n, int m, boolean isGreater, int[][] matrix) {
        
    	visited[i][j]= true;
        for(int k=0; k<4;k++) {
            int i1 = i+ xDir[k];
            int j1 = j+ yDir[k];
            if(isValid(i1, j1, n, m) && !visited[i1][j1]) {
            	
                if(isGreater) {
                	if(matrix[i1][j1] > matrix[i][j])
                		lcp[i][j] = Math.max(lcp[i][j], lcp[i1][j1]+1);
                	
                }else{
                    if(matrix[i1][j1] < matrix[i][j])
                    	lcp[i][j] = Math.max(lcp[i][j], lcp[i1][j1]+1);
                }
                visited[i1][j1]= true;
                dfs(i1,j1, n, m, isGreater, matrix);
                visited[i1][j1]= false;
            }
        }
//        visited[i][j]= false;
    }
    public static int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        visited  = new boolean[row][col];
        lcp = new int[row][col];
        lcp1 = new int[row][col];
        
        for(int i=0; i<row;i++) {
            Arrays.fill(lcp[i], 1);
            Arrays.fill(lcp1[i], 1);
        }
        dfs(0,0, row, col, true, matrix);
        dfs(0,0, row, col, false, matrix);
        
        int len = Integer.MIN_VALUE;
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col;j++) {
                len = Math.max(len, Math.max(lcp[i][j],lcp1[i][j]));
            }
        }

        return len;
    }
	public static void main(String[] args) {
		int[][] arr = {{9,9,4},{6,6,8},{2,1,1}};
//		int[][] arr = {{3,4,5},{3,2,6},{2,2,1}};
//		int[][] arr = {{1,2},{2,3}};
		
		
		System.out.println(longestIncreasingPath(arr));
	}

}
