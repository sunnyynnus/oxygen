package careercup;

import java.util.*;

/* remove minimum number of parentheses to make the input string valid. 
   If more than one valid output are possible removing same number of parentheses then print all such output.
*/

public class InvalidParenthesisRemoval{
	
	public static void main(String[] args){
		
		InvalidParenthesisRemoval obj = new InvalidParenthesisRemoval();
		String input = "(v)())()";

		System.out.println(obj.getMaximumLengthValidParenthesis(input));			
	}
        
	// Brute-force approach
	public Set<String> getMaximumLengthValidParenthesis(String input){
		Set<String> set = new HashSet<>();
		
		if(isValid(input)){
			set.add(input);
			return set;	
		}
		
		Deque<String> queue = new ArrayDeque<>();
		queue.add(input);
		
		while(!queue.isEmpty()){
			String invalidStr = queue.remove();
			for(int i = 0 ; i < invalidStr.length(); i++){
				if(!(invalidStr.charAt(i) == '(' || invalidStr.charAt(i) == ')')){
					continue;
				}
				String candidateString = getCandidateStringAfterRemovingCharAt(invalidStr, i);
				if(isValid(candidateString)){
					set.add(candidateString);
				} else{
					queue.add(candidateString);
				}
			}
			if(!set.isEmpty()){
				break;
			}	
		}
		return set;
	}

	private boolean isValid(String parenthesisString){
		boolean valid = true;
		int extraOpeningBracesCount = 0;
		for(int i =0; i< parenthesisString.length(); i++){
			char ch = parenthesisString.charAt(i);
			if(ch=='('){
				extraOpeningBracesCount++;
			} else if(ch==')'){
				extraOpeningBracesCount--;
			}
			if(extraOpeningBracesCount < 0){
					valid = false;
					break;
			} 
		}
		return valid; 
	}

	private String getCandidateStringAfterRemovingCharAt(String str, int index){
		return str.substring(0, index)+str.substring(index+1);
	}

}
