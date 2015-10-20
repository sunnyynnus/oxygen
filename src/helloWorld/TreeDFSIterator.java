package helloWorld;
import java.util.*;

public class TreeDFSIterator{

     public static void main(String []args){
        Tree<Integer> tree= new Tree<>();
        insertNodes(tree);

        for(Integer node:tree)
             System.out.println(node);
     }
     
  public static void insertNodes(Tree<Integer> tree){
		tree.addNode(50);
		tree.addNode(40);
		tree.addNode(60);
		tree.addNode(30);
		tree.addNode(70);
		tree.addNode(65);
		tree.addNode(20);
		tree.addNode(35);
	}
}


class PostOrderTreeIterator<T extends Comparable<T>> implements Iterator<T>{
    Deque<Node<T>> stack = new ArrayDeque<>();
    Set<Node<T>> visitedSet= new HashSet<>();
    
    public  PostOrderTreeIterator(Node<T> node){
        while(node!=null){
            stack.push(node);
            node= node.leftChild;
        }
    }
    
    public T next(){
        Node<T> node= stack.peek();
        if(node==null){
            throw new NoSuchElementException();
        }
        while(node.rightChild!=null){
            Node<T> parentNode= null;
            node=node.rightChild;
            if(visitedSet.contains(node)){
                    break;
            }
            while(node!=null){
                stack.push(node);
                parentNode=node;
                node=node.leftChild;
            }
            node=parentNode;
        }
        node= stack.pop();
        visitedSet.add(node);
        return node.data; //mutable
    }
    
    public boolean hasNext(){
        return stack.size()>0;
    }
}

class Tree<T extends Comparable<T>> implements Iterable<T>{

	public Node<T> root;
	public <T> Tree(){
		root=null;
	}
	
	public boolean isEmpty(){
		return root==null;	
	}
	
	public void addNode(T data){
		Node<T> newNode=new Node<>(data);
		if(isEmpty()){
			root=newNode;
		}	else{
			Node<T> current=root;
			Node<T> previous=null;
			while(current!=null){
				previous=current;
				if(data.compareTo(current.data)<0){
					current=current.leftChild;
        }	else{
					current=current.rightChild;
        }
			}//while
			if(data.compareTo(previous.data)<0){
				previous.leftChild=newNode;
			} else{
				previous.rightChild=newNode;
			}
		}//else
	}//addnode
	
	public Iterator<T> iterator(){
	     return new PostOrderTreeIterator<>(root);
	}
}

class Node<T extends Comparable<T>> {
	public T data;
	public Node<T> leftChild;
	public Node<T> rightChild;
	
	public Node(T data){
		this.data=data;
		leftChild=null;
		rightChild=null;
	}
	
	public String toString(){
  	return String.valueOf(data);
	}
}
