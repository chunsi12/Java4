package day0408.lambda;

@FunctionalInterface // 람다로 구현할 수 있는 인터페이스
interface MyFunction {
	void run();
}

@FunctionalInterface
interface MyNumber {
	int max(int x, int y);
}

public class LambdaEx1 {
	
	public static void main(String[] args) {
		
		int a = 10;
		MyFunction f1 = () -> System.out.println("f1.run()실행");// 구현 객체 생성
		MyNumber n1 = (x, y) -> {
			if (x >= y) {
//				a = 20;
				return x + a;//외부 클래스의 멤버를 자신의 멤버처럼사용가능
			} else {
				return y;
			}
		};

		f1.run();
		System.out.println(n1.max(10, 12));
	} 
}
