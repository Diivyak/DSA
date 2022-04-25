package com.Google;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public static String constructString(int lineCount, int charCount, List<String> line, int spaceCount, int extra, int max,boolean lastLine ) {
//		int rem = (max- charCount);
//		if(line.size() > 2) {
//			spaceCount = rem / (line.size()-1);
//	        extra = rem % (line.size()-1);
//		}else {
//			if(lastLine) extra = rem;
//			else spaceCount = rem;
//		}
//        
//        StringBuilder lineStr = new StringBuilder("");
//        for(int l=0; l<line.size(); l++) {
//            lineStr.append(line.get(l));
//            int k=0;
//            while(k++ < spaceCount && l < line.size()-1) lineStr.append(" ");
//            if(extra > 0) {
//                lineStr.append(" ");
//                extra--;
//            }
//        }
//        while(extra > 0) {
//        	lineStr.append(" ");
//            extra--;
//        }
int rem = (max- charCount);
   
if(!lastLine) {
	if(line.size() > 2) {
		spaceCount = rem / (line.size()-1);
	    extra = rem % (line.size()-1);
	}else {
		if(line.size() < 2)extra = rem;
		if(line.size() == 2)spaceCount = rem;
	}
}else {
	if(line.size() < 2) extra = rem;
    else {
        spaceCount =1;
        extra = (rem - (line.size()-1));
    }
}

	
//		if(lastLine) {
//		    if(line.size() < 2) extra = rem;
//		    else {
//		        spaceCount = line.size()-1;
//		        extra = (rem -spaceCount);
//		    }
//		}else{
//		    if(line.size() >= 2)spaceCount = rem;
//		}
//		if(line.size() > 2) {
//			spaceCount = rem / (line.size()-1);
//	        extra = rem % (line.size()-1);
//		}else {
//            
//			// if(lastLine || line.size() < 2) extra = rem;
//			// else {
//			// if(line.size() >= 2)spaceCount = rem;
//			// }
//		}
        
        StringBuilder lineStr = new StringBuilder("");
        for(int l=0; l<line.size(); l++) {
            lineStr.append(line.get(l));
            int k=0;
//            if(!lastLine)
                while(k++ < spaceCount && l < line.size()-1) lineStr.append(" ");
//            if(lastLine) lineStr.append(" ");
            if(!lastLine && extra > 0) {
                lineStr.append(" ");
                extra--;
            }
        }
        while(extra > 0) {
        	lineStr.append(" ");
            extra--;
        }
        return lineStr.toString();
	}
	public static List<String> fullJustify(String[] words, int maxWidth) {
		
        List<String> output = new ArrayList<String>();
        int spaceCount = 0, lineCount = 0, extra = 0, charCount = 0;
        List<String> line = new ArrayList<String>();
        
        for(String word: words) {
            lineCount += 1;
            if((lineCount + word.length()) <= maxWidth) {
            	line.add(word);
                lineCount += word.length();
                charCount += word.length();
            }else{
            	lineCount -= 1;
            	output.add(constructString(lineCount, charCount, line, spaceCount,extra, maxWidth, false));
                line = new ArrayList<String>();
                spaceCount = 0; extra = 0;
                line.add(word);
                lineCount = word.length();
                charCount = word.length();
            }
        }
        if(lineCount > 0)
        	output.add(constructString(lineCount, charCount, line, spaceCount,extra, maxWidth, true));
        return output;
        
    }
	public static void main(String[] args) {
		String[] words = {"you're","gonna","get."};
//		String[] words = {"Listen","to","many,","speak","to","a","few."};
//		String[] words = {"What","must","be","acknowledgment","shall","be"};
//		String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
		int maxWidth = 20;
		List<String> output = fullJustify(words, maxWidth);
		for(String str: output) System.out.println("'"+str+"'");
	}

}
