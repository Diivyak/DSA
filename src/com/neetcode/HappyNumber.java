package com.neetcode;

public class HappyNumber {

	public static boolean isHappy(int n) {
        while(n*n > 10) {
            int num = n;
            int ans = 0;
            while(num> 0) {
                int digit = num%10;
                ans += (digit*digit);
                num /= 10;
            }
            n = ans;
        }
        return n == 1? true : false;
        
    }
	public static void main(String[] args) {
		System.out.println(isHappy(4));

	}

}
