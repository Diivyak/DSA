package com.Google;

public class NumberOfMatchingSubSequence {

	public static boolean isSubSeq(String s, String word) {
        int n = s.length(), m = word.length();
        int[][] dp = new int[n+1][m+1];
//        dp[0][0] = 1;
        for(int i=1; i<=n;i++) {
            for(int j=1; j<=m;j++) {
                if(s.charAt(i-1) == word.charAt(j-1)) dp[i][j] = 1+ dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][m] == m ? true :false;
    }
    public static int numMatchingSubseq(String s, String[] words) {
        
        int subSeqCount = 0;
        HashM
        for(String word: words) {
            if(isSubSeq(s, word)) {
                subSeqCount++;
            }
        }
        return subSeqCount;
        
    }
    
	public static void main(String[] args) {
		String[] words = {"a","bb","acd","ace"};
		String str = "abcde";
		System.out.println(numMatchingSubseq(str, words));

	}

}
