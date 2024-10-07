import java.util.*;

class Student implements Comparable<Student>
{
	int roll;
	String name;
	int age;

	public Student()
	{

	}

	public Student(int roll, String name, int age)
	{
		this.roll = roll;
		this.name = name;
		this.age = age;
	}

	public int compareTo(Student s)
	{
		return this.roll - s.roll;
		//return this.age - s.age;
		//return this.name.compareTo(s.name);
	}

	public String toString()
	{
		return roll + "," + name + "," + age ;
	}
}


//Using Comparator interface ==> compare()
class AgeComparator implements Comparator<Student>
{
	public int compare(Student s1, Student s2)
	{
		return s1.age - s2.age;
	}
}

//Using Comparator interface ==> compare()
class NameComparator implements Comparator<Student>
{
	public int compare(Student s1, Student s2)
	{
		return s1.name.compareTo(s2.name); 
	}
}


class CollectionsMethodsForUserDefinedObjectDemo 
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
		List<Student> studList = new ArrayList<Student>();
		Student s1 = new Student(3,"Mohit",23);
		Student s2 = new Student(1,"Meeta",21);
		Student s3 = new Student(4,"Asif",24);
		Student s4 = new Student(2,"Rohan",20);

		studList.add(s1);
		studList.add(s2);
		studList.add(s3);
		studList.add(s4);

		//display using for each
		System.out.println("studList elements: ");
		display(studList);

		//Collections.shuffle()
		Collections.shuffle(studList);
		System.out.println("studList after shuffle:");
		display(studList);

		//Collections.sort();
		Collections.sort(studList);		//Roll based sorting
		System.out.println("studList after sort:");
		display(studList);

		//Collections.sort();
		Collections.sort(studList,new AgeComparator());		//Age based sorting
		System.out.println("studList after sort on age:");
		display(studList);

		//Collections.sort();
		Collections.sort(studList,new NameComparator());		//Name based sorting
		System.out.println("studList after sort on name:");
		display(studList);

		//Collections.reverseOrder();
		Collections.sort(studList,Collections.reverseOrder());		//Roll based sorting
		System.out.println("studList after sort in reverse order:");
		display(studList);

		//Collections.reverseOrder();
		Collections.sort(studList,Collections.reverseOrder(new AgeComparator()));		//Age based sorting
		System.out.println("studList after sort on age in reverse order:");
		display(studList);

	}
	
}
