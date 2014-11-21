package careercup;
/**
8.5
11/20

**/
public class ParenthesisApp
{

	public static void main(String[] args)
	{
		int count=4;
		char[] arr=new char[count*2];
		showParaenthesisRec(count, count, arr, 0);
	}

	private static void showParaenthesisRec(int op, int cl, char[] str, int index)
	{
		if(op<0 || cl< op)
		{
			return;
		}
	
		if(op==0 && cl==op)
		{
			System.out.println(str);
		}
		
		if(op>0)
		{
			str[index]='(';
			showParaenthesisRec(op-1, cl, str, index+1);
		}
		
		if(cl>op)
		{
			str[index]=')';
			showParaenthesisRec(op, cl-1, str, index+1);
		}
	
	}

}

