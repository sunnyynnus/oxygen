package helloWorld;

import java.util.Deque;
import java.util.ArrayDeque;
import helloWorld.Node;
/**
 old eclipse work updated
**/
public class Tree {

	public Node root;
	int count=0;
	public Tree()
	{
		root=null;
	}
	
	public boolean isEmpty()
	{
		return root==null;	
	}
	
	public void addNode(int data)
	{
		Node newNode=new Node(data);
		if(isEmpty())
		{
			root=newNode;
		}
		else
		{
			Node current=root;
			Node previous=null;
			while(current!=null)
			{
				previous=current;
				if(data<current.data)
					current=current.leftChild;
				else
					current=current.rightChild;
			}//while
			if(data<previous.data)
			{
				previous.leftChild=newNode;
			}
			else
			{
				previous.rightChild=newNode;
			}
				newNode.parent=previous;
		
		}//else
	}//addnode
	
	public  void insertNodes()
	{
		addNode(50);
		addNode(40);
		addNode(60);
		addNode(30);
		addNode(70);
		addNode(65);
		addNode(20);
		addNode(35);
		
	}

	public void inOrderTraversal()
	{
		System.out.println("*******inorder*******");
		inOrderTraversal(root);
		System.out.println("count= "+count);
	}

	private void inOrderTraversal(Node node)
	{
		if(node==null) return;
		count++;
		inOrderTraversal(node.leftChild);
		System.out.println(node.data);
		inOrderTraversal(node.rightChild);
		
	}
	
	public void inOrderTraversalNRec()
	{
   		System.out.println("*******inorder Non rec*******"); 
   		int count=0;
   		Node current=root;
   		Deque<Node> stack = new ArrayDeque<>();
   		while(true)
   		{
   	    		while(current !=null)
   	    		{
   	        		stack.push(current);
	   	        	count++;
   			        current=current.leftChild;
   	    		}
	        	current=stack.pop();
   	    
	   	    	System.out.println(current.data);
   	    
   	    		current=current.rightChild;
   	    
   	    		if(current==null && stack.isEmpty())
   	    		{
   	        		break;
   	    		}
   		}
   		System.out.println("count= "+count);
	}

	public Node searchNode(int key)
	{
		Node current=root;
			while(true)
			{
				if(current!=null)
				{
				
				if(current.data==key)
				{	System.out.println("key found: "+ key);
				return current;
					
				}
				if(key<current.data)
				
					current=current.leftChild;
				
				else
					current=current.rightChild;

				}//if
				else
				{
					System.out.println("key not found");
					break;
				}//else
			}//while
							
			return null;
	}//searchnode
}
