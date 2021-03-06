package helloWorld;

public class CountInversions
{

	public static void main(String[] args)
	{
		System.out.println("Inverted Pairs \n");
		int arr[]={8, 1, 5, 3, 2, 7, 4};
		System.out.println("Total count= "+countInversions(arr));
		System.out.println("**sorted list as by-product**");
		for(int i :arr)
		{
			System.out.println(i);
		}
	}

  public static int countInversions(int[] arr){
    int scratch[]=new int[arr.length];
    return countInversionsRec(arr, scratch, 0,arr.length-1);
  }

	private static int countInversionsRec(int[] arr, int scratch[], int start, int end)
	{
		int count=0;
		if(start>=end)
		{
			return 0;
		}
		int mid= start+(end-start)/2;
		count+=countInversionsRec(arr, scratch, start, mid);
		count+=countInversionsRec(arr, scratch,  mid+1, end);
		count+=mergeAndCount(arr, scratch, start, mid, end);
		return count;
	}

	private static int mergeAndCount(int[] arr, int scratch[], int start1, int mid, int end)
	{
		int start2=mid+1, start=start1;
		//int scratch[]=new int[end+1]; less efficient
		int count=0, ptr=0;
		while(start1<=mid && start2<=end)
		{
			if(arr[start1]<=arr[start2])
			{
				scratch[ptr++]=arr[start1++];
			
			}
			else
			{
				count+=mid-start1+1;
				scratch[ptr++]=arr[start2++];
        for(int i=start1; i<=mid;i++)
				{
					System.out.println("("+arr[i]+","+arr[start2-1]+")");	
				}
			}
			
		}
		
		while(start1<=mid)
		{
			scratch[ptr++]=arr[start1++];
		}
		
		while(start2<=end)
		{
			scratch[ptr++]=arr[start2++];
		}
		
		for(int i=0;i<ptr;i++)
		{
			arr[start+i]=scratch[i];
		}
		return count;
	}
}
