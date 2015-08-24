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
                                                                 
    System.out.println(t2-t1);
    System.out.println(t3-t2);
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
      //if rchild exists
      if(lChild+1<=size){
        if(H[lChild]<H[lChild+1]){
          if(H[lChild]<H[i]){
            largest = lChild+1;
          }
        } else {
          if(H[lChild+1]<H[i]){
            largest = lChild;
           }
        }
      }
      //if lchild exists
      if(lChild<=size && H[lChild]<H[i]){
        largest= lChild;
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
}

