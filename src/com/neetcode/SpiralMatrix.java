package com.neetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static List<Integer> spiralOrder(int[][] matrix) {
		int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> output = new ArrayList<Integer>();
        
        int left = 0, top = 0, bottom = row-1, right = col-1;
        while(true) {
            
            for(int i=left; i<=right;i++) {
                output.add(matrix[left][i]);
            }
            top++;
            if(top > bottom) break;
            for(int i=top; i<=bottom;i++) {
                output.add(matrix[i][right]);
            }
            right--;
            if(right <left ) break;
            for(int i=right; i>=left;i--) {
                output.add(matrix[bottom][i]);
            }
            bottom--;
            if(bottom< top) break;
            for(int i=bottom; i>= top; i--) {
                output.add(matrix[i][left]);
            }
            left++;
            if(left > right) break;
        }
        return output;
    }
	public static void main(String[] args) {
		
//		[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//				Output: [1,2,3,4,8,12,11,10,9,5,6,7]
						
//		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		List<Integer> output = spiralOrder(matrix);
		for(Integer num : output)
			System.out.print(num +" ");
		
//		1,2,3,6,9,8,7,4,5
		
//		1 2 3
//		4 5 6
//		7 8 9
//		
		

	}

}
