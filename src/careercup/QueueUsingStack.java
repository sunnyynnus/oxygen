package careercup;

import java.util.ArrayList;
import java.util.Stack;

public class QueueUsingStack {
	Stack<Integer> s1=new Stack<Integer>();
	Stack<Integer> s2=new Stack<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		QueueUsingStack q= new QueueUsingStack();
		System.out.println(q.removeItem());
		q.insertItem(24);
		q.insertItem(34);
		q.insertItem(44);
		q.insertItem(54);
		System.out.println(q.removeItem());
		System.out.println(q.removeItem());
		q.insertItem(64);
		q.insertItem(74);
		System.out.println(q.removeItem());
		System.out.println(q.removeItem());
		System.out.println(q.removeItem());
		

	}
	public void insertItem(int item)
	{
	    s1.push(item);

	}

	public int removeItem()
	{
	   if(1==1) return efficientRemoveItem();
		int item=-123456;
	    while(!(s1.empty()))
	    {
	        s2.push(s1.pop());
	    }
	    
	    if(!(s2.isEmpty()))
	    {
	    	item=s2.pop();
	    }
	    
	     while(!(s2.empty()))
	    {
	        s1.push(s2.pop());
	    }
	    
	    return item; 
	        
	}
	
	public int efficientRemoveItem()
	{
		
		
		if(!s2.isEmpty())
		{
			return s2.pop();
		}
		
		while(!s1.isEmpty())
		{
			s2.push(s1.pop());
			
		}
		if(!s2.empty())
		{
			return s2.pop();
		}
		return -123456789;
		
	}
	

}
