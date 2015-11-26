package helloWorld;

/**
 *Max heap
 * 
 * **/
public class Heap{

  public static void main(String []args){
    long t1=System.currentTimeMillis(); 
    int[] A =generateRandomData();
    createHeapBottomUp(A);
    long t2=System.currentTimeMillis(); 
                                               
    int[] B= createHeapTopDown();
    long t3=System.currentTimeMillis(); 
                                                                 
    System.out.println("bottom-up time ::" + (t2-t1));
    System.out.println("top-down time::" + (t3-t2));
    printHeap(A, 4);
  }
            
  private static int[] generateRandomData(){
                       
    Double mul=new Double(10000000);
    int size=10000000;
    int[] arr=new int[size];
    for(int i=1 ; i<size; i++){
      arr[i]= (int)(Math.random()*mul);
    }
    return arr;
  }
                 
  private static void createHeapBottomUp(int[] H){
                            
    int size=H.length-1;
    for(int i=size/2; i>0; i--){
      heapify(H, i);
    }
  }
  
  private static void heapify(int[] H, int i){
    if(i>0){
      int largest=i;
      int lChild=2*i;
      int size = H.length-1;
      //if lchild exists
      if(lChild<=size && H[largest]<H[lChild]){
        largest = lChild;
      }
      //if rchild exists
      if(lChild+1<=size && H[largest]<H[lChild+1]){
        largest= lChild+1;
      }
      if(i!=largest){
        swap(H, largest, i);
        heapify(H, largest);
      }
    }
                                               
  }
                                
  private static void swap(int[] A, int i , int j){
    int temp=A[i];
    A[i]= A[j];
    A[j]=temp;
  }
                                     
  private static int[] createHeapTopDown(){
    Double mul=new Double(10000000);
    int size= 10000000;
    int[] arr=new int[size];
    for(int i=1 ; i<size; i++) {
      arr[i]= (int)(Math.random()*mul);
      heapify(arr, i);
    }
    return arr;
                                                                      
  }

  //root at level 1 ; root index is 1
  //expecting full BT
  private static void printHeap(int[] arr, int level){
    if(level<0) {
      return;
    }
    if(Math.pow(2, level+1)> arr.length){
      level=(int)Math.log(arr.length);
    }
    for(int i=0; i<level; i++){
      int base= (int)Math.pow(2, i);
      for(int j=base; j<Math.pow(2, i+1); j++){
        System.out.print(arr[j]+" ");
      }
      System.out.println();
    }
  }
}

