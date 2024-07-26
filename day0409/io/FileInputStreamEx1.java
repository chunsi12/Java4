package day0409.io;

import java.io.FileInputStream;
import java.io.IOException;


public class FileInputStreamEx1 {

	public static void main(String[] args) {
		// input.txt로부터 1바이트씩 읽어와서 출력
		try(FileInputStream fis = new FileInputStream("input.txt")){
			//AutoCloseable 구현 객체만 가능
			System.out.println(fis.read());
			System.out.println((char)fis.read());
			System.out.println((char)fis.read());
			System.out.println((char)fis.read());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("end");

	}

}
