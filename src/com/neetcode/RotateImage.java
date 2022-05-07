package com.neetcode;

public class RotateImage {

	public static void rotate(int[][] matrix) {
        int size = matrix.length;
        
        for(int i=0; i<size;i++) {
            for(int j=i; j<size;j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for(int i=0; i<size;i++) {
            for(int j=0; j<size/2;j++) {
                int tmp = matrix[i][size-1-j];
                matrix[i][size-1-j] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        return;
        
    }
	public static void main(String[] args) {
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		rotate(arr);
	}

}
