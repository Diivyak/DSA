package com.neetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class CarFleet {

public static int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        Double[][] targetList = new Double[n][2];
//        for(int i=0; i<n;i++)
//            targetList[i] = (1.0*(target - position[i]))/speed[i];
        Arrays.sort(targetList, (a, b)-> b[0] - a[0]);
//        Arrays.sort(targetList, (double[] a, double[] b)-> b[0] - a[0]);
//        Arrays.sort(targetList, (double[] a, int[] b)->{
//        Arrays.sort(targetList, new sort(double a, double n));
//        Arrays.sort(targetList, (double[] a, double[] b)->{
//            if(a[0] == b[0]) return a[1] - b[1];
//            return b[0] - a[0];
//        });
        Stack<Double> stack = new Stack<Double>();
        for(int i=0; i<n;i++) {
            if(stack.isEmpty() || (!stack.isEmpty() && stack.peek() < targetList[i])) 
                stack.add(targetList[i]);	
            
        }
        return stack.size();		
    }
	public static void main(String[] args) {
		int[] position = {10,8,0,5,3};
		int[] speed = {2,4,1,1,3};
		System.out.println(carFleet(12, position, speed));

	}

}
