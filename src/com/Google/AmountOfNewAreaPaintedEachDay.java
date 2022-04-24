package com.Google;

import java.util.HashMap;

public class AmountOfNewAreaPaintedEachDay {

	public static int[] amountPainted(int[][] paint) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int n = paint.length;
        int[] output = new int[n];
        
        int min= Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0; i<n;i++) {
            min = Math.min(min,paint[i][0]);
            max = Math.max(max, paint[i][1]);
        }
        
        for(int i=min; i<max;i++) {
            map.put(i, false);
        }
        for(int i=0; i<n;i++) {
            int start = paint[i][0], count  =0;
            while(start < paint[i][1]) {
                if(!map.get(start)) {
                    count++;
                    map.put(start, true);
                }
                start++;
            }
            output[i] = count;
        }
        return output;
    }
	public static void main(String[] args) {
//		[[1,4],[4,7],[5,8]]
//		[[1,5],[2,4]]
//		int[][] A = {{1,4},{5,8},{4,7}};
		int[][] A = {{1,5},{2,4}};
		int[] output = amountPainted(A);
		for(int area: output) System.out.print(area+ " ");

	}

}
