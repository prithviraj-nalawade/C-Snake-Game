import java.util.*;

class HashSetDemo
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
		//Set <String> strSet1 = Collections.synchronizedSet(new LinkedHashSet<String>());
		Set <String> strSet1 = new LinkedHashSet<String>();
		strSet1 = Collections.synchronizedSet(strSet1);

		strSet1.add("Mohan");
		strSet1.add("Geeta");
		strSet1.add("Mercy");
		strSet1.add("Asif");
		strSet1.add("Chandan");

		System.out.println("strSet1 elements:");
		display(strSet1);

	}
}
