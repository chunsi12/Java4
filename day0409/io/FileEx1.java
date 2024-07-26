package day0409.io;

import java.io.File;

public class FileEx1 {

	public static void main(String[] args) {
		File cDrive = new File("c://");
		String[] list = cDrive.list();
		for(int i = 0; i < list.length ; i++) {
			File f = new File("c://", list[i]);
			if(f.isDirectory()) {
				System.out.println("디렉토리 :" + list[i]);
			}else {
				System.out.printf("파일 : %s(%,d바이트)\n",list[i], f.length());
			}
		}
	}

}
