package com.neetcode;

public class LongestRepeatingCharReplacement {

	public static int longestRepeatingCharReplacement(String str, int k) {
		int l = 0, r= 0, maxFreq = 0, ans = 0;
		int[] charCount = new int[26];
		int n = str.length();
		while(r <n) {
			char ch = str.charAt(r);
			charCount[ch-'A']++;
			maxFreq = Math.max(maxFreq, charCount[ch-'A']);
			while((r-l+1) - maxFreq > k) {
				charCount[ch]--;
				l++;
			}
			ans = Math.max(ans,  r-l+1);
			r++;
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(longestRepeatingCharReplacement("ABAB", 2));

	}

}
