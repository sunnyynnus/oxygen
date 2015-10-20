package careercup;

import java.util.*;

/**
	 11/7/14 
	 8.3
*/
public class AllSubset{

	public static void main(String[] args){
		List<Integer> list = Arrays.asList(2, 3, 5);
		List<List<Integer>> allSetList=calculateAllSubset(list);
		List<List<Integer>> allSetListRec=calculateAllSubsetRec(list);
		System.out.println("List is: "+ allSetList+"\n*** with Recursive approach **\n"+  allSetListRec);
	}

	private static List<List<Integer>> calculateAllSubset(List<Integer> list)
	{
		List<List<Integer>> totalSetList=new ArrayList<>();
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

	//recursive approach
	public static List<List<Integer>> calculateAllSubsetRec(List<Integer> list){
    List<List<Integer>> totalSetList= new ArrayList<>();
    calculateAllSubsetRec(totalSetList, list, new ArrayList<>(), 0);
    return totalSetList;
	}

  private static void calculateAllSubsetRec(List<List<Integer>> totalSetList, List<Integer> list, List<Integer> temp, int index){
     
    if(index== list.size()){
      if(!temp.isEmpty()){
        List<Integer> set= new ArrayList<>(temp);
        totalSetList.add(set);
      }
      return;
    }

    temp.add(list.get(index));
    calculateAllSubsetRec(totalSetList, list, temp, index+1); 
    temp.remove(list.get(index));
    calculateAllSubsetRec(totalSetList, list, temp, index+1);

   }
}
