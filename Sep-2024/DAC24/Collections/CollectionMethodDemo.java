import java.util.*;

class CollectionMethodDemo
{
	public static void display( Collection <?> c)  //It will be used to print List, Set or any Collection container elements.
	{
		for(Object ob : c)
			System.out.println(ob);
	}

	public static void main(String args[])
	{
		//List <---- ArrayList

		ArrayList <String> strList1 = new ArrayList<String>();
		List <String> strList2 = new ArrayList<String>();

		//add() method
		strList1.add("Mohan");
		strList1.add("Geeta");
		strList1.add("Mercy");
		strList1.add("Akaash");

		strList2.add("Mohit");
		strList2.add("Akaash");
		strList2.add("Reena");

		//Print list elements using for each
		System.out.println("strList1 elements:");
		display(strList1);

		System.out.println("strList2 elements:");
		display(strList2);

		//addAll() method
		strList2.addAll(strList1);
		System.out.println("strList2 after strList2.addAll(strList1):");
		display(strList2);

		//remove() method
		strList1.remove("Geeta");
		System.out.println("strList1 after removing Geeta: ");
		display(strList1);

		//removeAll() method
		strList1.removeAll(strList2);

		//retainAll() method
		strList1.retainAll(strList2);

		//contains()
		boolean retval = strList1.contains("Mohit"); //will return true or false
		
		//containsAll()
		retval = strList1.containsAll(strList2);			//will return true or false
		//Using toArray() and printing the array
		System.out.println("Output of the strList2.toArray():");	
		Object[] obarr = strList2.toArray();
		for(Object ob : obarr)
		{
			System.out.println(ob);
		}

	}
}
