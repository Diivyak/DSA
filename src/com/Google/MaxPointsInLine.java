package com.Google;

import java.util.HashMap;

public class MaxPointsInLine {

	public static int maxPoints(int[][] points) {
        int n = points.length;
        int max = 0;
        for(int i=0; i<n;i++) {
            int x = points[i][0];
            int y = points[i][1];
            
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int localMax = 1;
            int duplicates=0;
            for(int j=i+1; j<n;j++) {
                if(points[j][0] == x && points[j][1] == y) { duplicates++; continue;}
                
                double slope = getSlope(x, y, points[j][0], points[j][1]);
                map.put(slope, map.getOrDefault(slope, 1)+1);
                localMax = Math.max(localMax, map.get(slope));
                
            }
            max = Math.max(max, localMax + duplicates);
        }
        return max;
    }
    public static double getSlope(int x, int y, int x1, int y1) {
        if(x == x1) return Double.MAX_VALUE;
        if(y== y1) return 0;
        
        return (1.0*(y1-y))/(x1-x);
    }
	public static void main(String[] args) {
		int[][] points = {{1,1},{2,2},{3,3}};
		System.out.println(maxPoints(points));
	}

}
