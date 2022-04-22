package com.Google;

public class RemoveAllOnesWithRowAndColumnFilps {

	public static boolean removeOnes(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        
        for(int i=1; i<row; i++) {
            int count = 0;
            for(int j=1; j<col; j++) {
                count += grid[i-1][j-1] + grid[i-1][j] + grid[i][j-1] + grid[i][j];
                if(count == 1) return false;
                count=0;
            }
            
        }
        return true;
    }
	public static void main(String[] args) {
//		[[1,1,0],[0,0,0],[0,0,0]]
//		int[][] A= {{1,1,0},{0,0,0},{0,0,0}};
		int[][] A= {{0,1,0},{1,0,1},{0,1,0}};
		
		System.out.println(removeOnes(A));
		

	}

}
