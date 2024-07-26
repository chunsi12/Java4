package day0408.collection.stream;

import java.util.ArrayList;
import java.util.List;

class Book {
	String name;
	int price;

	Book(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}

public class LibraryTest {

	public static void main(String[] args) {
		List<Book> bookList = new ArrayList<>();

		bookList.add(new Book("자바", 25000));
		bookList.add(new Book("파이썬", 15000));
		bookList.add(new Book("안드로이드", 30000));

		// 스트림 생성하고 출력하기
		// 1. 모든 책 가격의 합
		// 2. 책의 가격이 20000원 이상인 책의 이름을 정렬해서 출력
		int total = bookList.stream().mapToInt(b -> b.getPrice()).sum();
		System.out.println("모든 책 가격의 합 : " + total + "원");

		int total2 = bookList.stream().map(b -> b.getPrice()).reduce(0, (a, b) -> a + b);

		int max = bookList.stream().mapToInt(b -> b.getPrice()).max().orElse(0);
		System.out.println("제일 비싼 책 가격 : " + max + "원");

		bookList.stream().filter(b -> b.getPrice() == max).map(b -> b.getName())
				.forEach(System.out::println);

		bookList.stream().filter(b -> b.getPrice() >= 20000).map(b -> b.getName()).sorted()
				.forEach(name -> System.out.print(name + " "));
	}
}






