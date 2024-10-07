import java.util.*;

interface MyInterface1
{
	void myFun();
}

interface MyComparatorInterface <T>
{
	int compare(T a, T b);
}

interface MySupplierInterface <R>
{
	R supply();
}

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
	
	public static void printHi()
	{
		System.out.println("Hi");
	}
	
	public void printHello()
	{
		System.out.println("Hello");
	}
	
	public int compareStudName(Student s)
	{
		return this.name.compareTo(s.name);
	}
	
	public int compareStudAge(Student s)
	{
		return this.age - s.age;
	}	
	
	public String toString()
	{
		return "Student[" + this.roll +", " + this.name + ", " + this.age + "]"; 
	}
}

/*class AgeComparator implements Comparator<Student>
{
	public int compare(Student s1, Student s2)
	{
		//return s1.age - s2.age;
		return s1.compareStudAge(s2);
	}
}*/

class MethodReferenceDemo
{
	static void display(Collection<?> c)
	{
		if(c == null) return;
		for(Object ob : c)
		{
			System.out.println(ob);
		}
	}
	
	public static void main(String args[])
	{
		/*MyInterface1 mif1 = new MyInterface1(){
				public void myFun()
				{
					System.out.println("Welcome");
				}
			};*/
			
		//MyInterface1 mif1 = () -> System.out.println("Welcome");
		//MyInterface1 mif1 = () -> Student.printHi();
		//MyInterface1 mif1 = Student::printHi;		//classname::static method
		MyInterface1 mif1 = new Student()::printHello;	//object::non-static method
		mif1.myFun();
		
		Student stud1 = new Student(4,"Rohit", 22);
		Student stud2 = new Student(1,"Geeta",25);
		Student stud3 = new Student(2,"Gagan",20);
		
		List<Student> studList = new ArrayList<Student>();
		studList.add(stud1);
		studList.add(stud2);
		studList.add(stud3);
		
		//Collections.sort(studList,new AgeComparator());
		/*Comparator<Student> scmp = new Comparator<Student>{
			public int compare(Student st1, Student st2)
			{
				return st1.compareStudAge(st2);
			}			v
		};*/
		
		//Comparator<Student> scmp = (st1, st2) -> st1.compareStudAge(st2);
		Comparator<Student> scmp = Student::compareStudAge;
		//Collections.sort(studList,scmp);
		
		
		//Collections.sort(studList,Student::compareStudAge);
		Collections.sort(studList,Student::compareStudName);
		
		display(studList);
		
		/*MyComparatorInterface<Student> mci = new MyComparatorInterface<Student>(){
			public int compare(Student s1, Student s2)
			{
				//return s1.age - s2.age;		//OK
				return s1.compareStudAge(s2);
			}
		};*/ 
		
		/*MyComparatorInterface<Student> mci = (Student st1, Student st2) -> 
			{
				//return s1.age - s2.age;		//OK
				return st1.compareStudAge(st2);		//OK
			};*/
		
		/*MyComparatorInterface<Student> mci = (st1, st2) -> 
			{
				//return s1.age - s2.age;		//OK
				return st1.compareStudAge(st2);
			};*/
			
		/*MyComparatorInterface<Student> mci = (st1, st2) ->  st1.compareStudAge(st2);*/
		
		MyComparatorInterface<Student> mci = Student::compareStudAge;
			
			
		int res = mci.compare(stud1,stud2);
		System.out.println("Result : " + res);
		
		/*MySupplierInterface<Student> msi = new MySupplierInterface(){
				public Student supply()
				{
					return new Student();
				} 
			}; */
			
		//MySupplierInterface<Student> msi = () -> new Student();
		MySupplierInterface<Student> msi = Student::new;
		
		Student s6 = msi.supply();
		System.out.println("s6 : " + s6);
		
	}
}



