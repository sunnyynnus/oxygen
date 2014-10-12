package helloWorld;

public class TestThread implements Runnable {

	Thread t;  volatile boolean flag=true;
	long click=0;
	
	public TestThread(String name, int priority)
	{
		t=new Thread(this);
		t.setPriority(priority);
		System.out.println(t);
	}
	

	@Override
	public void run()
	{
		System.out.println("running");
		while(flag)
			click++;
	}

	
	public void start()
	{
		t.start();
	}
	
	public void stop()
	{
		flag=false;
	}
}

