package helloWorld;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import helloWorld.Graph;
/**
	12/18
**/

public class DFSApp
{

	List<Integer> dfsList =new ArrayList<>();
	Map<Integer, Integer> visitedMarkMap= new HashMap<>();
		
	public void doDFS(int startVertex, Graph G)
	{
		Map<Integer, List<Integer>> adjMap= G.getAdjMap();
		visitedMarkMap.put(startVertex, startVertex);
		dfsList.add(startVertex);
		doDFSRec(startVertex, adjMap);
	}

	public void doDFSRec(int srcVertex, Map<Integer, List<Integer>> adjMap)
	{
		List<Integer> tempList= adjMap.get(srcVertex);
		if(tempList==null || tempList.size() < 1)
		{
			return ;
		}
		
		for(int i=0;i<tempList.size();i++)
		{
			int desVertex= tempList.get(i);
			if(!visitedMarkMap.containsKey(desVertex))
			{
				visitedMarkMap.put(desVertex, desVertex);
				dfsList.add(desVertex);
				doDFSRec(desVertex, adjMap);
			}
		}
		
	}

	
	public static void main(String[] args)
	{
		Graph G =new Graph();
		DFSApp dfs= new DFSApp();
		
		dfs.addTestEdges(G);
		int startingVertex=0; 
		dfs.doDFS(startingVertex, G);
		dfs.printDFSList();

	}
	
	public  void printDFSList()
	{
		System.out.println("*** DFS *****");
		
		for(int i: dfsList)
                {
          	      System.out.println(i);
                }

	}


	private void addTestEdges(Graph G)
	{
		G.addEdge(0, 1);
		G.addEdge(0, 2);
                G.addEdge(2, 0);
		G.addEdge(1, 3);
                G.addEdge(3, 1);
                G.addEdge(1, 4);
                G.addEdge(3, 4);
                G.addEdge(2, 4);
                G.addEdge(4, 2);
		G.addEdge(2, 6);
                G.addEdge(6, 2);
                G.addEdge(2, 7);
                G.addEdge(7, 2);
		G.addEdge(6, 7);
                G.addEdge(4, 5);
                G.addEdge(5, 4);
		G.addEdge(5, 8);
	}
}
