package careercup;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
    11/9
	8.4
*/
public class PermutateString
{
	public static void main(String[] args)
	{
		List<String> list=permutateStringChars("aacc");
		removeDuplicateEntries(list);
		displayList(list);
		System.out.println("total perms:" + list.size());
	}

	private static List<String> permutateStringChars(String str)
	{
		List<String> finalList= new ArrayList<>();
		if(str.length()==1)
		{
			List<String> list=new ArrayList<>();
			list.add(str);
			return list;
		}
		
		char ch= str.charAt(0);
		
		List<String> tempList=permutateStringChars(str.substring(1));
		
		List<StringBuilder> newList= new ArrayList<>();
		
		for(String newStr :tempList)
		{
			for(int i=0;i<=newStr.length(); i++)
			{
				insertCharInString(newList, ch, new StringBuilder(newStr), i);	
			}
		}	
	
		for(StringBuilder tempStrB :newList)
		{
			finalList.add(tempStrB.toString());
		}
		return finalList;
	}

	
	private static void insertCharInString(List<StringBuilder> newList, char ch, StringBuilder newStr, int index)
	{
		newList.add(newStr.insert(index,ch));
	}
	
	
	private static void removeDuplicateEntries(List<String> list)
	{
		int size= list.size();
		String[] strings=new String[size];
		strings=list.toArray(strings);
		Arrays.sort(strings);
		
		for(int i=0;i<size-1;i++)
		{
			if(strings[i].equals(strings[i+1]))
			{
				deleteInList(list, (strings[i]));
			}
		}
	}

	private static void deleteInList(List<String> list, String str)
	{
		list.remove(list.indexOf(str));
	}

	private static void displayList(List<String> list)
	{
		for(String s:list)
		{
			System.out.println(s);
		}
	}
}
