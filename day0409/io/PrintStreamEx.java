package day0409.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamEx {

	public static void main(String[] args) {
		try(FileOutputStream fos = new FileOutputStream("print.txt");
				PrintStream ps = new PrintStream(fos)){
			ps.println("문자열");
			ps.print(1000);
			ps.println(3.14);
			ps.println(true);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end");

	}

}
