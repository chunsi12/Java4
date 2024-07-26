package day0408.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorReferencesExample {
	public static void main(String[] args) {
		Function<String, Member> function1 = Member :: new;
		// Member apply(String s){
//			return new Member(String s);
//		}	
		//객체 생성시 매개변수가 일치하는 생성자를 호출
		Member member1 = function1.apply("angel");
		
		BiFunction<String, String, Member> function2 = Member :: new;
		//Member apply(String, String){
		//	return new Member(String, String);
		//}
		Member member2 = function2.apply("angel","김엔젤");
		
		System.out.println("member1 : "+member1);
		System.out.println("member2 : "+member2);
	}
}