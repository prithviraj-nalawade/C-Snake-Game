import java.util.*;
import java.util.stream.*;

class Student
{
	int roll;
	String name;
	int age;
	
	Student()
	{
		System.out.println("Student zero arg constructor called");
	}
	
	Student(int roll, String name, int age)
	{
		this.roll = roll;
		this.name = name;
		this.age = age;
	}
	
	public int compareStudName(Student s)
	{
		return this.name.compareTo(s.name);
	}
	
	public int compareStudAge(Student s)
	{
		return this.age - s.age;
	}
	
	public static int compareNum(int a, int b)
	{
		return a - b;
	}
	
	public String toString()
	{
		return "Student[" + this.roll +", " + this.name + ", " + this.age + "]"; 
	}
}


class StreamDemo
{
	static void display(Collection<?> c)
	{
		if(c == null) return;
		/*for(Object ob : c)
		{
			System.out.println(ob);
		}*/
		
		c.forEach(System.out::println);
	}
	
	public static void main(String args[])
	{
		Student stud1 = new Student(4,"Rohit", 22);
		Student stud2 = new Student(1,"Geeta",25);
		Student stud3 = new Student(2,"Gagan",20);
		Student stud4 = new Student(5,"Rajesh",27);
		Student stud5 = new Student(3,"Mohid",23);
		
		List<Student> studList = new ArrayList<Student>();
		studList.add(stud1);
		studList.add(stud2);
		studList.add(stud3);
		studList.add(stud4);
		studList.add(stud5);
		
		List<Student> studList1 = new ArrayList<Student>();
		Student stud6 = new Student(6,"Robin", 18);
		Student stud7 = new Student(7,"Azad",26);
		
		studList1.add(stud6);
		studList1.add(stud7);
		
		List<Student> conctenatedStudList = Stream.concat(studList.stream(),studList1.stream())
								.collect(Collectors.toList());
		
		System.out.println("Concatenated Student List:");
		display(conctenatedStudList);
		
		System.out.println("End of Concatenated List");
		//display(studList);
		//forEach Method - Iterable, Stream     => forEach(Consumer<? super T> action)
		//studList.forEach(System.out::println);
		studList.forEach(e -> System.out.println(e));			
		
		
		Stream<Student> studStream = studList.stream();
		System.out.println("Stream of students output: ");
		//studStream.forEach(ob -> System.out.println(ob));
		studStream.forEach(System.out::println);
		
		//System.out.println("Again printin the same stream of students: ");
		//studStream.forEach(System.out::println);
		
		//We have to create and display a list of the students whose age is less than 25.
		
		//filter() method
		System.out.println("List of students with age less than 25:");
		//studList.stream().filter(ob -> ob.age < 25).forEach(System.out::println);
		
		List<Student> belowAgeStudList = studList.stream().filter(ob -> ob.age < 25).collect(Collectors.toList());
		
		Set<Student> belowAgeStudSet = studList.stream().filter(ob -> ob.age < 25).collect(Collectors.toCollection(HashSet::new));
		
		display(belowAgeStudList);
		
		//sorted()
		System.out.println("Sorted by age for student below age 25: ");
		studList.stream().filter(ob -> ob.age < 25).sorted(Student::compareStudAge)
		.forEach(System.out::println);
		
		//reduce()
		Student maxAgeStud = studList.stream().
					reduce(new Student(),
						(s1, s2) -> s1.age >= s2.age ? s1 : s2); 
		System.out.println("Student with maximum age: ");
		System.out.println(maxAgeStud); 
		
		//map()
		List<String> nameList = studList.stream()
						.map(ob -> ob.name).collect(Collectors.toList());
		System.out.println("Names of the students:");
		display(nameList);
		
		//peek()
		System.out.println("Student after incrementing age by 1:");
		studList.stream().peek(ob -> ob.age++).forEach(System.out::println);
		
		//------------------------------------------------------------------
		
		System.out.println("Stream with Integer Array:");
		Integer numarr[] = {3,5,2,4,7};
		
		Stream.of(numarr).forEach(System.out::println);
		
		int numsum = Stream.of(numarr).reduce(0,(a,b) -> a + b);
		System.out.println("Sum of integer arr: " + numsum);
		
		Optional<Integer> maxnum = Stream.of(numarr).max((a,b) -> a - b);
		//Optional<Integer> maxnum = Stream.of(numarr).max(Student::compareNum);
		
		if(maxnum.isPresent())
			System.out.println("Max value in integer arr: " + maxnum.get());
		
	}
}



