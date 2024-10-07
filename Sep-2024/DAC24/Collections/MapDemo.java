import java.util.*;
class MapDemo
{
	public static void display(Collection <?> c)
	{
		if(c == null) return;
		for(Object ob : c)
		{
			System.out.println(ob);
		}
	}

	public static void displayMap(Map<Integer,String> myMap)
	{
		for(Map.Entry<Integer,String> entry : myMap.entrySet())
		{
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

	public static void main(String args[])
	{
		//Key => roll, value => name
		Map<Integer,String> myMap1 = new HashMap<Integer,String>();

		//put(key,value) method to add value
		myMap1.put(1,"Rohit");		
		myMap1.put(2,"Rakesh");		
		myMap1.put(3,"Mohid");		
		myMap1.put(4,"Sanjeev");		
		myMap1.put(5,"Rakesh");
		myMap1.put(null,"NoName");

		//get(key)
		String name = myMap1.get(3);		//name will contain "Mohid"
		System.out.println(name);

		String sname = myMap1.get(6);
		System.out.println("sname = " + sname);

		//Set<String> strSet;
		//for(String s : strSet){}

		//entrySet() method for printing map values
		System.out.println("Map elements with key : value ");
		/*Set<Map.Entry<Integer,String>> mapEntrySet1 = myMap1.entrySet();
		for(Map.Entry<Integer,String> entry : mapEntrySet1)
		{
			Integer k = entry.getKey();
			String s = entry.getValue();
			System.out.println(k + " : " + s);
		}*/
		
		displayMap(myMap1);


		//keySet() method ==> It will return set of keys.
		System.out.println("Set of keys : ");
		Set<Integer> myKeySet1 = myMap1.keySet();
		display(myKeySet1);

		//values() method
		System.out.println("Map values : ");
		Collection<String> myValues = myMap1.values();
		display(myValues);

		//put() method to replace the value
		myMap1.put(1,"Rajan");
		System.out.println("After updating value for key => 1 ");
		displayMap(myMap1);
		
		//containsKey()
		boolean keyExists = myMap1.containsKey(2);
		System.out.println("key 2 exists : " + keyExists);


		//EntrySet is backed by Map
		Set<Map.Entry<Integer,String>> mapEntrySet1 = myMap1.entrySet();

		System.out.println("EntrySet before clearing the map:");
		display(mapEntrySet1);

		myMap1.clear();
		System.out.println("myMap1 size : " + myMap1.size());

		System.out.println("EntrySet after clearing the map:");
		display(mapEntrySet1);

		


	}
}
