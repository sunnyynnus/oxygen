package helloWorld;
public class KadaneAlgo
{
	public static void main(String[] args)
	{
		int[] a={-4,-3,40,-10,-14,-1};
		naiveMaxSubSet(a, a.length);
		kadaneMaxSubset(a, a.length);
		minSubset(a, a.length);
	}
	
	private static void naiveMaxSubSet(int[] a, int n)
	{
		int temp=0;
		int sum=a[0];
		int start=0, end=0;
		for(int i=0;i<n;i++)
		{
			temp=a[i];
			for(int j=i+1;j<=n;j++)
			{
						
				if(temp>sum)
				{
					sum=temp;
					start=i;
					end=j-1;
				}
				if(j<n)
				{
					temp +=a[j];
				}
			}
		}
		
		System.out.println("sum= "+sum+" startindex= "+start+" endindex= "+end);
	}
	
	private static void kadaneMaxSubset(int[] a, int n)
	{
		int temp_sum=a[0];
		int tot_sum=a[0];
		int i, start=0, end=0;
		for(i=1;i<n;i++)
		{
			//temp_sum=max(temp_sum+a[i], a[i]);
			if(temp_sum>0)
			{
				temp_sum+=a[i];
			}
			else
			{
				temp_sum=a[i];
				start =i;
			}
			//tot_sum=max(tot_sum, temp_sum);
			if(tot_sum<temp_sum)
			{
				tot_sum=temp_sum;
				end=i;
			}
		}
		System.out.println("sum= "+tot_sum+" startindex= "+start+" endindex= "+end);
	}

	private static int max(int a, int b)
	{
		return (a>b?a:b);
	}

	private static void minSubset(int[] a, int n)
	{
		int temp_sum=a[0], tot_sum=a[0];
		int start=0, end=0;
		
		for(int i=1;i<n;i++)
		{
			if(temp_sum<0)
			{
				temp_sum+=a[i];
			}
			else
			{
				temp_sum=a[i];
				start=i;
			}
			if(tot_sum>temp_sum)
			{
				tot_sum=temp_sum;
				end =i;
			}
		}
		System.out.println("min sum= "+tot_sum+" startindex= "+start+" endindex= "+end);
	}
}
