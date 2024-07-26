package day0405.thread;

public class BeepPrintExample1 {

	public static void main(String[] args) {
		
		Thread thread = new Thread(new BeepTask());
		thread.start();

		for(int i=0; i<5; i++) {
			System.out.println("삡");
			try { Thread.sleep(500); } catch(Exception e) {}
		}

	}

}
