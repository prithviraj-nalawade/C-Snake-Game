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
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " thread completed");
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
}


class ThreadDemo3
{
	public static void main(String args[]) throws InterruptedException
	{
		MyThread mt1 = new MyThread();
		mt1.setName("First");
		mt1.start();
		
		MyThread mt2 = new MyThread("Second");
		mt2.start();
		
		//Thread.sleep(2000);	//Main thread is sleeping here for 2 second
		
		mt1.join();	//Main thread pauses its execution for mt1 to complete its task.
		mt2.join();	//Main thread pauses its execution for mt2 to complete its task.
		
		System.out.println("Main thread completed");
	}
	
			
}
