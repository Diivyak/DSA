package com.Google;

import java.util.Arrays;

public class SentenceScreenFitting {

public static int wordsTyping(String[] sentence, int rows, int cols) {
        
        char[][] grid = new char[rows][cols];
        
        for(int i=0; i<rows; i++) {
            Arrays.fill(grid[i], ' ');
        }
        
        int k=0, count = 1;
        for(int i=0; i<rows; i++) {
            if(k == sentence.length) {
                count++;
                k=0;
            }
            String str = sentence[k];
            int idx = 0;
            for(int j=0; j<cols; j++) {
                
                    grid[i][j] = str.charAt(idx);
                    idx++;
                    if(idx == str.length()) {
                        j++;
                        k++;
                        if(k == sentence.length) {
                            count++;
                            k=0;
                        }
                        str = sentence[k];
                        if(cols-j <= str.length()) {
                        	break;
                        }
                        idx = 0;
                    }
                
            }
        }
        return count;
    }
	public static void main(String[] args) {
		String[] sentence = {"a", "bcd", "e"};
		int rows =3, cols =6;
		
		System.out.println(wordsTyping(sentence, rows, cols));
	}

}
