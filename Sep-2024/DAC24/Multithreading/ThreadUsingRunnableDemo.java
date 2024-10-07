//Create thread using Runnable interface

class MyThread implements Runnable
{
	MyThread()
	{
	
	}
	
	MyThread(String tname)
	{
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


class ThreadUsingRunnableDemo
{
	public static void main(String args[]) throws InterruptedException
	{
		MyThread mt1 = new MyThread();
		Thread t1 = new Thread(mt1);
		
		t1.setName("First");
		t1.start();
		
		MyThread mt2 = new MyThread();
		Thread t2 = new Thread(mt2);
		
		t2.setName("Second");
		t2.start();
		
		//Thread.sleep(2000);	//Main thread is sleeping here for 2 second
		
		t1.join();	//Main thread pauses its execution for mt1 to complete its task.
		t2.join();	//Main thread pauses its execution for mt2 to complete its task.
		
		System.out.println("Main thread completed");
	}
	
			
}
