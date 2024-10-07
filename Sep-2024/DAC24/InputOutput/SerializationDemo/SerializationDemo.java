import java.io.*;

class Student implements Serializable
{
	int roll;
	String name;
	double marks;

	Student(){};
	Student(int roll, String name, double marks)
	{
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}

	public String toString()
	{
		return "Student[roll = " + this.roll + ", name = " + this.name + ", marks = " + this.marks + "]";
	}
}

class SerializationDemo
{
	public static void main(String args[]) throws IOException
	{
		FileOutputStream fos = new FileOutputStream("objoutfile.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		Student stud = new Student(1,"Rohit",75.8);
		oos.writeObject(stud);
		System.out.println("Object serialized successfully!!");

		System.out.println("Serialized object is: ");
		System.out.println(stud);

		fos.close();
		oos.close();
	}
}
