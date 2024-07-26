package day0405.thread;

public class Test {

	public static void main(String[] args) {
		System.out.println("메인 시작");
		Thread thread = new Thread(() -> {
			System.out.println("쓰레드 시작");
		});

		thread.start();
		for (int i = 0; i < 10; ++i) {
			System.out.println(i);
		}

		System.out.println("메인 끝");
	}

	}


