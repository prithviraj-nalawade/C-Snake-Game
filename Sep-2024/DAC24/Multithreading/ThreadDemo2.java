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
		try
		{
			//System.out.println(this.getName() + " thread started");
			System.out.println(Thread.currentThread().getName() + " thread started");
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + " thread completed");
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
}


class ThreadDemo2
{
	public static void main(String args[]) throws InterruptedException
	{
		MyThread mt1 = new MyThread();
		mt1.setName("First");
		mt1.start();
		
		MyThread mt2 = new MyThread("Second");
		mt2.start();
		
		Thread.sleep(2000);	//Main thread is sleeping here for 2 second
		
		System.out.println("Main thread completed");
	}
	
			
}
