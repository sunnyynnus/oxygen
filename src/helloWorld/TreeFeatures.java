package helloWorld;

import java.util.Stack;

/**
 * @author sunny
 * 1. an algorithm to find the ‘next’ node (e.g., in-order successor) of a given node in a binary 
 * 	  search tree where each node has a link to its parent
 * 2. first common ancestor of two nodes in a binary search tree 
 * 3. first common ancestor of two nodes in a binary tree 
 */
public class TreeFeatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//inOrderSuccessor();
		//findLCAinBST();
		//findLCAinBT();
		findSubTree();
	}
	private static void inOrderSuccessor()
	{
		Tree tree=new Tree();
		tree.insertNodes();
		Node node= tree.searchNode(75);
		node=inOrderSuccessor(node);
		if(node!=null)
		{
			node.displayNode(node);
		}
		
	}
	private static Node inOrderSuccessor(Node current)
	{
	    if(current==null)
	    {
	        return null;
	    }
	    else if(current.rightChild !=null)
	    {
	        current= current.rightChild;
	        while(current.leftChild !=null)
	        {
	            current=current.leftChild;
	        }
	        return current;
	        
	    }
	    else
	    {
	        Node pNode= current.parent;
	        if(pNode==null)
	        {
	            return null;
	        }
	        else if(pNode.leftChild==current)
	        {
	            return pNode;
	        
	        }
	        else
	        {
	        	
	        	/**
	        	 * The below commented code will change the given tree
	        	 * in order to find a successor
	        	 */
	        	/*
	        	pNode.rightChild=null;
	            return inOrderSuccessor(pNode);
	            */
	        	
	        	while(pNode.parent !=null)
	        	{
	        		current=pNode;
	        		pNode=pNode.parent;
	        		if(pNode.leftChild==current)
	        		{
	        			return pNode;
	        			
	        		}
	        		
	        	}
	            return null;
	        }
	    
	    }

	}

	/**
	 * first common ancestor of two nodes in a binary search tree.
	 */
	private static void findLCAinBST()
	{
		Tree tree=new Tree();
		tree.insertNodes();
		Node node1= tree.searchNode(50);
		Node node2= tree.searchNode(35);
		if(node1 !=null && node2 !=null)
		{
			Node lca= findLCAinBST(tree.root, node1, node2);
			System.out.println("LCA node value= "+lca.data);
		}
	}
	
	private static Node findLCAinBST(Node root, Node n1, Node n2) 
	{
	    if(root==null)
	    {
	        return null;
	    }
	    
	    if(root.data < n1.data && root.data < n2.data)
	    {
	        return findLCAinBST(root.rightChild, n1, n2);
	    }
	    if(root.data > n1.data && root.data > n2.data)
	    {
	        return findLCAinBST(root.leftChild, n1, n2);
	    }
	    return root;
	}
	
	//// 2.
	
	private static void findLCAinBT()
	{
		Tree tree=new Tree();
		tree.insertNodes();
		Node node1= tree.searchNode(20);
		Node node2= tree.searchNode(35);
		if(node1 !=null && node2 !=null)
		{
			Node lca= findLCAinBT(tree.root, node1, node2);
			if(lca!=null)
			{
				System.out.println("LCA node value= "+lca.data);
			}	
		}
		
	}
	private static Node findLCAinBT(Node root, Node n1, Node n2)
	{
		Stack<Node> s1=new Stack<>();
		Stack<Node> s2=new Stack<>();
		
		if(findPath(root, n1, s1) && findPath(root, n2, s2))
		{
			System.out.println("yo");
			return findLastCommonElement(s1, s2);	
		}
		return null;	
	}

	private static boolean findPath(Node root, Node n1, Stack<Node> s1)
	{
		if(root==null)
		{
			return false;
		}
		s1.push(root);
		if(root.data==n1.data)
		{
			return true;
		}
		if(findPath((root.data>n1.data)? root.leftChild : root.rightChild , n1, s1))
			return true;
		s1.pop();
		return false;
	}
	
	private static Node findLastCommonElement(Stack<Node> s1, Stack<Node> s2)
	{
		Stack<Node> s3=new Stack<>();
		Stack<Node> s4=new Stack<>();
		
		while(!s1.isEmpty())
		{
			Node temp=s1.pop();
			System.out.println("temp1= "+temp.data);
			s3.push(temp);
		}
		
		while(!s2.isEmpty())
		{
			Node temp=s2.pop();
			System.out.println("temp2= "+temp.data);
			s4.push(temp);
		}
		
			Node temp =s3.pop();
			while(!s3.isEmpty() && !s4.isEmpty())
			{
				s4.pop();
				temp =s3.pop();
				if(temp==s4.pop())
				{
					continue;
				}
				else
				{
					return temp;
				}
			}
			return temp;
	}
	
	/**
	 * an algorithm to decide if T2 is a subtree of T1.
	 * @param T1
	 * @param T2
	 * @return
	 */
	private static void findSubTree()
	{
		Tree T1=new Tree();
		Tree T2=new Tree();
		T1.insertNodes();
		T2.insertNodes();
		System.out.println(findSubTree(T1,T2));
	}
	
	private static boolean findSubTree(Tree T1, Tree T2)
	{
		Node currentT1= T1.searchNode(T2.root.data);
		if(currentT1!=null)
		{
		
			return checkSubTree(currentT1, T2.root);
		}
		return false;
	}
	
	private static boolean checkSubTree(Node t1, Node t2)
	{
		if(t1==null && t2==null)
		{
			return true;
		}
		if(t2==null || t1==null)
		{
			return false;
			
		}
		if(t1.data !=t2.data)
		{
			return false;
			
		}
		return(checkSubTree(t1.leftChild, t2.leftChild) || checkSubTree(t1.rightChild, t2.rightChild));
	}
		
}

