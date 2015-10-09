package helloWorld;

import java.util.*;
public class IterateTree{

     public static void main(String []args){
         Tree<Integer> tree= new Tree<>();
         insertNodes(tree);
         Link<Node> head= getListHead(tree.root);
          iterateList(head);
     }
     
     public static void insertNodes(Tree<Integer> tree)
	{
		tree.addNode(50);
		tree.addNode(40);
		tree.addNode(60);
		tree.addNode(30);
		tree.addNode(70);
		tree.addNode(65);
		tree.addNode(20);
		tree.addNode(35);
	
	}
     
     public static void iterateList(Link<Node> head){
         Link<Node> current= head;
         System.out.println(current);
         current=current.next;
         while(current!=null && current!=head){
             System.out.println(current);
             current=current.next;
         }
     }
     
     public static Link<Node> getListHead(Node node){
         List<Node> list= new List<>();
         inOrder(node, list);
         return list.first;
     }
     
     
     public static void inOrder(Node node, List<Node> list){
         if(node==null){
             return;
         }
         inOrder(node.leftChild, list);
         list.add(node);
         inOrder(node.rightChild, list);
     }
     
     static class List<E>{
         Link<E> first;
         Link<E> last;
         public List(){
             first=null;
             last=null;
         }
         public boolean isEmpty(){
             return first==null;
         }
         
         public void add(Node node){
             Link<E> newLink= new Link<>(node);
             if(isEmpty()){
                 first= newLink;
                 last= newLink;
             }
             last.next= newLink;
             newLink.previous= last;
             newLink.next= first;
             first.previous=newLink;
             last= newLink;
         }
  
     }
     
     static class Link<E>{
         Node node;
         Link<E> next;
         Link<E> previous;
         public Link(Node node){
             this.node= node;
             next=null;
             previous=null;
         }
         
         public String toString(){
             return node.toString();
         }
     }
}

class Tree<T extends Comparable<T>>{

	public Node<T> root;
	int count=0;
	public <T> Tree()
	{
		root=null;
	}
	
	public boolean isEmpty()
	{
		return root==null;	
	}
	
	public void addNode(T data)
	{
		Node<T> newNode=new Node<>(data);
		if(isEmpty())
		{
			root=newNode;
		}
		else
		{
			Node<T> current=root;
			Node<T> previous=null;
			while(current!=null)
			{
				previous=current;
				if(data.compareTo(current.data)<0)
					current=current.leftChild;
				else
					current=current.rightChild;
			}//while
			if(data.compareTo(previous.data)<0)
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


}

class Node<T extends Comparable<T>> {
	public T data;
	public Node<T> leftChild;
	public Node<T> rightChild;
	public Node<T> parent;
	
	public Node(T data)
	{
		this.data=data;
		leftChild=null;
		rightChild=null;
		parent=null;
	}
	
	
	public String toString()
	{
		return String.valueOf(data);
	}
}
