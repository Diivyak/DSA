package com.Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindAllRecipes {

	public static List<String> findAllRecipes(String[] recipes, 
		List<String> ingredients, String[] supplies) {


		int n = recipes.length;
		HashSet<String> set = new HashSet<>(Arrays.asList(supplies));
		List<String> output = new ArrayList<String>();

		boolean keepIterating = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		while(keepIterating) {
			Queue<Integer> dupQueue = new LinkedList<Integer>();
			keepIterating = false;
			int i = q.poll();
			while(!q.isEmpty()) {
				int ingrSize = ingredients.size();
				boolean  ready = true;
				for(int j=0; j<ingrSize; j++){
					if(!set.contains(ingredients.get(j))) {
						ready = false;
						break;	
					}
				}
				
				if(ready) {
					output.add(recipes[i]);
					set.add(recipes[i]);
					keepIterating = true;
	
				}else{
					dupQueue.add(i);
				}
	
			}
			q = dupQueue;
		}

		return output;

			
	}

	public static void main(String[] args) {
		String[] recipes = {};
		String[] recipes = {};
		String[] recipes = {};

	}

}
