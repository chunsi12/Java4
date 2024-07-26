package day0408.lambda;

import java.util.function.IntSupplier;

public class LambdaEx3 {
	public static void main(String[] args) {
		//주사위 수(1~6) 리턴
		//int getAsInt()
		IntSupplier dice = () -> (int)(Math.random() * 6) + 1;
		
		System.out.println("주사위 : "+ dice.getAsInt());
	}


}
