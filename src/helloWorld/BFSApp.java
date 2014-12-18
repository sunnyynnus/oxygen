package helloWorld;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import helloWorld.Graph; 

/**

	12/16
**/	

public class BFSApp
{
	
	public List<List<Integer>> addLevelToVertices(int startVertex, Graph G)
	{
		
		Map<Integer, List<Integer>> adjMap= G.getAdjMap();
		int vertexCount= G.getVertexCount();
		List<Integer> adjVertexList = adjMap.get(startVertex);
		Map<Integer, Integer> visitedMarkMap= new HashMap<>();
		List<List<Integer>> vertexLevelList = new ArrayList<>();
		int count;
		
		List<Integer> newList =new ArrayList<>();
		newList.add(startVertex);
		vertexLevelList.add(newList); //level 0
		visitedMarkMap.put(startVertex, startVertex);
		newList =new ArrayList<>();
		
		for(int i : adjVertexList)
		{
			if(!visitedMarkMap.containsKey(i))
			{
				visitedMarkMap.put(i, i);
				newList.add(i);
			}
		}
		vertexLevelList.add(newList); // level 1

		while(true)
		{
			List<Integer> tempList =new ArrayList<>();
			count=adjVertexList.size();
			
			for(int j=0; j<count; j++)
  			{
				
				int vertex=adjVertexList.get(j);
				newList=adjMap.get(vertex);
				if(newList !=null)
				{
					for(int i=0; i<newList.size(); i++)
					{
						if(!visitedMarkMap.containsKey(newList.get(i)))
						{
							visitedMarkMap.put(newList.get(i), newList.get(i));
							tempList.add(newList.get(i));
						}
				
					}
				}
				
			}
			if(tempList!=null)
			{
				vertexLevelList.add(tempList);
			
				adjVertexList=new ArrayList<Integer>();
				adjVertexList.addAll(tempList);
			}
			
			if(visitedMarkMap.size() >= vertexCount || count==0)
                        {
                                break;
                        }
		}
		
		return vertexLevelList;
	
	}

	public void printBFSList(List<List<Integer>> vertexLevelList)
	{
		System.out.println("*** BFS *****");
		for(List<Integer> list:vertexLevelList)
                {
                        for(Integer i: list)
                        {
                                System.out.print(i+"\t");
                        }
                        System.out.println("");
                }

	}
	
	public static void main(String[] args)
	{
		Graph G =new Graph();
		BFSApp bfs= new BFSApp();
		
		bfs.addTestEdges(G);
		int startingVertex=0; 
		bfs.printBFSList(bfs.addLevelToVertices(startingVertex, G));
		
	}

	private void addTestEdges(Graph G)
	{
		G.addEdge(0, 1);
		G.addEdge(1, 0);
		G.addEdge(0, 2);
                G.addEdge(2, 0);
		G.addEdge(1, 3);
                G.addEdge(3, 1);
                G.addEdge(1, 4);
                G.addEdge(4, 1);
		G.addEdge(3, 4);
                G.addEdge(4, 3);
		G.addEdge(1, 2);
                G.addEdge(2, 1);
		G.addEdge(2, 4);
                G.addEdge(4, 2);
		G.addEdge(2, 6);
                G.addEdge(6, 2);
                G.addEdge(2, 7);
                G.addEdge(7, 2);
		G.addEdge(6, 7);
                G.addEdge(7, 6);
		G.addEdge(4, 5);
                G.addEdge(5, 4);
		
	}

}
