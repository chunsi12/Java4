package day0405.thread;

public class SingleThreadEx1 extends Thread {
	
private int[] temp;
	
	public SingleThreadEx1(String threadname) {
		super(threadname);
		temp = new int[]{1,2,3,4,5,6,7,8,9,10};
	}
	
	@Override
	public void run() { //Thread가 수행할 작업
		for(int i : temp) {
			
			try {
				sleep(1000);//지정한 ms만큼 대기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.printf("현재 thread 이름 : %s ", currentThread().getName());
			System.out.println("temp value : "+i);
		}
	}

	public static void main(String[] args) {
		SingleThreadEx1 st = new SingleThreadEx1("first");
	SingleThreadEx1 st2 = new SingleThreadEx1("second");	
		st.start();
	st2.start();
//		st.run();
	}

}
