package day0408.collection.stream;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamLotto {

	public static void main(String[] args) {
		IntStream is = new Random().ints(1, 46);
		Stream<String> ss= is.distinct().limit(6).sorted().mapToObj(i -> i + "");
		
		ss.forEach(System.out::println);

	}

	}


