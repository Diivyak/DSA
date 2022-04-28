package com.neetcode;

public class PermutationInString {

public static boolean validStr(int[] s1CharCount, int[] s2CharCount) {
        
        for(int i=0; i<26;i++) {
            if(s1CharCount[i] != s2CharCount[i]) return false;
        }
        return true;
    }
    public static boolean checkInclusion(String s1, String s2) {
        int[] s1CharCount = new int[26];
        int[] s2CharCount = new int[26];
        
        int n = s1.length();
        int m = s2.length();
        
        for(int i=0; i<n;i++) s1CharCount[s1.charAt(i) - 'a']++;
        
        for(int i=0; i<n;i++) {
            s2CharCount[s2.charAt(i)-'a']++;
        }
        if(validStr(s1CharCount, s2CharCount)) return true;
        
        for(int i=1; i<=m-n;i++) {
            s2CharCount[s2.charAt(i-1) - 'a']--;
            s2CharCount[s2.charAt(n+i-1) - 'a']++;
            
            if(validStr(s1CharCount, s2CharCount)) 
                return true;
        }
        return false;
        
    }
	
	public static void main(String[] args) {
		System.out.println(checkInclusion("adc","dcda"));

	}

}
