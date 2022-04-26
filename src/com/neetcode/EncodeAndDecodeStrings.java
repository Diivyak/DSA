package com.neetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class EncodeAndDecodeStrings {

	public static HashMap<Integer, String> secretWordMap;
	public static int selectedRandom;
	public static String encode(List<String> list) {
		Random random = new Random();
		selectedRandom = random.nextInt(7);
		String delimiter = secretWordMap.get(selectedRandom);
		
		StringBuilder sb = new StringBuilder("");
		for(int i=0; i<list.size();i++) {
			sb.append(list.get(i));
			if(i< list.size()-1) sb.append(delimiter);
		}
		return sb.toString();
	}
	public static List<String> decode(String s) {
		String[] strArr = s.split(secretWordMap.get(selectedRandom));
		List<String> output = new ArrayList<String>();
		for(String val: strArr) output.add(val);
		return output;
	}
	public static void main(String[] args) {
		secretWordMap = new HashMap<Integer, String>();
//		for(int i=0; i<=10;i++) {
		secretWordMap.put(0, ":#");
		secretWordMap.put(1, ":#$");
		secretWordMap.put(2, ":#@");
		secretWordMap.put(3, ":*;#");
		secretWordMap.put(4, ":##");
		secretWordMap.put(5, ":'#");
		secretWordMap.put(6, ":;#");
		secretWordMap.put(7, ":%#");
//		}
		List<String> list = new ArrayList<String>();
		String[] s = {"lint","code","love","you"};
		for(String s1 : s) list.add(s1);
		String str = encode(list);
		list = decode(str);

		for(String val: list) System.out.print(val+" ");
	}

}
