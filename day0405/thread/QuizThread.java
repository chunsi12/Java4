package day0405.thread;

import java.util.Random;
import java.util.Scanner;

public class QuizThread extends Thread {
	int su1, su2;
	int timer = 0;
	int playCount = 0;
	boolean isCheck = true;
	final int FINISH = 5;

	public void startGame() {
		Scanner scan = new Scanner(System.in);
		while (isCheck) {
			try {
				su1 = new Random().nextInt(100) + 1;
				su2 = new Random().nextInt(100) + 1;
				System.out.print(su1 + " + " + su2 + " = ");
				int result = scan.nextInt();

				if (result == (su1 + su2)) {
					System.out.println("정답!!");
					playCount++;
				} else {
					System.out.println("오답");
					continue;
				}
				if (playCount == FINISH) {
					System.out.println("결과 : " + timer + "초");
					isCheck = false;
				}
			} catch (Exception e) {
				System.out.println("정답은 정수로 입력하세요");
			}

		} // while
	}// startGame

	@Override
	public void run() {
		while(isCheck) {
			try {
				Thread.sleep(1000);
				timer++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
