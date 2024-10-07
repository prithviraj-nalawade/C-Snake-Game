import java.util.*;

class Student
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

	public int hashCode()
	{
		int primeno = 31;
		return 31 * roll + age;
	}

	public boolean equals(Object ob)
	{
		if(ob == null) return false;
		Student s = (Student) ob;
		if(this.roll == s.roll && this.name.equals(s.name) && this.age == s.age)
		{
			return true;
		}
		return false;
	}

	public String toString()
	{
		return roll + "," + name + "," + age ;
	}
}

class CollectionMethodForUserDefinedObject 
{
	public static void display(Collection<?> c)
	{
		for(Object ob : c)
		{
			System.out.println(ob);
		}
	}

	public static void main(String args[])
	{
		List<Student> studList1 = new ArrayList<Student>();
		List<Student> studList2 = new ArrayList<Student>();

		Student s1 = new Student(1,"Mohit",23);
		Student s2 = new Student(2,"Meeta",21);
		Student s3 = new Student(3,"Asif",24);
		
		//add method()
		studList1.add(s1);
		studList1.add(s2);
		studList1.add(s3);

		studList2.add(new Student(4,"Anand",22));
		studList2.add(new Student(2,"Meeta",21));

		//display using for each
		display(studList1);

		//contains()
		boolean retval = studList2.contains(s2);
		System.out.println("Output of studList1.contains(s2)");
		System.out.println(retval);

	}
	
}
