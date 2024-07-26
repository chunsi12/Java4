package day0409.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MoveFile {
	//파일 이동
	//원본파일명 구하기 -> 새로운 파일 생성
	//내용 복사, 원본 파일을 삭제
	public static void main(String[] args) {
		System.out.print("파일 명 > ");
		Scanner scan = new Scanner(System.in);
		String path = scan.next();
		
		File orig = new File(path);
		String newPath= "D:\\move\\"+orig.getName();
		//이동할 경로는 직접 명시해도 되고 
		//스캐너로 다시 받아도 됨...
		
		try(FileInputStream fis = new FileInputStream(orig);
			BufferedInputStream	bis = new BufferedInputStream(fis);
			FileOutputStream fos = new FileOutputStream(newPath);
			BufferedOutputStream bos = new BufferedOutputStream(fos)){
		
			byte[] readBytes = new byte[fis.available()];
			
			while(bis.read(readBytes) != -1) {
				bos.write(readBytes);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//orig.delete();
		System.out.println("파일 이동");
		
	}
}