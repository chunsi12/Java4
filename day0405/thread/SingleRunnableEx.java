package day0405.thread;

public class SingleRunnableEx implements Runnable {
	@Override
	public void run() {
		for(int i = 0; i < 5 ; i++) {
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("3초 지남");
		}
	}
	public static void main(String[] args) {
		SingleRunnableEx sr = new SingleRunnableEx();
		Thread t1 = new Thread(sr ,"t1"); // Runnable 구현객체에 있는 run()사용
		t1.start();
		
		Thread t2 = new Thread(()->{
			for(int i = 0; i < 20; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("test");
			}
		} ,"t2");
		t2.start();
		
	}

}
