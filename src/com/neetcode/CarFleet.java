package com.neetcode;

import java.util.ArrayList;
import java.util.Collections;

public class CarFleet {

	public static int carFleet(int target, int[] position, int[] speed) {
		int n = position.length;
		ArrayList<int[]> list = new ArrayList<int[]>();
		
		for(int i=0; i<n;i++) {
			list.add(new int[] {position[i], speed[i]});
		}
		Collections.sort(list, (int[] a, int[] b)-> b[0] - a[0]);
		
        double sLowestTime = 0;
        int count =0;
		for(int i=0; i<n;i++) {
			double time = 1.0*(target- list.get(i)[0])/list.get(i)[1];
			if(time > sLowestTime) {
                count++;
            }
            sLowestTime = Math.max(sLowestTime, time);
		}
		return count;
    }
	public static void main(String[] args) {
//		int[] position = {10,8,0,5,3};
//		int[] speed = {2,4,1,1,3};
//		12
		int[] position = {6,8};
		int[] speed = {3,2};
//		10
//		[6,8]
//		[3,2]
		System.out.println(carFleet(10, position, speed));

	}

}
