package day0408.collection.stream;

import java.util.Arrays;

public class ReduceTest {
	// getBytes() : String -> byte[]
		public static void main(String[] args) {
			String[] greeting = {"안녕하세요~~~","Hello", "Good Morning",
					"반갑습니다^^"};
			String s = Arrays.stream(greeting).reduce("", 
					(s1,s2) -> {if(s1.getBytes().length >= s2.getBytes().length)
									return s1;
								else return s2;});
			
			
			System.out.println(s);
		}

}
