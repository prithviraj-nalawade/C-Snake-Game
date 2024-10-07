class Q
{
	int prodno ;

	void put(int x)
	{
		prodno = x;
		System.out.println("Produced : " + prodno);
	}

	void get()
	{
		System.out.println("Consumed : " + prodno);
	}
}

class Producer implements Runnable
{
	Q q;
	Thread t;

	public Producer(Q q)
	{
		this.q = q;
		t = new Thread(this);
		t.start();
	}

	public void run()
	{
		produce();
	}

	void produce()
	{
		for(int i = 1; i <= 1000; i++)
		{
			q.put(i);
		}

	}


}

class Consumer implements Runnable
{
	Q q;
	Thread t;

	public Consumer(Q q)
	{
		this.q = q;
		t = new Thread(this);
		t.start();
	}

	public void run()
	{
		consume();
	}

	void consume()
	{
		for(int i = 1; i <= 1000; i++)
		{
			q.get();
		}
	}
}

class ProducerConsumerProblemNonsynchronized
{
	public static void main(String args[]) throws InterruptedException
	{
		Q q = new Q();
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);

		p.t.join();
		c.t.join();
	}
}
