package com.Google;

import java.util.HashMap;

public class DesignExcelFormula {

	public static int[][] matrix;
    public static HashMap<String, String[]> map;
    public DesignExcelFormula(int height, char width) {
        matrix = new int[height][width- 'A'+1];
        map = new HashMap<String, String[]>();
    }
    
    public void set(int row, char column, int val) {
        matrix[row-1][(column-'A')] = val;
    }
    
    public int get(int row, char column) {
        String key = (row-1) + ";"+column;
        if(map.containsKey(key)) {
            
            matrix[row-1][column-'A'] = getSumVal(row, column, map.get(key));
            return matrix[row-1][column-'A'];
        }
        return matrix[row-1][column - 'A'];
    }
    
    public int sum(int row, char column, String[] numbers) {
        map.put((row-1)+";"+column, numbers);
        matrix[row-1][column-'A'] = getSumVal(row, column, numbers);
        return matrix[row-1][column-'A'];
    }
    public static int getSumVal(int row, char column, String[] numbers) {
        int sum = 0;
        for(String format: numbers) {
            if(format.indexOf(":")< 0) {
                int row1 = Integer.parseInt(format.substring(1));
                int col1 = format.charAt(0) - 'A';
                sum += matrix[row1-1][col1];
            }else{
                String[] strArr = format.split(":");
                int row1 = Integer.parseInt(strArr[0].substring(1));
                int col1 = strArr[0].charAt(0) - 'A';
                int row2 = Integer.parseInt(strArr[1].substring(1));
                int col2 = strArr[1].charAt(0)- 'A';
                for(int i=row1-1; i<row2; i++) {
                    for(int j=col1; j<=col2 ;j++){
                        sum += matrix[i][j];
                    }
                }
            }
           
        }
        return sum;
    }
	public static void main(String[] args) {
		String[] instr = {"Excel","sum","set","sum","get"};
//				int[][] input = {{3,"C"},{1,"A",{"A2"}},[2,"A",1],[3,"A",["A1"]],[1,"A"]]

	}

}
