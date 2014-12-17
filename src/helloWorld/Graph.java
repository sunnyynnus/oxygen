package helloWorld;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
	12/16
**/

public class Graph
{

	private Map<Integer, List<Integer>> adjMap= new HashMap<>();
	private Map<Integer, Integer> vertexCountMap=new HashMap<>();

	/**
	@srcVertex-  source vertex
	@desVertex- destination vertex
	// edges are considered as directed edges 
	// for undirected edges, create two edges	
	**/
	public void addEdge(int srcVertex, int desVertex)
	{
		List<Integer> adjVertexList;
		
		if(!adjMap.containsKey(srcVertex))
		{
			adjVertexList= new ArrayList<>();
			adjVertexList.add(desVertex);
			adjMap.put(srcVertex, adjVertexList);
			
		}
		else
		{
			adjVertexList= adjMap.get(srcVertex);
			adjVertexList.add(desVertex);
			adjMap.put(srcVertex, adjVertexList);
		}
		vertexCountMap.put(srcVertex, srcVertex);
		vertexCountMap.put(desVertex, desVertex);
	}
	
	/**
	@return Map containing Graph 
	**/
	public Map<Integer, List<Integer>> getAdjMap()
	{
		return adjMap;
	}
	
	/**
	@return total vertices count in the graph
	**/
	public int getVertexCount()
	{
		return vertexCountMap.size();
	}
}
