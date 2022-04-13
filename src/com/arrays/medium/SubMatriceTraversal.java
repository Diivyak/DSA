package com.arrays.medium;

public class SubMatriceTraversal {

	public static void printSubMatrice(int[][] arr) {
		int n = arr.length, m = arr[0].length;
		for(int i=1; i<n;i++) {
			for(int j=1;j<m;j++) {
				System.out.println(arr[i-1][j-1] +" "+arr[i-1][j] +" "+arr[i][j-1] +" "+arr[i][j]);
			}
		}
		return;
	}
	public static void main(String[] args) {
		int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
		printSubMatrice(A);

	}

}
