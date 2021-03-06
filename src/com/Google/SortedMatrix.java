package com.Google;

public class SortedMatrix {

	public static int[] searchInSortedMatrix(int[][] matrix, int target) {
	    int row = matrix.length, col = matrix[0].length;
			
			int i=0,j = col-1;
			
			while(i<row && j >= 0) {
				if(matrix[i][j] < target) i++;
				else if(matrix[i][j] > target) j--;
				else return new int[] {i,j};
			
			}
			
	    return new int[] {-1, -1};
	  }
	public static void main(String[] args) {
		int[][] matrix = {{1, 4, 7, 12, 15, 1000},{2, 5, 19, 31, 32, 1001},{3, 8, 24, 33, 35, 1002},{40, 41, 42, 44, 45, 1003},{99, 100, 103, 106, 128, 1004}};
		int[] output = searchInSortedMatrix(matrix, 44);
		System.out.println(output[0] +" = "+output[1]);
	}

}
