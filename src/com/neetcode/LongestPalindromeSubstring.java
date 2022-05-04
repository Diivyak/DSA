package com.neetcode;

public class LongestPalindromeSubstring {

	public static boolean[][] palindromeCheck;
    public static int  isPalindrome(String s) {
    	int count =0;
        int n = s.length();
        boolean[][] palindromeCheck = new boolean[n][n];

        
        for(int i=0; i<n;i++) {
            palindromeCheck[i][i]= true;
            count++;
        }
        for(int i=0;i+1<n;i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                palindromeCheck[i][i+1] = true;
                count++;
            }
        }
       
        for(int i = n-3; i>= 0; i--) {
            for(int j=n-1; j>= 1;j--) {
                if( i != j && j-i >= 2 && s.charAt(i) == s.charAt(j)) {
                    palindromeCheck[i][j] = palindromeCheck[i+1][j-1];
                    if(palindromeCheck[i][j])
                        count++;
                }
            }
        }
        return count;
        
    }
    public static String longestPalindrome(String s) {
        int n = s.length();
        String ans = ""+s.charAt(0);
        int len = 1;
        int count = isPalindrome(s);
        System.out.println(count);
        for(int i=1; i<=n;i++) {
            for(int j=i+1; j<=n;j++) {
                if(palindromeCheck[i][j]) {
                    if(len < (j-i+1)) {
                        len = j-i+1;
                        ans = s.substring(i-1, j);
                    }
                }
            }
        }
        return ans;
    }
    
//    [[true, false, false, false, false, false, false, false, false],
//     [false, true, false, true, true, true, false, false, false], 
//     [false, false, true, false, false, false, false, false, false], 
//     [false, false, false, true, false, true, true, true, false],
//     [false, false, false, false, true, true, true, true, true],
//     [false, false, false, false, false, true, false, false, false],
//     [false, false, false, false, false, false, true, false, true],
//     [false, false, false, false, false, false, false, true, false], 
//     [false, false, false, false, false, false, false, false, true]]
    		
    
	public static void main(String[] args) {
		System.out.println(longestPalindrome("aaaaa"));

	}

}
