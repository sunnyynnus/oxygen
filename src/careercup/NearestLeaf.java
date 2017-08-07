package careercup;

import java.util.*;
import helloWorld.Node;
import helloWorld.Tree;

/*
 Closest leaf to a given node in Binary Tree
 O(n) time & space
*/
public class NearestLeaf{

	public static void main(String[] args){
		Tree tree = getTree();
		Node targetNode = tree.root.rightChild;
		NearestLeaf nLeaf = new NearestLeaf();
		System.out.println("nearest leaf distance is :: " + nLeaf.closestLeafDistance(tree, targetNode));
	}
	
	public int closestLeafDistance(Tree tree, Node targetNode){
		Map<Node, Integer> map = new HashMap<>();
		postOrder(tree.root, map);
        	preOrder(tree.root, map, Integer.MAX_VALUE/2);
        	return map.get(targetNode);	
	}

	// find nearest leaf distance for each node in map(already calculated via child) using its parent values as well
	private void preOrder(Node root, Map<Node, Integer> closestLeafMappings, int parentValue){
		if(root==null){
             		return;
         	}
        
         	int temp = Math.min(closestLeafMappings.get(root), parentValue +1);
         	closestLeafMappings.put(root, temp);
         
         	preOrder(root.leftChild, closestLeafMappings, temp);
         	preOrder(root.rightChild, closestLeafMappings, temp);

	}

	// find nearest leaf distance for each node only through its child
	private void postOrder(Node root, Map<Node, Integer> closestLeafMappings){
		if(root==null){
             		return ;
         	}
         	postOrder(root.leftChild, closestLeafMappings);
         	postOrder(root.rightChild, closestLeafMappings);
         	
		int leftChildVal= closestLeafMappings.getOrDefault(root.leftChild, Integer.MAX_VALUE); 
         	int rightChildVal= closestLeafMappings.getOrDefault(root.rightChild, Integer.MAX_VALUE); 
         	// for leaf nodes, it will be -1
		int distanceFromChild = Math.min(leftChildVal, rightChildVal) == Integer.MAX_VALUE ? -1 : Math.min(leftChildVal, rightChildVal);
         
        	closestLeafMappings.put(root, distanceFromChild+1);
	}

	private static Tree getTree(){
		Tree tree= new Tree();
        	tree.root = new Node(10);
        	tree.root.leftChild = new Node(12);
        	tree.root.rightChild = new Node(13);
        	tree.root.rightChild.leftChild = new Node(14);
        	tree.root.rightChild.rightChild = new Node(15);
        	tree.root.rightChild.leftChild.leftChild = new Node(21);
        	tree.root.rightChild.leftChild.leftChild.leftChild = new Node(1);
        	tree.root.rightChild.leftChild.leftChild.rightChild = new Node(2);
        	tree.root.rightChild.leftChild.rightChild = new Node(22);
        	tree.root.rightChild.leftChild.rightChild.leftChild = new Node(3);
        	tree.root.rightChild.leftChild.rightChild.rightChild = new Node(4);
        	tree.root.rightChild.rightChild.leftChild = new Node(23);
        	tree.root.rightChild.rightChild.leftChild.leftChild = new Node(5);
        	tree.root.rightChild.rightChild.leftChild.rightChild = new Node(6);
        	tree.root.rightChild.rightChild.rightChild = new Node(24);
        	tree.root.rightChild.rightChild.rightChild.leftChild = new Node(7);
        	tree.root.rightChild.rightChild.rightChild.rightChild = new Node(8);
        	return tree;
	}

}
