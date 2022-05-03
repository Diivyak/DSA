package com.neetcode;

public class ReverseBits {

	public static String getBinaryFormat(int x) {
		StringBuilder str = new StringBuilder("");
		while (x > 0) {
			int digit = x % 2;
			x /= 2;
			str.append(digit + "");
		}
		return str.toString();
	}

	public static int reverse(int x) {
		int res = 0;
		for (int i = 0; i < 31; i++) {
			res = res<<1;
			int bit = x%2;
			res+= bit;
			x = x>>1;
		}
		return res;
	}

	public static void main(String[] args) {
		int x = 123;
		System.out.println(reverse(x));
	}

}
