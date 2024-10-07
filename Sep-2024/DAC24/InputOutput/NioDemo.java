import java.io.*;
import java.nio.*;
import java.nio.channels.*;

class NioDemo
{
	public static void main(String args[]) throws IOException
	{
		FileInputStream fis = new FileInputStream("myfile.txt");
		FileChannel fcin = fis.getChannel();
		ByteBuffer bb = ByteBuffer.allocate((int)fcin.size());

		//channel to buffer
		fcin.read(bb);

		//read from buffer
		bb.rewind();
		for(int i = 0; i < (int)fcin.size(); i++)
		{
			char ch = (char) bb.get(i);
			System.out.print(ch);
		}	

		FileOutputStream fos = new FileOutputStream("myoutfile.txt");
		FileChannel fcout = fos.getChannel();

		//write to file
		bb.rewind();
		fcout.write(bb);


		fcin.close();
		fis.close();

		fcout.close();
		fos.close();

		System.out.println("Program executed successfully!!");
	}
}
