package helloWorld;

/**
	12/20
	no. of elements in largest increasing subsequence

	DP with memoization - O(n^2)
**/
public class SubsequenceApp
{

	private static int seq[]={1, 9, 5, 6, 2, 3, 4};
	private static int seqlen= seq.length;
	private static int M[]= new int[seqlen];
	
	public static void main(String[] args)
	{
		for(int i=0; i<seqlen; i++)
		{
			M[i]= getCountOfLongestIncSeqIncludingI(i);
		}

		System.out.println("no. of elements in largest increasing subsequence= "+ getMaxInArr(M));
			

	}
	
	private static int getMaxInArr(int[] arr)
	{
		int temp=0;
		for(int i=0; i<arr.length; i++)
		{
			temp=max(arr[i], temp);
		}
		return temp;
	}

	private static int getCountOfLongestIncSeqIncludingI(int i)
	{
		if(i==0)
		{
			return 1;
		}
	
		if(M[i] !=0)
		{
			return M[i];
		}
		
		int count=1;
		
		for(int j=0; j<i; j++)
		{
			int temp=0;

			if(seq[i]>seq[j])
			{
				temp=M[j]+1;
			}
			else
			{
				temp=0;
			}
			count=max(temp, count);
		}
		
		return count;
	}
	
	/**
		return greater of val1 & val2
	**/
	private static int max(int val1, int val2)
	{
		return (val1>val2 ? val1 :val2);
	}

}
