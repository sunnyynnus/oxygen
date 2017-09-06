package careercup;

/*
Given a binary tree, we need to find maximum value we can get by subtracting value of node B from value of node A, where A and B are two nodes of the binary tree and A is an ancestor of B. 
Time complexity is O(n).
*/

public class MaxDiffInBT{

	public static void main(String[] args){
		MaxDiffInBT obj = new MaxDiffInBT();

		Node root = new Node(8);
		root.leftChild = new Node(3);
		root.leftChild.leftChild = new Node(1);
		root.leftChild.rightChild = new Node(6);
		root.leftChild.rightChild.leftChild = new Node(4);
		root.leftChild.rightChild.rightChild = new Node(7);
		root.rightChild = new Node(10);
		root.rightChild.rightChild = new Node(14);
		root.rightChild.rightChild.leftChild = new Node(13);
		
		System.out.println(obj.findMaxDifferenceFromAncestor(root));

	}

	public int findMaxDifferenceFromAncestor(Node root){
		Int result = new Int(Integer.MIN_VALUE);	
		inOrder(root, root.value, result);
		return result.value;
	}

	private void inOrder(Node node, int maxSoFar, Int result){
		if(node == null){
			return;
		}

		maxSoFar = Math.max(node.value, maxSoFar);
		result.value = Math.max(result.value, maxSoFar-node.value);
		inOrder(node.leftChild, maxSoFar, result);
		inOrder(node.rightChild, maxSoFar, result);
	}

	private static class Int{
		int value;
		Int(int value){
			this.value = value;
		}
	}

	private static class Node{
		int value;
		Node leftChild;
		Node rightChild;
		Node(int value){
			this.value = value;
		}
	}
}
