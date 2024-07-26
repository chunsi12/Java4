package day0409.net;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class MultiClient implements ActionListener {
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private String ip;
	private String id;
	private JFrame jframe; // 프레임 창
	private JTextField jtf; // 한줄 입력 - 엔터 입력시 액션 이벤트 발생
	private JTextArea jta; // 여러줄 입력
	private JLabel jlb1, jlb2; // 고정문자열
	private JPanel jp1, jp2; //패널
	private JButton jbtn;//버튼 - 클릭 이벤트

	public MultiClient(String argIp, String argId) {
		ip = argIp;
		id = argId;
		jframe = new JFrame("Multi Chatting");
		jtf = new JTextField(30);
		jta = new JTextArea("", 10, 50);
		jlb1 = new JLabel("Usage ID : [[ " + id + "]]");
		jlb2 = new JLabel("IP : " + ip);
		jbtn = new JButton("종료");
		jp1 = new JPanel();
		jp2 = new JPanel();
		jlb1.setBackground(Color.yellow);
		jlb2.setBackground(Color.green);
		jta.setBackground(Color.pink);
		jp1.setLayout(new BorderLayout());
		jp2.setLayout(new BorderLayout());
		jp1.add(jbtn, BorderLayout.EAST);
		jp1.add(jtf, BorderLayout.CENTER);//텍스트필드 버튼
		jp2.add(jlb1, BorderLayout.CENTER);//id 레이블 ip 레이블
		jp2.add(jlb2, BorderLayout.EAST);
		jframe.add(jp1, BorderLayout.SOUTH);
		jframe.add(jp2, BorderLayout.NORTH);
		JScrollPane jsp = new JScrollPane(jta,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jframe.add(jsp, BorderLayout.CENTER);
		jtf.addActionListener(this);//현재 객체가 가지고 있는 actionPerformed() 실행
		jbtn.addActionListener(this);//현재 객체가 가지고 있는 actionPerformed() 실행
		
		jframe.addWindowListener(new WindowAdapter() { // window 이벤트 처리 - 창을 끌 때
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					oos.writeObject(id + "#exit");
				} catch (IOException ee) {
					System.out.println(id);
					ee.printStackTrace();
				}
				System.exit(0);
			}
			@Override
			public void windowOpened(WindowEvent e) {
				jtf.requestFocus(); // tf 선택(커서) -> 바로 입력할 수 있도록
			}
		});
		jta.setEditable(false);//직접 입력 x
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		jframe.pack();
		jframe.setLocation((screenWidth - jframe.getWidth()) / 2,
				(screenHeight - jframe.getHeight()) / 2);
		jframe.setResizable(false);
		jframe.setVisible(true);
	}
// ActionListener - action이벤트가 발생하면 자동 호출
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource(); // 어떤 객체에서 이벤트 발생했는지 확인
		String msg = jtf.getText();
		if (obj == jtf) {
			if (msg == null || msg.length() == 0) {
				JOptionPane.showMessageDialog(jframe, "글을쓰세요", "경고",
						JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					oos.writeObject(id + "#" + msg);
				} catch (IOException ee) {
					ee.printStackTrace();
				}
				jtf.setText("");
			}
		} else if (obj == jbtn) {
			try {
				oos.writeObject(id + "#exit");
			} catch (IOException ee) {
				ee.printStackTrace();
			}
			System.exit(0);
		}
	}//이벤트 끝

	public void exit() {
		System.exit(0);
	}

	public void init() throws IOException {
		socket = new Socket(ip, 3333);
		System.out.println("connected...");
		oos = new ObjectOutputStream(socket.getOutputStream());
		ois = new ObjectInputStream(socket.getInputStream());
		MultiClientThread ct = new MultiClientThread(this);
		Thread t = new Thread(ct);
		t.start();
		//이벤트 처리하는 메인 / 서버한테 메세지 받아오는 jta에 출력 스레드
	}

	public static void main(String args[]) throws IOException {
		JFrame.setDefaultLookAndFeelDecorated(true);
		MultiClient cc = new MultiClient(args[0], args[1]);
		cc.init();
	}

	public ObjectInputStream getOis() {
		return ois;
	}    

	public JTextArea getJta() {
		return jta;
	}

	public String getId() {
		return id;
	}
}

