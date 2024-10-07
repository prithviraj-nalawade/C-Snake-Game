import java.util.*;

class Student
{
	int roll;
	String name;
	int age;

	Student(){}
	Student(int roll, String name, int age)
	{
		this.roll = roll;
		this.name = name;
		this.age = age;
	}

	public String toString()
	{
		return "Student["+this.roll + "," + this.name + "," + this.age + "]";
	}

}

class StudentMapDemo1
{
	public static void display(Collection <?> c)
	{
		if(c == null) return;
		for(Object ob : c)
		{
			System.out.println(ob);
		}
	}

	public static void displayMap(Map<String,Student> myMap)
	{
		for(Map.Entry<String,Student> entry : myMap.entrySet())
		{
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

	public static void main(String args[])
	{
		Map<String,Student> studMap = new TreeMap<String,Student>();

		Student s1 = new Student(1,"Mohan",23);
		Student s2 = new Student(2,"Geeta",22);
		Student s3 = new Student(3,"Jacob",25);

		studMap.put("One",s1);
		studMap.put("Two",s2);
		studMap.put("Three",s3);
		studMap.put("Four", new Student(4,"Riya",24));

		System.out.println("Map elements:");
		displayMap(studMap);

		//get(key) ==> returns value or object related with that key
		Student stud = studMap.get("Two");
		System.out.println("Student with roll 2: " + stud.name);
		//System.out.println(stud);



	}
}
