package helloWorld;

public class MergeSortApp {

	private static int[] a=new int[10];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
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
}//class
