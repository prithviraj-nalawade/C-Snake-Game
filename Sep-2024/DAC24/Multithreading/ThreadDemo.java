//Create thread using Thread class

class MyThread extends Thread
{
	public void run()
	{
		System.out.println("Thread started");
	}
}


class ThreadDemo
{
	public static void main(String args[])
	{
		MyThread mt1 = new MyThread();
		mt1.start();
		
		System.out.println("Main thread completed");
	}
	
			
}
