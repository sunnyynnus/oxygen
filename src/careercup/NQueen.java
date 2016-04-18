package careercup;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class NQueen{

     public static void main(String []args){
        int numQueen=8;
        
        List<Map<Integer, Integer>> list= (new NQueen()).getNQueenPossiblePos(numQueen);

        for(Map<Integer, Integer> m: list)
        {
            System.out.println(m);
        }

        System.out.println("Total position soln. = "+list.size());
     }
     
     public List<Map<Integer, Integer>> getNQueenPossiblePos(int numQueen)
     {
        List<Map<Integer, Integer>> list=new ArrayList<>();
     	  getNQueenPossiblePos(numQueen, 0, new HashMap<Integer, Integer>(), list);
	      return list;
     }
	 
     private void getNQueenPossiblePos(int n, int level, Map<Integer, Integer> map, List<Map<Integer, Integer>> list)
     {
        if(level==n)
        {
 		      list.add(new HashMap<>(map));
		      return;
        }
        
        for(int i=0;i<n;i++)
        {
            if(checkOK(level, i, map))
            {
                map.put(level, i);
                getNQueenPossiblePos(n, level+1,map, list);
                map.remove(level);
            }
           
        }
     }
     
     private boolean checkOK(int row, int col, Map<Integer, Integer> map)
     {
         for(Entry<Integer, Integer> entry: map.entrySet())
         {
            int k=entry.getKey();
            int v=entry.getValue();
            if(v==col || Math.abs(row-k)==Math.abs(col-v))
            {
                return false;
            }
            
         }
         return true;
     }

}
