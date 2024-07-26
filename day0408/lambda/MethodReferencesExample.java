package day0408.lambda;

import java.util.function.IntBinaryOperator;

public class MethodReferencesExample {
	public static void main(String[] args) {
		IntBinaryOperator operator;
			
		operator = (x, y) -> Calculator.staticMethod(x, y); //int applyAsInt(int, int)
		System.out.println("결과1: " + operator.applyAsInt(1, 2));

		operator = Calculator :: staticMethod; // applyAsInt
		System.out.println("결과2: " +  operator.applyAsInt(3, 4));
			
						
		Calculator obj = new Calculator();
		operator = (x, y) -> obj.instanceMethod(x, y); // int applyAsInt(int, int)
		System.out.println("결과3: " + operator.applyAsInt(5, 6));

		operator = obj :: instanceMethod;
		System.out.println("결과4: " + operator.applyAsInt(7, 8));
		}
	}



