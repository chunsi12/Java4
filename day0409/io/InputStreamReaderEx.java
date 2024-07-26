package day0409.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderEx {

	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("input.txt");
				InputStreamReader isr = new InputStreamReader(fis)) {
			
			int i = 0;
			
			char[] c = new char[10];
			while((i = isr.read(c))!= -1) {
				System.out.println(c);
			}
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

}
