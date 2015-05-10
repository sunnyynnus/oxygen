package helloWorld;

/**
	11/11
	Efficient Q Sort
*/

public class QSort{
	
	private static int size=1000000;
	private static int arr[]= new int[size];
	
	public static void main(String[] args)
	{
		Double mul=new Double(10*size);
		int newarr[]=new int[size];
		for(int i=0 ; i<size; i++)
		{
			arr[i]= (int)(Math.random()*mul);	
      //arr[i]= i;
      newarr[i] = arr[i];
		}
	
    long t1= System.currentTimeMillis();
		qSort();
	  long t2= System.currentTimeMillis();
		System.out.println("***********");
		for(int i :arr)
      System.out.println(i);

    long t3= System.currentTimeMillis();
    randomQSort(newarr);
    long t4= System.currentTimeMillis();
    System.out.println("******Random Q Sort *****");
    for(int i :newarr)
      System.out.println(i);

    System.out.println("Time taken by normal qsort= "+(t2-t1)+"\n"+"Time taken by randomized qsort= "+(t4-t3));
	}

	private static void qSort()
	{
		qSortRec(0, size-1);
	}

/**
 * randomQSort  using   pseudo-Random generator
 */
  private static void randomQSort(int[] arr){
    randomQSortRec(arr, 0, arr.length-1);
  }
	
	private static void qSortRec(int start, int end)
	{
		size=end-start+1;
		if(size<10) // as per Sedgewick 
		{
			insSort(start, end);
			return;
		}
		
		int pivot=medianOf3(start, end, size);
		int mid= partition(start, end, pivot); // new index of pivot
		qSortRec(start, mid);
		qSortRec(mid+1, end);
		return;
	
	}

	private static int medianOf3(int start, int end, int size)
	{
		int mid=start+(end-start)/2;
		if(arr[start]>arr[mid])
		{
			swap(start, mid);
		}
		if(arr[start]>arr[end])
		{
			swap(start, end);
		}
		if(arr[mid]>arr[end])
		{
			swap(mid, end);
		}
		swap(mid,end);
		
		return arr[end];
	}
	
	private static void swap(int ptr1, int ptr2)
	{
		int temp=arr[ptr1];
		arr[ptr1]= arr[ptr2];
		arr[ptr2]= temp;
	}

  private static void swap(int[] arr, int ptr1, int ptr2){
  
    int temp=arr[ptr1];
    arr[ptr1]= arr[ptr2];
    arr[ptr2]= temp;

  }

	private static int partition(int start, int end, int pivot)
	{
		int sptr= start;
		int eptr= end;
		
		while(true)
		{
			while(arr[++sptr]<pivot);
			
			while(arr[--eptr]>pivot);
			
			if(sptr<eptr)
			{
				swap(sptr, eptr);
			}
			else
			{
				break;
			}
		}
		swap(sptr, end);
		return sptr;
	}

	private static void insSort(int start, int end)
	{
		for(int i=start+1; i<= end; i++)
		{
			int j=i;
			int temp= arr[j];
			while(j>start)
			{
				if(arr[j-1]>temp)
				{
					arr[j]=arr[j-1];
					j--;
				}
				else
				{
					break;
				}
			}
			arr[j]=temp;
		}
		
	}

  /**
   *  Random quick sort using pseudo-random no. generator
   */
  private static void randomQSortRec(int[] arr, int start, int end)
  {
    size=end-start+1;
    if(size<=1){
      return;
    }
    int pivot= findPivotRandom(arr, start, end, size);
    int mid= partition(arr, start, end, pivot); // new index of pivot
    randomQSortRec(arr, start, mid);
    randomQSortRec(arr, mid+1, end);
    return;

  }

  private static int findPivotRandom(int[] arr, int start, int end, int size){
    
    int pos= start+(int)(Math.random()*size); 
    swap(arr, pos, end);
    return arr[end];
  }

  private static int partition(int[] arr, int start, int end, int pivot)
  {
     int sptr= start-1;
     int eptr= end;
       
     while(true){
       while(arr[++sptr]<pivot);
             
       while(--eptr>0 && arr[eptr]>pivot);
                  
       if(sptr<eptr){
                     
         swap(arr, sptr, eptr);
       }
       else{
         break;
       }
     }
     swap(arr, sptr, end);
     return sptr;
  }
}
