package zillo.app;

/**
@author: Sunny
Created on 12/4/2014

**/

public class StringUtil
{
	
	/**
	 @ input string
	 @return corresponding long value	
	**/
	long stringToLong(String str)
	{
		long longVal=0;
		
		//if null - return 0 .. one may want to throw some exception.. or this condition may be checked before calling
		if(str!=null)
		{
			int sign=1;
								
			//taking care of sign
			if(str.charAt(0)=='-')
			{
				sign=-1;
				str=str.substring(1);
			}
			else if(str.charAt(0)=='+')
			{
				str=str.substring(1);
			}
			if(str.matches("[0-9]+"))
			{
				int length=str.length();
				for(int i=0;i<length;i++)
				{
					char ch=str.charAt(i);
					longVal=((long)ch-48)+longVal;	// (long)'0' =48;
					
					if(i<length-1)
					{
						longVal*=10;
					}
				}
						
				longVal*=sign;  
			}
		}
	
		return longVal;
	}

	/**
		test method
	**/
	void test()
	{
		long i=stringToLong("123");
		if(i==123)
		{
			System.out.println("success");
		}
		else
		{
			System.out.println("failure");
		}
	}
}
