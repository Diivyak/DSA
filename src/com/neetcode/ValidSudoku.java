package com.neetcode;

public class ValidSudoku {

	public static boolean isValidSudoku(char[][] board) {
        int[] arr;
        
        for(int i=0; i<9;i++) {
            arr = new int[10];
            for(int j=0; j<9;j++) {
            	if(board[i][j] != '.') {
            		
	                if(arr[board[i][j] -'0'] == 1) return false;
	                arr[board[i][j] -'0']++;
            	}
            }
        }
        
        for(int i=0; i<9;i++) {
            arr = new int[10];
            for(int j=0; j<9;j++) {
            	if(board[j][i] != '.') {
	                if(arr[board[j][i] -'0'] == 1) return false;
	                arr[board[j][i] -'0']++;
            	}
            }
        }
        
        for(int k=0; k<9;k = k+3) {
            for(int h= 0; h<9;h= h+3) {
                arr = new int[10];
                for(int i=k;i<k+3; i++) {
                    for(int j=h; j<h+3;j++) {
                    	if(board[i][j] != '.') {
	                        if(arr[board[i][j] -'0'] == 1) return false;
	                        arr[board[i][j] -'0']++;
                    	}
                    }
                }
            }
        }
        return true;
    }

	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
			 {'6','.','.','1','9','5','.','.','.'},
			 {'.','9','8','.','.','.','.','6','.'},
			 {'8','.','.','.','6','.','.','.','3'},
			 {'4','.','.','8','.','3','.','.','1'},
			 {'7','.','.','.','2','.','.','.','6'},
			 {'.','6','.','.','.','.','2','8','.'},
			 {'.','.','.','4','1','9','.','.','5'},
			 {'.','.','.','.','8','.','.','7','9'}};
		System.out.println(isValidSudoku(board));
	}

}
