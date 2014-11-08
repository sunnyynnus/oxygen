package careercup;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
	 11/7/14 
	 8.3
*/
public class AllSubset{


	public static void main(String[] args)
	{
		List<Integer> list =new ArrayList<>();
		createSet(list);
		//List<List<Integer>> allSetList=calculateAllSubset(list);
		List<List<Integer>> allSetList=calculateAllSubsetRec(list);
		System.out.println("size ="+ allSetList.size());
		displayList(allSetList);
	}

	private static List<List<Integer>> calculateAllSubset(List<Integer> list)
	{
		List<List<Integer>> totalSetList=new ArrayList<>();
		//List<Integer> tempList=new ArrayList<>();
   		int max=1<<list.size();
		
		for(int i=0;i<max;i++)
		{
			int k=i;
			List<Integer> tempList=new ArrayList<>();
			int index=0;
			while(k>0)
			{
				if((k&1)>0)
				{
					tempList.add(list.get(index));
				}
				k=k>>1;
				index++;
			}
			totalSetList.add(tempList);
		}

		return totalSetList;
	}

	
	private static void createSet(List<Integer> list)
	{
		list.add(2);
		//list.add(4);
		//list.add(6);
		//list.add(5);
	}

	private static void displayList(List<List<Integer>> list)
	{
		Iterator<List<Integer>> listIter = list.iterator();
		while(listIter.hasNext())
		{
		    List<Integer> intList= listIter.next();
			for(Integer i : intList)
			{
				System.out.print(i);
			}
			System.out.println("");
		}
	}

	//recursive approach
	private static List<List<Integer>> calculateAllSubsetRec(List<Integer> list)
	{
		List<List<Integer>> totalSetList= new ArrayList<>();
		return calculateAllSubsetRec(totalSetList, list, 0);
	}

	 private static List<List<Integer>> calculateAllSubsetRec(List<List<Integer>> totalSetList, List<Integer> list, int index)
        {
                //base case
		if(list.size()==index)
		{
			totalSetList.add(new ArrayList<Integer>());
		}
		else
		{
			totalSetList= calculateAllSubsetRec(totalSetList, list, index+1);
			int item= list.get(index);
			List<List<Integer>> otherSubset= new ArrayList<>();
			
			for(List<Integer> intList: totalSetList)
			{ 
				List<Integer> tempList= new ArrayList<>();
				tempList.addAll(intList);  	// add existing set val
				tempList.add(item);		//add ith item
				otherSubset.add(tempList);		//add both in other subset list
			}
			totalSetList.addAll(otherSubset);		//add to main list
		}
		return totalSetList;
        }
}
