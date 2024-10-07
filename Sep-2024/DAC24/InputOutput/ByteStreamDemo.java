import java.io.*;

class ByteStreamDemo
{
	public static void main(String args[]) throws IOException
	{
		File inf = new File("myfile.txt");	//We can give absolute path and relative path
		File opf = new File("myoutfile.txt");	//We can give absolute path and relative path

		if(!inf.exists())
		{
			System.out.println("File does not exist!!");
			return;
		}

		FileInputStream fis = new FileInputStream(inf);
		FileOutputStream fos = new FileOutputStream(opf);
		
		int ch;	
		while((ch = fis.read()) != -1)
		{
			System.out.print((char)ch);
			fos.write(ch);
		}

		fis.close();
		fos.close();
		System.out.println("Program executed successfully!!");

	}
}
