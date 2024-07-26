package day0409.io;

import java.io.IOException;
public class SystemInTest {

	public static void main(String[] args) {
		System.out.println("알파벳 입력 후 [enter]를 누르세요");
		
		int i;
		try {
			while((i= System.in.read()) !='\n') {
				System.out.print((char)i);
				System.out.println("("+i+")");
			}
		}catch (IOException e) {
			
		}

	}

}
