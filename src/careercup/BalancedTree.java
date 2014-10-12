/**
 * 
 */
package careercup;
import helloWorld.Node;
import helloWorld.Tree;


/**
 * @author sunny
 * 1. Implement a function to check if a tree is balanced
 * 2. Given a sorted (increasing order) array,  
 * 	an algorithm to create a binary tree with minimal height
 */
public class BalancedTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BalancedTree().AddTreeNodes();
		
	}

	private void checkBalaced()
	{
		Tree tree=new Tree();
		tree.insertNodes();

		//tree.inOrderTraversal();
		System.out.println(new BalancedTree().isBalanced(tree.root));
	}
	
	private void checkBalaced(Tree tree)
	{
		
		System.out.println(isBalanced(tree.root));
	}
	
	/**
	 *  Need modifications
	 * @param root
	 * @return
	 */
	private boolean isBalanced(Node root)
	{
		int max=maxDepth(root);
		int min=minDepth(root);
		System.out.println("max= "+max +" \tmin= "+min);
	    return ((max-min)<=1);
	}

	private int maxDepth(Node root)
	{
	    if(root==null)
	    {
	        return 0;
	    }
	    return 1+Math.max(maxDepth(root.leftChild), maxDepth(root.rightChild));
	}

	private int minDepth(Node root)
	{
	    if(root==null)
	    {
	        return 0;
	    }
	    return 1+Math.min(minDepth(root.leftChild), minDepth(root.rightChild));
	}
	

	private void RecAddTreeNodes(Tree t, int[] sortedArray, int start, int end)
	{
		int mid=start+(end-start)/2;
		if(mid<0 || mid>=end)
		{
			return;
		}
		t.addNode(sortedArray[mid]);
		RecAddTreeNodes(t, sortedArray, start, mid);
		RecAddTreeNodes(t, sortedArray, mid+1, end);
    
	}

	private void AddTreeNodes()
	{
		int[] sortedArray={1,2,3,4,5};
		Tree tree= new Tree();
		RecAddTreeNodes(tree, sortedArray, 0 , sortedArray.length);
		//tree.inOrderTraversal();
		checkBalaced(tree);
	}
}

		