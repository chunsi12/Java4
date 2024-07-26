package day0409.net;
import java.io.*;
import java.net.*;

public class MultiServerThread implements Runnable {
	private Socket socket;
	private MultiServer ms;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public MultiServerThread(MultiServer ms) {
		this.ms = ms;//지금 접속한 클라이언트와 연결된 socket을 가지고 있음
	}

	public void run() {
		boolean isStop = false;
		try {
			socket = ms.getSocket();
			//String 객체를 주고 받음
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			String message = null;
			while (!isStop) {
				message = (String) ois.readObject();
				String[] str = message.split("#");//id#message id#exit(종료)
				if (str[1].equals("exit")) {
					broadCasting(message);
					isStop = true;
				} else {
					broadCasting(message);
				}
			}
			ms.getList().remove(this);
			System.out.println(socket.getInetAddress() + "정상적으로 종료하셨습니다");
			System.out.println("list size : " + ms.getList().size());
		} catch (Exception e) {
			ms.getList().remove(this);
			System.out.println(socket.getInetAddress() + "비정상적으로 종료하셨습니다");
			System.out.println("list size : " + ms.getList().size());
			System.out.println("list size : " + ms.getList().size());
		}
	}

	public void broadCasting(String message) throws IOException {
		for (MultiServerThread ct : ms.getList()) {
			ct.send(message);
		}
	}

	public void send(String message) throws IOException {
		oos.writeObject(message);
	}
}
