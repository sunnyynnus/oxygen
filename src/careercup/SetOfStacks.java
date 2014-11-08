/**
 * 
 */
package careercup;

import java.util.ArrayList;

/**
 * @author sunny
 *
 */
public class SetOfStacks {

	 ArrayList<MyStack> stacks= new ArrayList<MyStack>();
	    MyStack newStack=new MyStack();
	    public SetOfStacks()
	    {
	      stacks.add(newStack);
	    }

	    public void push(int item )
	    {
	        if(!(newStack.push(item)))
	        {
	        	int currentIndex= stacks.indexOf(newStack);
	        	newStack=new MyStack();
	        	stacks.add(newStack);
	        	newStack.push(item);
	    
	        }

	    }

	    public int pop()
	    {
	    	if(newStack.isEmpty())
	    	{
	    		int currentIndex= stacks.indexOf(newStack);
	    		
	    		if(currentIndex>0)
	    		{
	    			stacks.remove(currentIndex);
	    			newStack=stacks.get(currentIndex-1);
	    			newStack.resetTop();
	    			return newStack.pop();
	    		}
	    		
	    		//throw some EmptyStackException
	    		return -10000000;
	    	}
	    	else
	    	{	
	    		return newStack.pop();
	    	}

	    }
	    
	    public int popAt(int index)
	    {
	    	int item=-123456;
	    	newStack=stacks.get(index-1);
	    	if(newStack !=null)
	    	{
	    		if(index<stacks.size()-1)
	    		{
	    			newStack.resetTop();
	    		}
	    		// may need to store some dummy elements in its place..otherwise roll over
	    		return newStack.pop();
	    	}
	    	return item;
	    }
	    
	    public static void main(String[] args)
	    {
	    	SetOfStacks sStacks=new SetOfStacks();
	    	
	    	sStacks.push(12);
	    	sStacks.push(22);
	    	sStacks.push(32);
	    	sStacks.push(42);
	    	sStacks.push(52);
	    	sStacks.push(62);
	    	System.out.println(sStacks.pop());
	    	System.out.println(sStacks.pop());
	    	System.out.println(sStacks.pop());
	    	System.out.println(sStacks.pop());
	    	System.out.println(sStacks.pop());
	    	System.out.println(sStacks.pop());
	    	System.out.println(sStacks.pop());
	    	sStacks.push(34);
	    	sStacks.push(44);
	    	sStacks.push(54);
	    	sStacks.push(64);
	    	System.out.println(sStacks.pop());
	    	System.out.println(sStacks.pop());
	    	sStacks.push(36);
	    	sStacks.push(46);
	    	sStacks.push(56);
	    	sStacks.push(66);
	    	System.out.println(sStacks.pop());
	    	System.out.println(sStacks.pop());
	    	System.out.println(sStacks.pop());
	    	System.out.println(sStacks.popAt(1));
	    	//sStacks.displayStackElements();
	    }
	    
	    /*
	    public void displayStackElements()
	    {
	    	for(MyStack s: stacks)
	    	{
	    		
	    			System.out.println(s);
	    		
	    	}
	    	
	    }*/
	}

 class MyStack
	{
	    int top;
	    int count=5;
	    int[] stack=new int[count];
	    
	    public MyStack()
	    {
	    top=-1;
	    }
	    
	    public void resetTop()
	    {
	    top=count-1;	
	    }
	    
	    public void resetBottom()
	    {
	    top=-1;	
	    }
	    
	    public boolean push(int item)
	    {
	        if(isFull())
	        {
	        return false;
	        }
	        else
	        stack[++top]=item;
	        return true;
	    }
	    
	    private boolean isFull()
	    {
	        return (top>=(count-1));
	    }

	    public int pop()
	    {
	    	try{
	    	int item=0;
	    	item=stack[top--];
	    	
	    	return item;
	    	}catch(Exception e){System.out.println("top= "+top);};
	    	return -123;
	    }
	    
	    public boolean isEmpty()
	    {
	    	
	    	return (top==-1);
	    }
	    /*
	    @Override
	    public String toString()
	    {
	    	String temp="";
	    	for(int i=0;i<count;i++)
	    	{
	    		temp+=stack[i];
	    	}
	    	System.out.println("in toString " +temp);
	    	return temp;
	    }
	    */
	}