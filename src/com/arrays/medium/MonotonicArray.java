package com.arrays.medium;

public class MonotonicArray {

	public static boolean isMonotonic(int[] array) {
	    boolean dec = false, inc = false;
			int n = array.length;
			for(int i=0; i+1<n;i++) {
					if(array[i] < array[i+1]) {
								if(dec) return false;
								inc = true;
					}else if(array[i] > array[i+1]){
							if(inc) return false;
							dec = true;
					}
			}
	    return true;
	  }
	public static boolean isMonotonic1(int[] array) {
	    boolean dec = true, inc = true;
			int n = array.length;
			for(int i=0; i+1<n;i++) {
					if(array[i] < array[i+1]) {
						dec = false;
					}
			}
			for(int i=0; i+1<n;i++) {
				if(array[i] > array[i+1]){
					inc = false;
				}
		}
	    return inc || dec;
	  }
	public static void main(String[] args) {
		System.out.println(isMonotonic(new int[] {-1, -5, -10, -1100, -1100, -1101, -1102, -9001}));
		System.out.println(isMonotonic(new int[] {-1, -5, 10})); 
		System.out.println(isMonotonic1(new int[] {-1, -5, -10, -1100, -1100, -1101, -1102, -9001}));
		System.out.println(isMonotonic1(new int[] {-1, -5, 10})); 

	}

}
