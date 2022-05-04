package com.neetcode;


public class UniquePath2 {

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        
        int[][] uniquePath = new int[row][col];
        uniquePath[0][0] = obstacleGrid[0][0] != 1 ? 1 : 0;
        for(int i=1; i<row;i++) 
            uniquePath[i][0] = obstacleGrid[i][0] != 1 ? obstacleGrid[i-1][0] : 0;
        
        for(int i=1; i<col;i++) 
            uniquePath[0][i] = obstacleGrid[0][i] != 1 ? obstacleGrid[0][i-1] : 0;
        
        for(int i=1; i<row;i++) {
            for(int j=1; j<col;j++) {
                if(obstacleGrid[i][j] != 1){
                    int path = obstacleGrid[i-1][j] != 1 ? uniquePath[i-1][j] : 0;
                    path += obstacleGrid[i][j-1] != 1 ? uniquePath[i][j-1] : 0;
                    uniquePath[i][j] = path;
                }
            }
        }
        return uniquePath[row-1][col-1];
    }
	
	public static void main(String[] args) {
		int[][] grid = {{1,0}};
		System.out.println(uniquePathsWithObstacles(grid));
	}

}
