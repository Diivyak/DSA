package com.dynamicprogramming.medium;

public class NinjaTraining {

	public static int ninjaTraining(int n, int points[][]) {
		int[][] prev = new int[n][4];
		
		prev[0][0] = Math.max(points[0][1], points[0][2]);
		prev[0][1] = Math.max(points[0][0], points[0][2]);
		prev[0][2] = Math.max(points[0][1], points[0][0]);
		prev[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
		
		for(int i=1; i<n;i++) {
			for(int j=0; j<4;j++) {
				prev[i][j] = 0;
				for(int k=0;k<3;k++){
					if(j != k)
						prev[i][j] = Math.max(prev[i][j], prev[i-1][k] + points[i][k]);
				}
				
			}
		}
		return prev[n-1][3];
    }
	public static void main(String[] args) {
//		3
//		1 2 5 
//		3 1 1
//		3 3 3
//		4
//		3
//		1 2 5 
//		3 1 1
//		3 3 3
//		3
//		10 40 70
//		20 50 80
//		30 60 90
//		3
//		18 11 19
//		4 13 7
//		1 8 13
//		2
//		10 50 1
//		5 100 11
//		int[][] points = {{1,2,5},{3,1,1},{3,3,3}};
//		int[][] points = {{10,40,70},{20,50,80},{30,60,90}};
//		int[][] points = {{10,40,70},{20,50,80},{30,60,90}};
		int[][] points = {{10,50,1},{5,100,11}};
		System.out.println(ninjaTraining(2, points));

	}

}
