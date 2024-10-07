import java.util.*;

class ArrayListDemo
{
	public static void display(Collection<?> c)
	{
		if(c == null) return;
		for(Object ob : c)
		{
			System.out.println(ob);
		}
	}
	public static void main(String args[])
	{
		//List <---- ArrayList

		//ArrayList <String> strList1 = new ArrayList<String>();
		//List <String> strList1 = new ArrayList<String>();
		List <String> strList1 = new LinkedList<String>();
		//Set <String> strList1 = new HashSet<String>();

		strList1.add("Mohan");
		strList1.add("Geeta");
		strList1.add("Mercy");
		strList1.add("Asif");
		strList1.add("Chandan");

		//Print list elements using for each
		System.out.println("strList1 elements:");
		for(String s : strList1)
		{
			System.out.println(s);
		}

		System.out.println("sublist of list");
		List<String> strSubList1 = strList1.subList(1,4);
		display(strSubList1);

		strList1.set(1,"Sita");
		System.out.println("List after setting value at index 1:");
		display(strList1);


	}
}
