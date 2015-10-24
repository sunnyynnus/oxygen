package careercup;

import helloWorld.Node;
import helloWorld.Tree;

public class TreeDiameter{
  
  public static void main(String[] args){
  	Tree tree= new Tree();
  	tree.insertNodes();
		System.out.println(getD(tree.root));
  }

	public static int getD(Node root){
         Count maxCount= new Count(0, 0);
         getD(root, maxCount);
         return Math.max(maxCount.sumC, maxCount.maxC);
  }
  /**
   *  every node contains Count- sumC = sum of max path count of both child +1
   *                             maxC= max of max path count of both child +1
  **/
   //Count = sumC, maxC
  private static Count getD(Node root, Count maxCount){
    // base cases
    if(root==null){
      return new Count(0, 0);
    }
    // leaf node will have both values =1
    if(root.leftChild==null && root.rightChild==null){
      Count count= new Count(1, 1);
      if(maxCount.compareTo(count)<0 ){
      // update maxCount
        maxCount.copy(count);
      }
      return count;
    }

    Count leftC= getD(root.leftChild, maxCount);
    Count rightC= getD(root.rightChild, maxCount);
    int sumC= leftC.maxC+rightC.maxC+1;
    int maxC= Math.max(leftC.maxC, rightC.maxC)+1;
    Count count= new Count(sumC, maxC);
    if(maxCount.compareTo(count) <0 ){
      // update maxCount
      maxCount.copy(count);
    }
      return count;
    }
     
  
  static class Count implements Comparable<Count>{
    int sumC; // lChild+ rChild+1
    int maxC;// max(lChild, rChild)+1
         
    public Count(int sumC, int maxC){
      this.sumC= sumC;
      this.maxC= maxC;
    }
         
    public int compareTo(Count count){
      return Integer.compare(Math.max(sumC, maxC), Math.max(count.sumC, count.maxC));
    }
         
    public void copy(Count count){
      this.sumC= count.sumC;
      this.maxC= count.maxC;
    }
  }
}
