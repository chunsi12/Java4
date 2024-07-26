package day0408.collection.stream;

import java.util.ArrayList;

public class ArrayListStreamTest {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<>();
		list.add("Tomas");
		list.add("Edward");
		list.add("Jack");
		
		list.stream().forEach(s -> System.out.print(s+" "));
		System.out.println();
		list.stream().sorted().forEach(s -> System.out.print(s+" "));
	}

	}


