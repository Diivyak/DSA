package com.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {

	public static List<Integer> spiralTraverse(int[][] array) {
		List<Integer> output = new ArrayList<Integer>();
		int left = 0, top = 0, right = array[0].length-1, bottom = array.length-1;
		int count = 0 , totalEle = (array[0].length * array.length);
		while(count <totalEle) {
			for(int i=left; i<= right&& count <totalEle; i++) {
				output.add(array[top][i]);
				count++;
			}
			top++;
			for(int i=top; i<=bottom && count <totalEle;i++) {
				output.add(array[i][right]);
				count++;
			}
			right--;
			for(int i=right; i>=left && count <totalEle;i--) {
				output.add(array[bottom][i]);
				count++;
			}
			bottom--;
			for(int i=bottom; i>=top && count <totalEle; i--){
				output.add(array[i][left]);
				count++;
			}
			left++;
		}
		return output;
	}
	
	public static void main(String[] args) {
//		int[][] A ={{4, 2, 3, 6, 7, 8, 1, 9, 5, 10},
//					{12, 19, 15, 16, 20, 18, 13, 17, 11, 14}};
		int[][] A = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}};
//		int[][] A = {{1, 2, 3, 4},
//			    {12, 13, 14, 5},
//			    {11, 16, 15, 6},
//			    {10, 9, 8, 7}};
//		int[][] A = {{1}};
		List<Integer> output = spiralTraverse(A);
		for(Integer ele: output) {
			System.out.print(ele +" ");
		}
	}

}
