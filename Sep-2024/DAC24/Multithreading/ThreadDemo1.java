//Create thread using Thread class

class MyThread extends Thread
{
	MyThread()
	{
	
	}
	
	MyThread(String tname)
	{
		super(tname);
	}
	
	public void run()
	{
		//System.out.println(this.getName() + " thread started");
		System.out.println(Thread.currentThread().getName() + " thread started");
	}
}


class ThreadDemo1
{
	public static void main(String args[])
	{
		MyThread mt1 = new MyThread();
		mt1.setName("First");
		mt1.start();
		
		MyThread mt2 = new MyThread("Second");
		mt2.start();
		
		System.out.println("Main thread completed");
	}
	
			
}
