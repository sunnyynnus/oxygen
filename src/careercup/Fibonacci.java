package careercup;

import java.util.Map; 
import java.util.HashMap;
/**
	Created on 11/6/2014
	Prob 8.1

*/

public class Fibonacci{


	public static void main(String[] args)
	{
		
		int n=2;
		System.out.println(n+"th fibonacci no. calculates rec = "+calculateNthFibRec(n));
		System.out.println(n+"th fibonacci no. calculated iter = "+calculateNthFibIter(n));
	}


	private static int calculateNthFibRec(int n)
	{
		if(n<0)
		{
			return n; // throw some exc
		}
		if(n==1)
		{
			return 1;
		}
		else if(n==0)
		{
			return 0;
		}
		else
		{
			Map<Integer, Integer> memoizeMap= new HashMap<>();
			if(memoizeMap.containsKey(n))
			{
				return memoizeMap.get(n);
			}
			else
			{
				Integer temp =calculateNthFibRec(n-1) + calculateNthFibRec(n-2);
				memoizeMap.put(n, temp);
				return temp;
			}
		}
	}
	
	private static int calculateNthFibIter(int n)
	{
		if(n<0)
		{
			return n; // throw some exc
		}
		
		int[] M=new int[n+1];
		M[0]=0;
		M[1]=1;
		
		for(int i=2;i<=n;i++)
		{
			M[i]=M[i-1]+M[i-2];
		}
		return M[n];
	}
}
