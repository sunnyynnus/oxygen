package helloWorld;

public class TestThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestThread tt1= new TestThread("child1",4);
		tt1.start();
		TestThread tt2= new TestThread("child1",5);
		tt2.start();
		TestThread tt3= new TestThread("child1",9);
		tt3.start();
		//TestThread tt4= new TestThread("child1",8);
	//	tt4.start();
		//TestThread tt5= new TestThread("child1",9);
	//	tt5.start();
		//TestThread tt6= new TestThread("child1",10);
	//	tt6.start();
		tt1.stop();
		tt2.stop();
		//tt3.stop();
		System.out.println("tt1== "+tt1.click);
		System.out.println("tt2== "+tt2.click);
		System.out.println("tt3== "+tt3.click);
		try{
			//Thread.sleep(1000);
			tt1.t.join();
			tt2.t.join();
		//	tt3.t.join();
		//	tt4.t.join();
		//	tt5.t.join();
		//	tt6.t.join();
		}
		catch(InterruptedException e) {
			System.out.println("Main thread interrupted");
		}
		 
	
		System.out.println("tt1= "+tt1.click);
		System.out.println("tt2= "+tt2.click);
		System.out.println("tt3= "+tt3.click);
		//System.out.println("tt2= "+tt4.click);
		//System.out.println("tt1= "+tt5.click);
	//	System.out.println("tt2= "+tt6.click);
	}

}
