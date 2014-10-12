package helloWorld;

public class TestEclipse {
	static int a=10;
	static Integer b=10;
	static String s=null;
	// static Demo d;
	public static void main(String[] args)
	{
		  
		 a=10;
		 b=10;
		 s=new String("sunny");
		  Demo d=new Demo(4);
		System.out.println(a+" "+s+b+"** "+d);
		//System.out.println("hello");
	
	Demo	dd=testPassByRef(a,b,s,d);
	System.out.println(d==dd);
		System.out.println(a+" "+s+b+"** "+d);
	}
	
	private static Demo testPassByRef(int a, Integer b, String s, Demo d)
	{
		a=b=20;
		s=new String("abc");
		
		s.substring(2);
	// d=new Demo(6);
		 d.setValue(56);
		 System.out.println(d);
		 return d;
		
	}

}

class Demo{
	int dummy;
	public Demo(int dummy)
	{
		this.dummy=dummy;
	}
	@Override
	public String toString()
	{
		
		return new Integer(dummy).toString();
	}
	
	public void setValue(int val)
	{
		this.dummy=val;
	}
}


