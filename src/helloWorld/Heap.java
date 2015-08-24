package helloWorld;

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
    int size=5000000;
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
    heapify(H, i, 0);
  }
  
  private static void heapify(int[] H, int i, int size){
    if(i>0){
      size=(size==0) ? H.length-1 : size;
      int lchild=2*i;
      //if rchild exists
      if(lchild+1<=size){
        if(H[lchild]<H[lchild+1]){
          if(H[lchild]<H[i]){
            swap(H, lchild, i);
          }
        } else {
          if(H[lchild+1]<H[i]){
            swap(H, lchild+1, i);
           }
        }
      }
      //if lchild exists
      if(lchild<=size && H[lchild]<H[i]){
        swap(H, lchild, i);
      }
                                                                                                      
      if(i>1){
        heapify(H, i/2, size);
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
    int size= 5000000;
    int[] arr=new int[size];
    for(int i=1 ; i<size; i++) {
      arr[i]= (int)(Math.random()*mul);
      heapify(arr, i, i);
    }
    return arr;
                                                                      
  }
}

