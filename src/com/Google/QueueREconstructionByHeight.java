package com.Google;

import java.util.Arrays;

public class QueueREconstructionByHeight {

	public static int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, (int[] a, int[] b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        return people;
    }
	public static void main(String[] args) {
		int[][] arr = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		arr = reconstructQueue(arr);
		for(int[] val: arr) {
			System.out.println(val[0]+"-"+val[1]);
		}
	}

}
