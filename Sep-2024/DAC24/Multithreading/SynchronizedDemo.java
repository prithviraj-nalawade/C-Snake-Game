//Create thread using Runnable interface

class StringPrinter
{
	synchronized public void printStr(String str)
	{
		try
		{
			System.out.print("[");
			Thread.sleep(500);		//does not release lock
			System.out.print(str);
			Thread.sleep(500);
			System.out.print("]");
			Thread.sleep(500);
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
}


class MyThread implements Runnable
{
	Thread t;
	StringPrinter sp;
	String msgToPrint;
	
	MyThread()
	{
		t = new Thread(this);
		t.start();
	}
	
	MyThread(StringPrinter sp, String msgToPrint)
	{
		this.sp = sp;
		this.msgToPrint = msgToPrint;
		
		t = new Thread(this);
		t.start();
	}
	
	public void run() 
	{
		sp.printStr(msgToPrint);
	}
}


class SynchronizedDemo
{
	public static void main(String args[]) throws InterruptedException
	{
		StringPrinter sp = new StringPrinter();
		
		MyThread mt1 = new MyThread(sp,"Hello");
		MyThread mt2 = new MyThread(sp,"Friends");
		MyThread mt3 = new MyThread(sp,"Welcome");
		
		mt1.t.join();	//Main thread pauses its execution for mt1 to complete its task.
		mt2.t.join();	//Main thread pauses its execution for mt2 to complete its task.
		mt3.t.join();
		
		System.out.println("Main thread completed");
	}
	
			
}
