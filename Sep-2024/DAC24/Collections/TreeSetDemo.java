import java.util.*;

class Student implements Comparable<Student>
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

	public int compareTo(Student s)
	{
		return this.roll - s.roll;
	}

        public String toString()
        {
                return "Student["+this.roll + "," + this.name + "," + this.age + "]";
        }

}

class AgeComparator implements Comparator<Student>
{
	public int compare(Student s1, Student s2)
	{
		return s1.age - s2.age;
	}
}

class TreeSetDemo
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
		//Set <String> strSet = new LinkedHashSet<String>();
		//Set <String> strSet = new HashSet<String>();
		Set <String> strSet = new TreeSet<String>();

		strSet.add("Mohan");
		strSet.add("Geeta");
		strSet.add("Mercy");
		strSet.add("Asif");
		strSet.add("Chandan");

		System.out.println("strSet elements:");
		display(strSet);

		//Set<Student> studSet = new HashSet<Student>();
		//Set<Student> studSet = new TreeSet<Student>();	//Roll based sorting
		Set<Student> studSet = new TreeSet<Student>(new AgeComparator()); //Age based sorting
		studSet.add(new Student(2,"Mohan",22));
		studSet.add(new Student(1,"Meeta",25));
		studSet.add(new Student(4,"Sita",24));
		studSet.add(new Student(3,"Gagan",20));

		System.out.println("studSet elements:");
		display(studSet);

	}
}
