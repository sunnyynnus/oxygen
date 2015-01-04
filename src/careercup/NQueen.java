package careercup;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class NQueen{

     public static void main(String []args){
        int numQueen=8;
        
        List<Map<Integer, Integer>> list= getNQueenPossiblePos(numQueen);

        for(Map<Integer, Integer> m: list)
        {
            System.out.println(m);
        }

        System.out.println("Total position soln. = "+list.size());
     }
     
     public static List<Map<Integer, Integer>> getNQueenPossiblePos(int numQueen)
     {
	Map<Integer, Integer> map=new HashMap<>();
        List<Map<Integer, Integer>> list=new ArrayList<>();
     	getNQueenPossiblePos(numQueen, 0,map, list);
	return list;
     }
	 
     private static void getNQueenPossiblePos(int n, int level, Map<Integer, Integer> map, List<Map<Integer, Integer>> list)
     {
        if(level==n)
        {
		Map<Integer, Integer> temp=new HashMap<>();
		temp.putAll(map);
 		list.add(temp);
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
     
     private static boolean checkOK(int row, int col, Map<Integer, Integer> map)
     {
         Set<Map.Entry<Integer,Integer>> set=map.entrySet();
         Iterator<Map.Entry<Integer,Integer>> itr =set.iterator();
         while(itr.hasNext())
         {
            Map.Entry<Integer,Integer> m= itr.next();
            int k=m.getKey();
            int v=m.getValue();
            if(v==col || (row-k)==(col-v) || (row-k)==-(col-v))
            {
                return false;
            }
            
         }
         return true;
     }

    /* private static Map<Integer,Integer> deepClone(Map<Integer,Integer> map)
     {
         Map<Integer,Integer> temp= new HashMap<Integer, Integer>();
         Set<Map.Entry<Integer,Integer>> set=map.entrySet();
         Iterator<Map.Entry<Integer,Integer>> itr=set.iterator();
         while(itr.hasNext())
         {
            Map.Entry<Integer,Integer> m= itr.next();
            temp.put(m.getKey(),m.getValue());
         }
         return temp;
     }*/
}
