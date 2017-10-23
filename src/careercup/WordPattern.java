package careercup;

import java.util.*;

public class WordPattern{
	
	public static void main(String[] args){
		WordPattern obj = new WordPattern();
		System.out.println(obj.wordPatternMatch("abab", "sunnyseattlesunnyseattle"));
		System.out.println(obj.wordPatternMatch("aba", "ramsitaram"));
		System.out.println(obj.wordPatternMatch("abb", "nottruecase"));
	}

	public boolean wordPatternMatch(String pattern, String input){
		if((pattern == null && input == null) || (pattern.length()==0 && input.length()==0) 
			|| (pattern.length()==1 && input !=null)){
			return true;
		}
		if(pattern==null || input == null || pattern.length() > input.length()){
			return false;
		}

		Map<Character, String> map = new HashMap<>()	;
		return patternMatchUtil(pattern, input, 0, 0, map);
	}

	private boolean patternMatchUtil(String pattern, String input, int pIndex, int iIndex, Map<Character, String> map){
		
		if(pIndex==pattern.length() && iIndex == input.length()){
			return true;
		}

		if(pIndex >= pattern.length() || iIndex >= input.length()){
			return false;
		}

		char ch = pattern.charAt(pIndex);
		
		for(int i = iIndex+1; i<= input.length(); i++){
			String val = input.substring(iIndex, i);
			
			if(!map.containsKey(ch) && !map.containsValue(val)){
				map.put(ch, val);
				if(patternMatchUtil(pattern, input, pIndex+1, i, map)){
					return true;
				}

				map.remove(ch);
			} else if(map.containsKey(ch) && val.equals(map.get(ch))){
				if(patternMatchUtil(pattern, input, pIndex+1, i, map)){
					return true;
				}
			}
		}
		return false;
	}
}
