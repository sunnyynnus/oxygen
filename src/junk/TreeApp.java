package TreeEx;

public class TreeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree tree=new Tree();
		tree.addNode(50);
		tree.addNode(40);
		tree.addNode(60);
		tree.addNode(30);
		tree.addNode(70);
		tree.addNode(65);
		tree.addNode(20);
		tree.addNode(35);

		tree.inOrderTraversal();
		tree.preOrderTraversal();
		tree.postOrderTraversal();
		//tree.searchNode(104);
		/*tree.deleteNode(5);
		tree.deleteNode(400);
		tree.deleteNode(30);
		tree.deleteNode(20);*/
		//tree.inOrderTraversal();
	}

}
