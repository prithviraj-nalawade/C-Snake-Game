import java.io.*;

class CharacterStreamDemo
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

		FileReader fr = new FileReader(inf);
		FileWriter fw = new FileWriter(opf);
		
		int ch;	
		while((ch = fr.read()) != -1)
		{
			System.out.print((char)ch);
			fw.write(ch);
		}

		fr.close();
		fw.close();
		System.out.println("Program executed successfully!!");

	}
}
