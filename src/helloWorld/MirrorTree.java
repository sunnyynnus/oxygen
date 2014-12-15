package helloWorld;

import java.util.List;
import java.util.ArrayList;
import helloWorld.Node;
import helloWorld.Tree;
/**
	12/09
**/
public class MirrorTree
{

	public static void main(String[] args)
	{
		MirrorTree mTree = new MirrorTree();

		Tree tree1 = new Tree(); //BST
		mTree.insertNodesinBSTree(tree1);

		BTree tree2= mTree.new BTree(); //Binary Tree, not BST
		tree2.insertAllNodes();
		
		if(mTree.isTreesRMirrorImage(tree1, tree2))
		{
			System.out.println("Both trees r mirror images of each other");
		}
		else
		{
			System.out.println("Both trees r NOT mirror image of each other");
		}
	
	}
	
	private void insertNodesinBSTree(Tree tree1)
	{
		tree1.addNode(17);
		tree1.addNode(22);
		tree1.addNode(6);
		tree1.addNode(2);
		tree1.addNode(14);
                tree1.addNode(12);
                tree1.addNode(13);
                tree1.addNode(18);
		tree1.addNode(19);
		
	}

	private boolean isTreesRMirrorImage(Tree tree1, BTree tree2)
	{
		List<Integer> list1=new ArrayList<>();
		List<Integer> list2=new ArrayList<>();
		
		inorderTraversal(tree1, list1);
		rightorderTraversal(tree2, list2);
		
		return isListsREqual(list1, list2);
		
	}

	private void inorderTraversal(Tree tree, List<Integer> list)
	{
		inorderTraversalRec(tree.root, list);
	}

	private void inorderTraversalRec(Node node, List<Integer> list)
	{
		if(node==null)
		{
			return;
		}
		
		inorderTraversalRec(node.leftChild, list);
		list.add(node.data);
		inorderTraversalRec(node.rightChild, list);
		
	}

	private void rightorderTraversal(BTree tree, List<Integer> list)
        {
                rightorderTraversalRec(tree.root, list);
        }

        private void rightorderTraversalRec(Node node, List<Integer> list)
        {
                if(node==null)
                {
                        return;
                }

                rightorderTraversalRec(node.rightChild, list);
                list.add(node.data);
                rightorderTraversalRec(node.leftChild, list);
                
        }

	private boolean isListsREqual(List<Integer> list1, List<Integer>list2)
	{
		if(list1.size()!=list2.size())
		{
			return false;
		}
		int i=0;
		while(i<list1.size())
		{ 
			if(list1.get(i) != list2.get(i))
			{
				return false;
			}
			i++;
		}
		return true;
	}
	
	//inner class used to insert nodes in Binary tree (not BST)
	private class BTree
	{
		Node root;
		
		BTree()
		{
			root=null;
		}
		
		// root's level=0; childLorR=1/2 for LeftChild/RightChild
		private boolean insertNode(int level, List<Integer> childLorR, int data)   
		{
			Node newNode=new Node(data);
			if(level==0)
			{
				root=newNode;
			}
			else
			{
				Node current=root;
				int i=0;
				while(i<level-1)
				{
					if(current==null)
					{
						return false;
					}
					int direction=childLorR.get(i);
					if(direction==1)
					{
						current=current.leftChild;
					}
					else
					{
						current=current.rightChild;
					}
					i++;
				}
				
				if(childLorR.get(level-1)==1)
				{
					current.leftChild=newNode;
				}
				else
				{
					current.rightChild=newNode;
				}
			}
			return true;
		}
	
		
		private void insertAllNodes()
		{
			List<Integer> list =new ArrayList<>();
			insertNode(0, null, 17);
			list.add(1);
			insertNode(1, list, 22);
			list.add(2);
			insertNode(2, list, 18);
			list.add(1);
                        insertNode(3, list, 19);
			//lefttree done
			list =new ArrayList<>();
			list.add(2);
			insertNode(1, list, 6);
			list.add(2);
			insertNode(2, list, 2);
			list.remove(1);//back to level 1
			list.add(1);
			insertNode(2, list, 14);
			list.add(2);
                        insertNode(3, list, 12);
			list.add(1);
                        insertNode(4, list, 13);
		}
	}
	
}
