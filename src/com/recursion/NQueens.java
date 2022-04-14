package com.recursion;

public class NQueens {

	public static boolean isValidPosition(int i, int j, int i1, int j1) {
		if(i == i1 || j== j1 || (i-j) == (i1-j1) || (i+j) == (i1+j1)) {
			return false;
		}
		return true;
	}
	public static boolean helper(int[][] arr, int n, int row, int[][] positions) {
		if(row == n) {
			for(int k=0; k<arr.length;k++) {
				for(int h=0; h<arr[k].length;h++) {
					System.out.print(arr[k][h] +" ");
				}
				System.out.println();
			}
			return true;
		}
		
		for(int col=0; col<arr[0].length;col++) {
			for(int k=0; k<row;k++) {
				boolean isValid = true;
				if(positions[k][1] == col || positions[k][0] - positions[k][1] == row-col
						|| positions[k][0] + positions[k][1] == row +col) {
					isValid = false;
					break;
				}
				if(isValid) {
					positions[row]= new int[]{row,col};
					if(helper(arr, n, row+1, positions)) {
						return true;
					}
				}
			}
		}
		return false;
		
	}
	public static boolean nQueensPosition(int n) {
		int[][] arr = new int[n][n];
		int count = 0;
		int[][] positions = new int[n][2];
		helper(arr,n,0,positions);
		for(int i=0; i<n;i++) {
			System.out.println(positions[i][0] +" "+positions[i][1]);
		}
		return false;
		
	}
	public static void main(String[] args) {
		System.out.println(nQueensPosition(4));

	}

}
