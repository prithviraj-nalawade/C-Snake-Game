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

	public String toString()
	{
		return roll + "," + name + "," + age ;
	}
}

class StudentListDemo
{
	public static void main(String args[])
	{
		List<Student> studList = new ArrayList<Student>();
		Student s1 = new Student(1,"Mohit",23);
		Student s2 = new Student(2,"Meeta",21);
		Student s3 = new Student(3,"Asif",24);

		studList.add(s1);
		studList.add(s2);
		studList.add(s3);

		//display using for each
		for(Student s : studList)
		{
			System.out.println(s);	//System.out.println(s.toString()); --> classname@hashcode
		}
	}
	
}
