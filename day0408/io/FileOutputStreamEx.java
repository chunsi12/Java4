package day0408.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;



public class FileOutputStreamEx {

	public static void main(String[] args) throws IOException {
		
		try {
			FileOutputStream fos = new FileOutputStream("test.txt");
			byte[] bArr = {1,2,3,4};
			
			fos.write(bArr);
			fos.write("안녕".getBytes());//String -> byte[]

			PrintStream ps = new PrintStream(fos);
			ps.print(1);
			
			fos.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("end");

	}

}
