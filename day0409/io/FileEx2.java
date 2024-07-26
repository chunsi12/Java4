package day0409.io;

import java.util.Date;
import java.io.File;
import java.io.IOException;

public class FileEx2 {

	public static void main(String[] args) throws IOException {
		File nf = new File("d:\\test.txt");
		if(!nf.exists()) {
		System.out.println("파일 생성 : "+ nf.createNewFile());
		}
		if(nf.exists()) {
		System.out.println("경로 : "+  nf.getPath());
		System.out.println("이름 : "+ nf.getName());
		System.out.println("마지막 수정 날짜 :"+ new Date(nf.lastModified()));
		}
		File f2 = new File("d://test123.txt");
		System.out.println(nf.renameTo(f2));
		
		nf.delete();
	}
}
