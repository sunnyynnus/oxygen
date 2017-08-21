package careercup;

import java.util.*;

/* GIven a string "str" and pair of "N" swapping indices, generate a lexicographically largest string. 
Swapping indices can be reused any number times. */

public class Lexicographical{

	
	public static void main(String[] args){
		Lexicographical lex = new Lexicographical();
		
		String input = "abdc";
		List<Pair<Integer, Integer>> list = new ArrayList<>();
		list.add(new Pair<Integer, Integer>(0, 3));
		list.add(new Pair<Integer, Integer>(2, 3));		

		System.out.println(lex.getLargestLexicographical(input, list));
	}

	public String getLargestLexicographical(String input, List<Pair<Integer, Integer>> swappingList){
		List<SortedSet<Integer>> connectedComponents = getConnectedComponents(swappingList);	
		
		char arr[] = input.toCharArray();
		for(SortedSet<Integer> component: connectedComponents){
			swapCharacters(arr, component);
		}
		return String.valueOf(arr);
	}	

	private void swapCharacters(char[] arr, SortedSet<Integer> indexSet){
		List<Character> charsToBeSorted = new ArrayList<>();
		// sort all connected nodes
		for(Integer index : indexSet){
			charsToBeSorted.add(arr[index]);
		}
		charsToBeSorted.sort(Collections.reverseOrder());
		// replace lexicographically
		int i=0;
		for(Integer index : indexSet){
			arr[index] = charsToBeSorted.get(i++);
		}		
	}

	private List<SortedSet<Integer>> getConnectedComponents(List<Pair<Integer, Integer>> edges){
		List<SortedSet<Integer>> list = new ArrayList<>();
		
		for(Pair<Integer, Integer> pair:edges){
			boolean isConnected = false;
			for(SortedSet<Integer> set: list){
				SortedSet<Integer> unionCandidateSet = null;
				if(set.contains(pair.x) || set.contains(pair.y)){
					if(!isConnected){
						set.add(pair.x);
						set.add(pair.y);
						isConnected = true;
						unionCandidateSet = set;
					} else{
						unionCandidateSet.addAll(set);
						set.clear();
					}
				}
			}
			if(!isConnected){
				SortedSet<Integer> set = new TreeSet<>();
				set.add(pair.x);
				set.add(pair.y);
				list.add(set);
			}			
		}
		
		// merge more sets if possible
		for(int i=0 ; i< list.size()-1; i++){
			SortedSet<Integer> setA = list.get(i);
			if(setA.size()==0){
				continue;
			}
			for(int j=i+1; j< list.size(); j++){
				SortedSet<Integer> setB = list.get(j);
				if(!Collections.disjoint(setA, setB)){
					setA.addAll(setB);
					setB.clear();
				}
			}
		}	
	
		return list;	
	}


	private static class Pair<T1, T2>{
		T1 x;
		T2 y;
		Pair(T1 x, T2 y){
			this.x = x;
			this.y = y;
		}
	}

}

