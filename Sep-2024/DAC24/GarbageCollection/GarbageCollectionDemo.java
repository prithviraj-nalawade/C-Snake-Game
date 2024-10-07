class One
{
	Two t;
	
	protected void finalize()
	{
		System.out.println("Garbage collection initiated for an object of One");
	}
}

class Two
{
	One o;
	
	protected void finalize()
	{
		System.out.println("Garbage collection initiated for an object of Two");
	}
}

class Demo
{
	String name;		//We will store object name of Demo here.
	
	Demo()
	{
	}
	
	Demo(String name)
	{
		this.name = name;
	}
	
	protected void finalize()
	{
		System.out.println("Garbage collection initiated for : " + this.name);
	}
}


class GarbageCollectionDemo
{

	public static void myFun()
	{
		Demo d6 = new Demo("Six");		//Local reference variable
		//other works
	}


	public static void main(String args[])
	{
		Demo d1 = new Demo("First");
		Demo d2 = new Demo("Second");
		
		d1 = d2;			//Reassigning the reference variable
		Demo d3 = new Demo("Third");
		d3 = d1;

		Demo d4 = new Demo("Four");
		d4 = null;			//Nullifying the reference variable

		new Demo("Five");		//Anonymous object creation
						
		myFun();
		
		//Island of isolation example
		//oneObj & twoObj are keepting the reference of each other but their reference are stored nowhere. So these two object referred by oneObj and twoObj will be eligible for garbage collection.
		One oneObj = new One();
		Two twoObj = new Two();
		
		oneObj.t = twoObj;
		twoObj.o = oneObj;

		oneObj = null;
		twoObj = null;
		
		//System.gc();
		Runtime.getRuntime().gc();
		System.out.println("Program terminated successfully");
	}
}

