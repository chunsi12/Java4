package day0409.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamEx {

	public static void main(String[] args) {
	//파일에 기보녕데이터 100, true, "테스트" 3.1f 출력 후
	//해당 파일 읽어오기
	try(FileOutputStream fos = new FileOutputStream("data.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		FileInputStream fis = new FileInputStream("data.txt");
		DataInputStream dis = new DataInputStream(fis) ){
		dos.writeInt(100);
		dos.writeBoolean(true);
		dos.writeUTF("테스트");
		dos.writeFloat(3.14f);
		
		System.out.println(dis.readInt());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readUTF());
		System.out.println(dis.readFloat());
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
