package helloWorld;

import java.util.*;

public class StringValidity{

	public static void main(String[] args){
		Set<String> dict= new HashSet<>();
		dict.add("i");
		dict.add("love");
		dict.add("india");
		String str="iloveindia";
		System.out.println(validateStringUsingDict(dict, str));
	}

	public static boolean validateStringUsingDict(Set<String> dict, String str){
		return validateStringUsingDict(new HashSet<String>(), dict, str, 0);
	}

	private static boolean validateStringUsingDict(Set<String> memoized, Set<String> dict, String str, int index){
	
		if(dict.contains(str) || memoized.contains(str)){
			return true;
		}

		if(index == str.length()-1){
			return false;
		}

		if(validateStringUsingDict(memoized, dict, str.substring(0, index+1), 0) && validateStringUsingDict(memoized, dict, str.substring(index+1), 0)){
			return true;
		} else{
			return validateStringUsingDict(memoized, dict, str, index+1);
		}
	}
	
}
