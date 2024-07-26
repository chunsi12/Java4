package day0405.thread;

import java.awt.Toolkit;

public class BeepTask implements Runnable {
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();	
		for(int i=0; i<5; i++) {		
			toolkit.beep();//"os 경고음"
			try { Thread.sleep(500); } catch(Exception e) {}
		}

	}


}
