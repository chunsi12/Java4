package day0405.thread;

public class JoinEx implements Runnable {
	@Override
	public void run() {
		System.out.println("run");
		first();
	}
	
	public void first() {
		System.out.println("first");
		second();
	}
	public void second() {
		System.out.println("second");
	}
	
	public static void main(String[] args) {
		System.out.println("main start");
		Thread t = new Thread(new JoinEx());
		t.start();
		
	try {
			t.join();// main 중지, t 실행
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//t 소멸(run()끝), 중지했던 main 마저 실행한다.
		System.out.println("main end");
		
	}

}
