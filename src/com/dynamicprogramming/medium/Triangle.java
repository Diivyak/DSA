package com.dynamicprogramming.medium;

import java.util.Arrays;

public class Triangle {

	public static int getMinPathSum(int[][] triangle) {
		int n = triangle.length;
		int m = triangle[n-1].length;
		int M = Integer.MAX_VALUE;
		int[] prev = new int[m];
		Arrays.fill(prev, M);
		int[] curr = new int[m];
	
		
		for (int i = 0; i < n; i++) {
			int len = i + 1;
			for (int j = 0; j < len; j++) {

				
				int left = j==0 ? M : prev[j - 1];
				int middle = j==len-1 ? M :  prev[j];
				int right = j>=len-2 ? M: prev[j+1];	
				
				int val = Math.min(left,  Math.min(middle, right));
				curr[j] = triangle[i][j] + (val == M ? 0 : val ) ;
				System.out.print(curr[j] +" ");
			}
			System.out.println();
			
			prev = curr.clone();
		}
		
		int minVal = M;
		for (int i = 0; i < m; i++) {
			minVal = Math.min(minVal, curr[i]);
		}
		return minVal;

	}

	public static void main(String[] args) {
//		-2
//		-52 -81
//		-75 67 15
//		-51 -75 13 -57
//		64 11 -9 -79 -18
//		-77 86 -30 -24 -41 -43
//		54 -89 -22 -34 26 -58 33
//		-16
//		-15 24
//		1 35 61
//		-68 -25 48 -87
//		0 52 -20 80 -15
//		int[][] A= {{1},{2,3},{4,5,6},{7,8,9,10}};
//		int[][] A= {{-16},{-15,24},{1,35,61},{-68,-25,48,-87},{0,52,-20,80,-15}};
		int[][] A = {{-2},{-52,-81},{-75,67,15},{-51,-75,13,-57},{64 ,11 ,-9, -79, -18},{-77, 86, -30 ,-24, -41, -43},
				{54, -89, -22, -34, 26, -58, 33}};
		System.out.println(getMinPathSum(A));

	}

}
