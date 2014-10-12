package helloWorld;

import java.util.Arrays;

public class RemoveDuplicateFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={2,2,2,2,4,4,4,3,88,3,4,88,8,9,22};
		
		int count=removeDuplicateKeys(a,a.length);
		System.out.println("count== "+count);
		displayArray(a, count);
		
		count=removeDuplicates(a, a.length);
		System.out.println("count== "+count);
		displayArray(a, count);
	
 }
	
	private static int removeDuplicateKeys(int a[],int size)
	{
		int count=0;
		int i=0;
		Arrays.sort(a);
		
			for(i=0;i<size-1;i++)
			{
				if(a[i]!=a[i+1])
				{
					a[++count]=a[i+1];
				}
				else
				{
					continue;
				}
			
			}
		
							
		return count+1;
	}

	private static void displayArray(int[] a, int size)
	{
		System.out.println("***********Display*******");
		for(int i=0;i<size;i++)
		 {
			System.out.println(a[i]);
		 }
	}
	
	private static int removeDuplicates(int[] a, int size)
	{
	    int count=0;
	    
	    
	        for(int i=1;i<size;i++)
	        {
	             if(!(isElementDuplicate(a, a[i], count)))
	             {
	             a[++count]=a[i];
	             }
	        }
	    return count+1;    
	}

	private static boolean isElementDuplicate(int[] a, int temp, int count)
	{
	    for(int i=0;i<=count;i++)
	    {
	        if(a[i]==temp)
	        {
	            return true;
	        }
	    }
	   return false;
	}
}
