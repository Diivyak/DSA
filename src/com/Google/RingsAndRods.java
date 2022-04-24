package com.Google;

public class RingsAndRods {

	public static int countPoints(String rings) {
        int[][] rods = new int[10][3];
	
        int n = rings.length();
        for(int i=0; i+1<n;i = i+2) {
            int clr = (rings.charAt(i) == 'B' ? 0 : (rings.charAt(i) == 'R' ? 1 : 2));
            int rod = rings.charAt(i+1)-'0';
            rods[rod][clr]++;
        }
        int rodsWithAllColors = 0;
        for(int i=0; i<10;i++) {
            int clrCount = 0;
            for(int j=0; j<3;j++) clrCount += rods[i][j] >= 1? 1 : 0;
            if(clrCount == 3) rodsWithAllColors++;
        }

	    return rodsWithAllColors;
        
    }
	public static void main(String[] args) {
		System.out.println(countPoints("B0B6G0R6R0R6G9"));

	}

}
