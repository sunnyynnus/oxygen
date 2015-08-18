package helloWorld;

public class MergeSortApp {

	private static int[] a=new int[10];
	public static void main(String[] args) {
		
		for(int i=0;i<10;i++)
		{
		a[i]=(new Double(Math.random()*100)).intValue();	
		}//for
		
		int temp[]=new int[10];
		
		recMergeSort(temp,0,a.length-1);
		
		printArray();
		
	}//psvm

	public static void recMergeSort(int[] temp,int low, int high)
	{
		if(low==high)
			return;
		int mid=low+(high-low)/2;
		
		recMergeSort(temp,low,mid);
		recMergeSort(temp,mid+1,high);
		
		merge(temp,low,mid,high);
	}//recMergeSort
	
	
	public static void merge(int[] temp,int low,int mid,int high)
	{
		int j=0, lowPtr=low, highPtr=mid+1,n=high-low+1;
	while(lowPtr<=mid && highPtr<=high)
	{
		if(a[lowPtr]<a[highPtr])
			temp[j++]=a[lowPtr++];
		else
			temp[j++]=a[highPtr++];
	}//while	
	
	while(lowPtr<=mid)
		temp[j++]=a[lowPtr++];
	

	while(highPtr<=high)
		temp[j++]=a[highPtr++];
		
	for(int i=0;i<n;i++)
		a[low+i]=temp[i];
	}
	
	public static void printArray()
	{
		System.out.println("******************");
	for(int i : a)
	{
		System.out.println(i);
	}//for
		
	}

  //linlist mergesort
  public static Link mergeSort(Link first){
             
    if(first==null){
      return null;
    }
    if(first.next==null){
      return first;
    }
    Link mid = findMid(first);
                                        
    Link l1 = mergeSort(first);
    Link l2= mergeSort(mid);
    return merge(l1, l2);
  }
       
  private static Link findMid(Link first){
    Link current = first.next;
    Link mid =first.next;
    Link temp = first;
    while(current!=null && current.next!=null){
      current= current.next.next;
      temp =mid;
      mid = mid.next;
    }         
    temp.next =null;
    return mid;
  }
            
  private static Link merge(Link l1, Link l2){
    if(l1==null && l2==null){
      return null;
    } 
    if(l1==null){
      return l2; 
    }
    if(l2==null){
      return l1;
    }
    Link firstS = new Link();
    Link current =firstS; 
    while(l1!=null && l2!=null){
      if(l1.num<l2.num){
        current.next=l1;
        l1 =l1.next;
      } else{
                                                                                                                                                  current.next =l2;
                                                                                                                                                  l2= l2.next;
                                                                                                                                                  }
      current= current.next;
    }
    if(l1!=null){
      current.next=l1;
    } else if(l2!=null){
      current.next =l2;
    }
    current = firstS.next;
    firstS.next= null;
    return current;
    }

}//class
