package TreeEx;

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
			root=newNode;
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
			}
			if(data<previous.data)
				previous.leftChild=newNode;
			else
				previous.rightChild=newNode;
		
		}
	}//addnode
	
	public Node searchNode(int key)
	{
		Node current=root;
		while(true)
		{
			if(current!=null)
			{
					
				if(current.data==key)
				{
					System.out.println("key found: "+ key);
					return current;
						
				}
				if(key<current.data)
					current=current.leftChild;
					
				else
					current=current.rightChild;

			}
			
			else
			{
				System.out.println("key not found");
				break;
			}
		}//while
								
		return null;
	}//searchnode
	
	public void deleteNode(int key)
	{
		//do search.
		Node current=root;
		Node parent=current;
		Boolean isLeftChild=false;
		while(true)
		{
			if(current!=null)
			{
				
				if(current.data==key)
				{	
					//check if the node is a leaf
					if(current.leftChild==null && current.rightChild==null)
					{
						if(root==current)
						{
							root=null;

						}
						else if(isLeftChild)
							parent.leftChild=null;
						else
							parent.rightChild=null;
						
					 }
					//if one child
					//only rightchild is there
					else if(current.leftChild==null)
					{
						if(root==current)
						root=current.rightChild;
						
						//if current node is itself a leftside
						else if(isLeftChild)
					
							parent.leftChild=current.rightChild;
						
						else
							parent.rightChild=current.rightChild;
						
						
					}//else if only right child

					else if(current.rightChild==null)
					{
						if(root==current)
						root=current.leftChild;
						
						//if current node is itself a leftside
						else if(isLeftChild)
					
							parent.leftChild=current.leftChild;						
						else
							parent.rightChild=current.leftChild;
					}
					//both child are there
					else
					{
					//:TO-DO	
					}
					break;
				}
				//key not found yet
			if(key<current.data)
			{
				parent=current;
				current=current.leftChild;
				isLeftChild=true;
			}
			else
			{	
				parent=current;
				current=current.rightChild; 
				isLeftChild=false;
			}//else
			}//if
			else
			{
				System.out.println("key not found");
				break;
			}//else
		}//while
		
	}

	public void preOrderTraversal()
	{
		System.out.println("*****preorder******");
		preOrderTraversal(root);
	}
	public void preOrderTraversal(Node node)
	{
		if(node==null)
			 return;
		System.out.println(node.data);
		preOrderTraversal(node.leftChild);
		preOrderTraversal(node.rightChild);
		
	}
	
	public void inOrderTraversal()
	{
		System.out.println("*******inorder*******");
		inOrderTraversal(root);
		System.out.println("count= "+count);
	}
	
	private void inOrderTraversal(Node node)
	{
		if(node==null)
			 return;
		count++;
		inOrderTraversal(node.leftChild);
		System.out.println(node.data);
		inOrderTraversal(node.rightChild);
			
	}
	
	public void postOrderTraversal()
	{
		System.out.println("*******postorder*******");
		postOrderTraversal(root);
	}
	
	private void postOrderTraversal(Node node)
	{
		if(node==null)
			 return;
		postOrderTraversal(node.leftChild);
		postOrderTraversal(node.rightChild);
		System.out.println(node.data);
			
	}
}
