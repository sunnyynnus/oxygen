package leetcode;

import java.util.*;

public class FactorCombinations{

	public static void main(String[] args){
	
		FactorCombinations fc = new FactorCombinations();
		System.out.println("factors of 26: "+ fc.getFactors(26));
		System.out.println("factors of 48: "+ fc.getFactors(48));
	
	}

	public List<List<Integer>> getFactors(int n) {
        	Set<List<Integer>> set= getFactorsUtil(n, new HashMap<Integer, Set<List<Integer>>>());
        	return new ArrayList<List<Integer>>(set);
    	}
    
    	private Set<List<Integer>> getFactorsUtil(int n, Map<Integer, Set<List<Integer>>> mem){
        
        	if(n<=1){
            		return new HashSet<>();
        	}
        
        	if(mem.containsKey(n)) return mem.get(n);
        
        	Set<List<Integer>> set = new HashSet<>();
        
        	for(int i=2; i<n; i++){
            		if(n%i==0){              
                   		Set<List<Integer>> temp = getFactorsUtil(n/i, mem);
                    		if(temp !=null && temp.size() !=0){
                        		for(List<Integer> list: temp){
                            			List<Integer> l = new ArrayList<>(list);
                            			l.add(i);
                            			Collections.sort(l);
                            			set.add(l);
                        		}                     
                    		}
                        	List<Integer> list = new ArrayList<>();
                        	list.add(i);
                        	list.add(n/i);
                        	Collections.sort(list);
                        	set.add(list);
                               
            		}
        	}
        	mem.put(n, set);
        	return set;
    	}


}
