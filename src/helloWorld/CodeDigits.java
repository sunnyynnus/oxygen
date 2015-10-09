package helloWorld;

import java.util.*;

public class CodeDigits{
    static Map<Integer, String> map= new HashMap<>();
    
     public static void main(String []args){
         updateMap();
       Tree tree= new Tree();
       tree.root= new Node("");
       f(tree.root, "1134");
       printValues(tree.root);
        System.out.println();
       tree.root= new Node("");
       f(tree.root, "111");
       printValues(tree.root);
       System.out.println();
       tree.root= new Node("");
       f(tree.root, "26");
       printValues(tree.root);
       System.out.println();
       tree.root= new Node("");
       f(tree.root, "12");
       printValues(tree.root);
       System.out.println();
       
        tree.root= new Node("");
       f(tree.root, "10");
       printValues(tree.root);
       System.out.println();
       tree.root= new Node("");
       f(tree.root, "");
       printValues(tree.root);
       System.out.println();
       tree.root= new Node("");
       f(tree.root, "1221");
       printValues(tree.root);
       System.out.println();
     }
     
     private static void updateMap(){
         map.put(1, "a");
         map.put(2, "b");
         map.put(3, "c");
         map.put(4, "d");
         map.put(5, "e");
         map.put(6, "f");
         map.put(7, "g");
         map.put(8, "h");
         map.put(9, "i");
         map.put(10, "j");
         map.put(11, "k");
         map.put(12, "l");
         map.put(13, "m");
         map.put(14, "n");
         map.put(15, "o");
         map.put(16, "p");
         map.put(17, "q");
         map.put(18, "r");
         map.put(19, "s");
         map.put(20, "t");
         map.put(21, "u");
         map.put(22, "v");
         map.put(23, "w");
         map.put(24, "x");
         map.put(25, "y");
         map.put(26, "z");
     }
     
     public static void f(Node root, String str){
         if(str.length()==0){
             return;
         }
         String ch=map.get(str.charAt(0)-48);
         Node leftChild;
          if(ch!=null){
            leftChild=new Node(root.data+ch); 
          } else{
              leftChild=null;
          }
         
         Node rightChild;
         if(str.length()>=2){
             ch=map.get(Integer.valueOf(str.substring(0,2)));
             if(ch!=null){
                 rightChild=new Node(root.data+ch);
             } else{
                 rightChild=null;
             }
             
         } else{
             rightChild=null;
         }
         root.leftChild= leftChild;
         root.rightChild= rightChild;
         if(leftChild!=null){
             f(root.leftChild, str.substring(1, str.length()));
         }
         if(rightChild!=null){
            f(root.rightChild, str.substring(2, str.length()));
         }
     }
     
     public static void printValues(Node root){
         
         if(root==null){
             
             return;
         }
         if(root.leftChild==null && root.rightChild==null) {//leaf node
             System.out.print(root+" "); 
         }
         printValues(root.leftChild);
         printValues(root.rightChild);
     }
     
    static class Tree {

	    public Node root;

	    public Tree()
    	{
    		root=null;
    	}
    }
    
    static class Node {
	    public String data;
	    public Node leftChild;
	    public Node rightChild;
	  
	    public Node(String data)
	    {
		    this.data=data;
		    leftChild=null;
		    rightChild=null;
		
	    }
	
	public String toString()
	{
		return data;
	}
   }
}
