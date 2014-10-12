package helloWorld;

public class CheckAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(anagram("sunny","ynnsu"));
		 
	}


public static boolean anagram(String s, String t) {

	if(s.length()!=t.length()) return false;
	
	int[] arr=new int[256];
	int uniqueInS=0, uniqueInT=0;
	char[] sArray=new char[s.length()];
			s.getChars(0, s.length(), sArray, 0);
			
	for(char c:sArray)
	{
		if(arr[c]==0) uniqueInS++;
		
		arr[c]++;
	}
	
	for(int i=0;i<t.length();i++)
	{
		char temp=t.charAt(i);
		if(arr[temp]==0) 
		 {
			
			return false;
			}
		arr[temp]--;
		if(arr[temp]==0) uniqueInT++;
		if(uniqueInT==uniqueInS)
			return true;
	}
	
	return false;
 }


}