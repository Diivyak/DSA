package com.neetcode;

public class ValidPalindrome {

	public static boolean isPalindrome(String s) {
		int n = s.length();
        s= s.toLowerCase();
        int i=0, j = n-1;
        while(i < j) {
            char start = s.charAt(i);
            char end = s.charAt(j);
            if((start < 'a' || start > 'z') && (start < '0' || start > '9')){
                i++;
                continue;
            }
            if((end < 'a' || end > 'z') && (end < '0' || end > '9')){
                j--;
                continue;
            }
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
	public static void main(String[] args) {
//		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//		System.out.println(isPalindrome("race a car"));
		System.out.println(isPalindrome(".,"));
		System.out.println(isPalindrome("0P"));
		

	}

}
