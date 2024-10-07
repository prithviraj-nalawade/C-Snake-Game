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

class DeserializationDemo
{
	public static void main(String args[]) throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream("objoutfile.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Student stud = (Student) ois.readObject();
		System.out.println("Object deserialized successfully!!");

		System.out.println("deserialized object is : ");
		System.out.println(stud);

		fis.close();
		ois.close();
	}
}
