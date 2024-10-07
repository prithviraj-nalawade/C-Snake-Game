import java.util.*;

class CollectionsMethodsDemo
{
	public static void display(Collection<?> c)
	{
		if(c == null) return;
		Iterator<Object> it = (Iterator<Object>)c.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
	public static void main(String args[])
	{
		List <Integer> numList1 = new LinkedList<Integer>();

		numList1.add(3);
		numList1.add(5);
		numList1.add(2);
		numList1.add(7);
		numList1.add(6);

		//Print list elements using for each
		System.out.println("numList1 elements:");
		display(numList1);

		//Collections.shuffle()
		Collections.shuffle(numList1);
		System.out.println("numList1 elements after shuffle:");
		display(numList1);

		//Collections.max()
		int max = Collections.max(numList1);
		System.out.println("Max value of numList1: "+max);

		//Collections.sort()
		Collections.sort(numList1);		//ascending order
		System.out.println("numList1 elements after sort:");
		display(numList1);

		//Collections.reverseOrder()
		Collections.sort(numList1,Collections.reverseOrder());	//reverse order
		System.out.println("numList1 elements after sort in reverse order:");
		display(numList1);


	}
}
