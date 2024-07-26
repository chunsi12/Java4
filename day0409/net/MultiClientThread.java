package day0409.net;

public class MultiClientThread extends Thread {
	private MultiClient mc;

	public MultiClientThread(MultiClient mc) {
		this.mc = mc;
	}

	public void run() {
		String message = null;
		String[] receivedMsg = null;
		boolean isStop = false;
		while (!isStop) {
			try {
				message = (String) mc.getOis().readObject();
				receivedMsg = message.split("#");
			} catch (Exception e) {
				e.printStackTrace();
				isStop = true;
			}
			System.out.println(receivedMsg[0] + "," + receivedMsg[1]);
			if (receivedMsg[1].equals("exit")) {
				if (receivedMsg[0].equals(mc.getId())) {
					mc.exit();
				} else {
					mc.getJta().append(
							receivedMsg[0] + "님이 종료 하셨습니다."
									+ System.getProperty("line.separator"));//문장의 끝
					mc.getJta().setCaretPosition(
							mc.getJta().getDocument().getLength()); //다음 나올 내용의 위치 지정
				}
			} else {
				mc.getJta().append(
						receivedMsg[0] + " : " + receivedMsg[1]
								+ System.getProperty("line.separator"));
				mc.getJta().setCaretPosition(
						mc.getJta().getDocument().getLength());
			}
		}
	}
}

