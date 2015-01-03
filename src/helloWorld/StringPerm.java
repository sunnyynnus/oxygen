package helloWorld;

import java.util.Set;
import java.util.HashSet;

public class StringPerm{

    public static void main(String []args){
        
        String str="abcd"; 
        Set<String> set=permString(str);
        System.out.println(set);
    }
   /**
	input param- String
   	output param- all permutations of a string
	permutate strings
   **/ 
    private static Set<String> permString(String str)
    {
        Set<String> set=new HashSet<>();
        char arr[]=str.toCharArray();
        permStringRec(0, arr, set); 
        return set;
    }
    
    private static void permStringRec(int i, char[] arr, Set<String> set)
    {
        if(i==arr.length-1)
        {
            String temp=new String(arr);
            set.add(temp);
            return;
        }
        
	
        for(int j=i; j<arr.length; j++)
        {
            swap(i, j, arr);
            permStringRec(i+1, arr, set);
            swap(i, j, arr);
           // permStringRec(i+1, arr, set); will be needed if j=i+1
        }
    }
    
    private static void swap(int i, int j, char[] arr)
    {
        char ch=arr[i];
        arr[i]=arr[j];
        arr[j]=ch;
    }
}

