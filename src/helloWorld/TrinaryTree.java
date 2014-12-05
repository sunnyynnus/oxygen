package zillow.app;
/**
@author: Sunny
	
Description: Two required methods are implemented in this tri-nary tree class

**/

public class TrinaryTree
{
	Node root;
	
	public TrinaryTree()
	{
		root=null;
	}
	
	public void insertNode(int data)
	{
		Node newNode=new Node(data);
		if(root==null)
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
				{
					current=current.leftChild;
				}
				else if(data>current.data)
				{
					current=current.rightChild;
				}
				else
				{
					current=current.middleChild;
				}
			}//while
			if(data<previous.data)
			{
				previous.leftChild=newNode;
			}
			else if(data>previous.data)
			{
				previous.rightChild=newNode;
			}
			else
			{
				previous.middleChild=newNode;
			}
				
		}
	}

	
	/**
	@key - key of Node to be deleted
	@return true- if node found and deleted .. incase of duplicate..last node(leaf) gets deleted
	@else return false
	**/
	public boolean deleteNode(int key)
	{
		Node current=root;
		Node previous=null;
		boolean middleChildFlag=false;
		boolean leftChildFlag=false;
		
		while(current.data !=key)
		{
			previous=current;
			if(key<current.data)
                        {
                        	current=current.leftChild;
                                leftChildFlag=true;
                        }
                        else
                        {
                                leftChildFlag=false;
                                current=current.rightChild;
                        }
				
			if(current==null)
			{
				return false;
			}
		}
		
		//node found..now needs to be deleted
		while(current.middleChild !=null)
		{
			middleChildFlag=true;
			previous=current;
                        current=current.middleChild;
                }
					
		//case 1: middleChildFlag =true
		if(middleChildFlag)
		{
			//leaf node..simple remove
			previous.middleChild=null;
		}
		//case 2: leaf node - 
		// in all below cases it cannot be middleChild
		else if(current.leftChild==null && current.rightChild==null)
		{	
			if(current==root)
			{
				root=null;
			}
			else if(leftChildFlag)
			{
				previous.leftChild=null;
			}
			else
			{
				previous.rightChild=null;
			}
		}
		//case3: leftchild is not null
		else if(current.rightChild==null)
		{
			if(current==root)
			{
				root=current.leftChild;
			}
			else if(leftChildFlag)
			{
				previous.leftChild=current.leftChild;
			}
			else
			{
				previous.rightChild=current.leftChild;
			}
		}
		//case4: rightchild is not null
		else if(current.leftChild==null)
		{
			if(current==root)
			{
				root=current.rightChild;
			}
			else if(leftChildFlag)
			{
				previous.leftChild=current.rightChild;
			}
			else
			{
				previous.rightChild=current.rightChild;
			}
		}
		// both child not null
		else
		{
			Node successor=getSuccessor(current);
		
			if(current==root)
			{
				root=successor;
			}
			else if(leftChildFlag)
			{
				previous.leftChild=successor;
			}
			else
			{
				previous.rightChild=successor;
			}
			//old leftchild connection update
			successor.leftChild=current.leftChild;
		}
				
			return true;
							
		
	}
	

	/**
		return inorder successor of node being deleted
	**/
	private Node getSuccessor(Node oldNode)
	{
		Node parentSuccessor=null;
		Node successor=oldNode;
		Node current=oldNode.rightChild; //it cannot be null
		
		while(current!=null)
		{
			parentSuccessor=successor;
			successor=current;
			current=current.leftChild;
		}
		//atleast 1 leftchild of oldnode.rChild
		if(successor!=oldNode.rightChild)
		{
			//nothing to do with middlechild
			parentSuccessor.leftChild=successor.rightChild;
			successor.rightChild=oldNode.rightChild; //successor takes the place of del old node
		}
		return successor;
	}
}


class Node
{

	int data; // assumption is that keys wil be of int type
	Node leftChild;
	Node rightChild;
	Node middleChild;

	public Node(int data)
	{
		this.data=data;
		leftChild=null;
		rightChild=null;
		middleChild=null;
	}
	
}
