package careercup;

public class BitsChangeInIntConv{

	BitsChangeInIntConv(){}

	public static void main(String[] args)
	{
	
		//System.out.println("7<-->0 will require to change "+bitsChangeReq(7,0) +" bits");
		swapOddEvenBits(53);
	
	}	

	private static int bitsChangeReq(int num1, int num2)
	{
		int count=0;
		int temp= num1^num2;
		
		for(; temp!=0; temp=temp>>2)
		{
			if(temp %2 !=0) // similar to temp&1!=0
			{
				count++;
			}
			
		}
		return count;
	}

	private static void swapOddEvenBits(int num)
	{
		//int count= Integer.bitCount(num);
		System.out.println("Initial sequence:-  "+Integer.toBinaryString(num));
		num= ((num & 0xAAAAAAAA) >>1) | ((num & 0x55555555)<<1);
		System.out.println("sequence after swap:-  "+Integer.toBinaryString(num));
		
	}
}
