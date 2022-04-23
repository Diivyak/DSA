package com.Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GuessWord {
//	public static String secret = "ccoyyo";
	public static String secret = "acckzz";

	public static class Master {

		public Master() {

		}

		public int guess(String word) {
			int count = 0;
			for (int i = 0; i < 6; i++)
				if (word.charAt(i) == secret.charAt(i))
					count++;
			return count;

		}

	}

	public static int matchCount(String word, String wordFromList) {
		int count = 0;
		for (int i = 0; i < 6; i++)
			if (word.charAt(i) == wordFromList.charAt(i))
				count++;
		return count;
	}

	public static ArrayList<String> removeWords(ArrayList<String> set, int secretMatchCount, String word) {
		ArrayList<String> newWordList = new ArrayList<String>();

		for (String str : set) {
			int count = matchCount(word, str);
			if(count == 6) continue;
			if (count == secretMatchCount)
				newWordList.add(str);
		}
		set = newWordList;
		return set;
	}

	public static void findSecretWord(String[] wordList) {
		Master master = new Master();
		ArrayList<String> wordSet = new ArrayList<String>(Arrays.asList(wordList));

		int guessCount = 0;
		while (wordSet.size() > 0 && guessCount <= 10) {
			guessCount++;
			Random r = new Random();
			int random = r.nextInt(wordSet.size());
			int secretMatchCount = master.guess(wordSet.get(random));
			if (secretMatchCount == 6) {
				System.out.println("guess="+guessCount);
				return;
			}
			wordSet = removeWords(wordSet, secretMatchCount, wordSet.get(random));

			
		}
		System.out.println(guessCount+"===final");
	}

	public static void main(String[] args) {
//		"ccoyyo"
//		["wichbx","oahwep","tpulot","eqznzs","vvmplb","eywinm","dqefpt","kmjmxr","ihkovg","trbzyb","xqulhc","bcsbfw","rwzslk","abpjhw","mpubps","viyzbc","kodlta","ckfzjh","phuepp","rokoro","nxcwmo","awvqlr","uooeon","hhfuzz","sajxgr","oxgaix","fnugyu","lkxwru","mhtrvb","xxonmg","tqxlbr","euxtzg","tjwvad","uslult","rtjosi","hsygda","vyuica","mbnagm","uinqur","pikenp","szgupv","qpxmsw","vunxdn","jahhfn","kmbeok","biywow","yvgwho","hwzodo","loffxk","xavzqd","vwzpfe","uairjw","itufkt","kaklud","jjinfa","kqbttl","zocgux","ucwjig","meesxb","uysfyc","kdfvtw","vizxrv","rpbdjh","wynohw","lhqxvx","kaadty","dxxwut","vjtskm","yrdswc","byzjxm","jeomdc","saevda","himevi","ydltnu","wrrpoc","khuopg","ooxarg","vcvfry","thaawc","bssybb","ccoyyo","ajcwbj","arwfnl","nafmtm","xoaumd","vbejda","kaefne","swcrkh","reeyhj","vmcwaf","chxitv","qkwjna","vklpkp","xfnayl","ktgmfn","xrmzzm","fgtuki","zcffuv","srxuus","pydgmq"]
//		10
//		String[] wordList = { "wichbx","oahwep","tpulot","eqznzs","vvmplb","eywinm","dqefpt","kmjmxr","ihkovg","trbzyb","xqulhc","bcsbfw","rwzslk","abpjhw","mpubps","viyzbc","kodlta","ckfzjh","phuepp","rokoro","nxcwmo","awvqlr","uooeon","hhfuzz","sajxgr","oxgaix","fnugyu","lkxwru","mhtrvb","xxonmg","tqxlbr","euxtzg","tjwvad","uslult","rtjosi","hsygda","vyuica","mbnagm","uinqur","pikenp","szgupv","qpxmsw","vunxdn","jahhfn","kmbeok","biywow","yvgwho","hwzodo","loffxk","xavzqd","vwzpfe","uairjw","itufkt","kaklud","jjinfa","kqbttl","zocgux","ucwjig","meesxb","uysfyc","kdfvtw","vizxrv","rpbdjh","wynohw","lhqxvx","kaadty","dxxwut","vjtskm","yrdswc","byzjxm","jeomdc","saevda","himevi","ydltnu","wrrpoc","khuopg","ooxarg","vcvfry","thaawc","bssybb","ccoyyo","ajcwbj","arwfnl","nafmtm","xoaumd","vbejda","kaefne","swcrkh","reeyhj","vmcwaf","chxitv","qkwjna","vklpkp","xfnayl","ktgmfn","xrmzzm","fgtuki","zcffuv","srxuus","pydgmq" };
//		"acckzz"
		String[] wordList = {"acckzz","ccbazz","eiowzz","abcczz"};
		findSecretWord(wordList);
	}

}
