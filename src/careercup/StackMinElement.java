package careercup;

public class StackMinElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackMinElement obj=new StackMinElement();
		System.out.println(obj.pop());
		obj.push(4);
		obj.push(42);
		System.out.println(obj.getMin());
		obj.push(44);
		obj.push(2);
		obj.push(22);
		System.out.println(obj.pop());
		System.out.println(obj.getMin());
		
		obj.push(12);
	}
	
	private int min=0, top=-1, size=5;
	private int arr[]=new int[size];

	public int getMin()
	{
	    return arr[min];
	}

	public void push(int val)
	{
	    if(!isFull())
	    {
	        arr[++top]=val;
	        if(val<arr[min])
	        {
	            min=top;
	        }
	    }
	    else
	    {
	        System.out.println("Stack is full");
	    }
	}
	 
	public int pop()
	{
	    if(!isEmpty())
	    {
	        return arr[top--];
	    }
	     else
	    {
	        System.out.println("Stack is empty");
	        return 0;
	    }
	}

	private boolean isFull()
	{
	return (top==size-1);
	}

	private boolean isEmpty()
	{
	return (top==-1);
	}

}
