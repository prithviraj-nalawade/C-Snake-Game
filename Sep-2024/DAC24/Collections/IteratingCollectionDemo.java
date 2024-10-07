import java.util.*;

class IteratingCollectionDemo
{
	public static void main(String args[])
	{
		List<String> strList = new LinkedList<>();
		strList.add("Mohit");
		strList.add("Shekhar");
		strList.add("Pooja");

		//1. using for-each 
		System.out.println("Iteration using for-each");
		for(String s : strList)
			System.out.println(s);

		//2. using Iterator		==> will be used to iterate any Collection object
		System.out.println("Iteration using Iterator");
		Iterator<String> it = strList.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}

		//3. using ListIterator ==> will be used to iterate only List objects
		System.out.println("Iteration using ListIterator");
		ListIterator<String> lit = strList.listIterator();
		while(lit.hasNext())
		{
			System.out.println(lit.next());
		}

		System.out.println("Iteration in reverse order using ListIterator");
		while(lit.hasPrevious())
		{
			System.out.println(lit.previous());
		}

		//4. using Enumeration 
		System.out.println("Iteration using Enumeration");
		Enumeration<String> em = Collections.enumeration(strList);
		while(em.hasMoreElements())
		{
			System.out.println(em.nextElement());
		}

	}
}
