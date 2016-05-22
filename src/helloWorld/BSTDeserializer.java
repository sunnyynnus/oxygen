package helloWorld;

public class BSTDeserializer{

     public static void main(String []args){
        int arr[]= {10, 5, 1, 7, 40, 50};
        BSTDeserializer hw= new BSTDeserializer();
        Node root= hw.deserialize(arr);
        hw.inorder(root);

        root= hw.deserializeBST(arr);
        hw.inorder(root);
     }
     
     public Node deserialize(int[] arr){
        return deserialize(arr, 0, arr.length-1);
     }
     
     private Node deserialize(int[] arr, int s, int e){
         if(s>e){
             return null;
         }
         if(e==s){
             return new Node(arr[e]);
         }
         
         Node root=new Node(arr[s]);
         int i=s+1;
         for(; i<=e; i++){
             if(arr[i]> arr[s]){
                 break;
             }
         }
         root.leftChild= deserialize(arr, s+1, i-1);
         root.rightChild= deserialize(arr, i, e);
         return root;
     }
     
     public void inorder(Node root){
         if(root==null){
             return;
         }
         inorder(root.leftChild);
         System.out.println(root.data);
         inorder(root.rightChild);
     }
     
     static class Node{
         int data;
         Node leftChild;
         Node rightChild;
         public Node(int data){
             this.data= data;
         }
     }

     public Node deserializeBST(int[] arr){
        return deserialize(arr, new Int(0), Integer.MIN_VALUE, Integer.MAX_VALUE);
     }
     static class Int{
         int i;
         public Int(int i){
             this.i=i;
         }
     }
     private Node deserialize(int[] arr, Int i, int min, int max){
         if(i.i>=arr.length){
             return null;
         }
         Node root=null;
         if(arr[i.i]>=min && arr[i.i] <=max){
             root=new Node(arr[i.i]);
            if(i.i<arr.length){
                i.i+=1;
                root.leftChild= deserialize(arr, i, min, root.data);
                root.rightChild= deserialize(arr, i, root.data, max);
            }
         }
         
         return root;
     }
}
