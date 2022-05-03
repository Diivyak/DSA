package com.neetcode;

public class ReverseInteger {


	public static int reverse(int x) {
	        int min = Integer.MIN_VALUE;
	        int max = Integer.MAX_VALUE;
	        int checkMax = max%10;
	        int checkMin = min%10;
	        int res = 0;
	        while(x > 0) {
	        	int digit = x%10;
	        	if((res > max/10)  && (res == max/10 && digit >= checkMax)) return 0;
	        	if((res <min/10) && (res == min/10 && digit <= checkMin)) return 0;
	        	res= res*10 +digit;
	        	x = x/10;
	        }
	        return res;
    }
	
	public static void main(String[] args) {
		int x = 901000;
		System.out.println(reverse(x));

	}

}
