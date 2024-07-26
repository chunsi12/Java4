package day0405.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class RunnableExcuteExample {

	public static void main(String[] args) throws Exception {
		
		
		//ExecutorService 생성
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		//이메일을 보내는 작업 생성 및 처리 요청
		for(int i=0; i<10; i++) {
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					ThreadPoolExecutor threadPoolExecutor = 
							(ThreadPoolExecutor) executorService;
					int poolsize = threadPoolExecutor.getPoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.println("총 스레드 개수: "+poolsize + " 작업 스레드명: "+threadName);
					
					int value = Integer.parseInt("삼");//예외 발생
					
				}
			};
			executorService.execute(runnable);
			
			Thread.sleep(10);
		}//for
			
		//ExecutorService 종료
		executorService.shutdown();
	}

}
