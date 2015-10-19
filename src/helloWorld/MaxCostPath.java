package helloWorld;

import java.util.*;

public class MaxCostPath{
  
  public static void main(String []args){
    Tree tree= new Tree();
    tree.insertNodes();
    List<List<Node>> megaList = getMaxCostPath(tree.root);
    for(List<Node> temp : megaList)
      System.out.println(temp);
  }
  public static List<List<Node>> getMaxCostPath(Node root){
    List<List<Node>> megaList = new ArrayList<>();
    List<Node> list= new ArrayList<>();
    getMaxCostPath(root, megaList, list, 0, new Int());
    return megaList;
  }

  private static void getMaxCostPath(Node node, List<List<Node>> megaList, List<Node> list, int maxSum, Int listSum){
    if(node==null){
      return;
    }
    list.add(node);
    maxSum+= node.data;
    if(node.leftChild==null && node.rightChild==null){
      if(megaList.isEmpty()){
        List<Node> tempList= new ArrayList<>();
        tempList.addAll(list);
        megaList.add(tempList);
        listSum.sum= maxSum;
        } else{
        if(listSum.sum<maxSum){
          megaList.clear();
          List<Node> tempList= new ArrayList<>();
          tempList.addAll(list);
          megaList.add(tempList);
          listSum.sum= maxSum;                       
        } else if(listSum.sum==maxSum){
          List<Node> tempList= new ArrayList<>();
          tempList.addAll(list);
          megaList.add(tempList);
        }
      }
        list.remove(list.size()-1);
        return;
     }
     getMaxCostPath(node.leftChild, megaList, list, maxSum, listSum);
     getMaxCostPath(node.rightChild, megaList, list, maxSum, listSum);
     list.remove(node); 
     //maxSum-= node.data;                                                                                                                                                                                                                                 
  }

  static class Int{
      int sum;
  }
}
