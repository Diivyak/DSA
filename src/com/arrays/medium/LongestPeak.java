package com.arrays.medium;

public class LongestPeak {

	public static int[] helper(int[] array, int i) {
		int i1= i-1, j1 = i+1, n = array.length;
		while(i1-1 >= 0 && array[i1] > array[i1-1]) {
			i1--;
		}
		while(j1+1<n && array[j1] > array[j1+1]) {
			j1++;
		}
		return new int[]{i1, j1};
	}
  public static int longestPeak(int[] array) {
    int n = array.length, maxLen = Integer.MIN_VALUE;
		
		for(int i=0; i<n;i++) {
			if(i==0 || i == n-1) {
				if(i==0 && array[i] > array[i+1]){
					int[] idxArr = helper(array, i);
					maxLen = Math.max(maxLen, (idxArr[1] - i +1));
				}
				if(i==n-1 && array[i] > array[i-1]){
					int[] idxArr = helper(array, i);
					maxLen = Math.max(maxLen, (i - idxArr[0] +1));
				}
				continue;
			}
			if(array[i] > array[i-1] && array[i] > array[i+1]) {
					int[] idxArr = helper(array, i);
					maxLen = Math.max(maxLen, (idxArr[1] - idxArr[0] +1));
			}
		}
    return maxLen == Integer.MIN_VALUE ? -1 : maxLen;
  }
  
	public static void main(String[] args) {
//		int[] a = {1, -1, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
		int[] a = {1, 2, 3, 4, 5, 1};
		
		System.out.println(longestPeak(a));

	}

}
