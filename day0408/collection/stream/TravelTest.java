package day0408.collection.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TravelTest {
public static void main(String[] args) {
		
		TravelCustomer customerLee = new TravelCustomer("이순신", 40, 100);
		TravelCustomer customerKim = new TravelCustomer("김유신", 20, 100);
		TravelCustomer customerHong = new TravelCustomer("홍길동", 13, 50);
		
		List<TravelCustomer> customerList = new ArrayList<>();
		customerList.add(customerLee);
		customerList.add(customerKim);
		customerList.add(customerHong);
		
		System.out.println("== 이름 순서대로 출력 ==");
		customerList.stream().sorted((c1,c2) -> c1.getName().compareTo(c2.getName()))
							.forEach(System.out :: println);
		
		System.out.println();
		System.out.println("== 나이 순으로 출력 ==");
		customerList.stream().sorted((c1,c2) -> c1.getAge() - c2.getAge()).forEach(System.out :: println);
		System.out.println();
		customerList.stream().sorted(Comparator.comparing(TravelCustomer::getAge)).forEach(System.out :: println);
		
		System.out.println();
		System.out.println("== 고객 명단 추가된 순서대로 출력 ==");
		customerList.stream().map(c->c.getName()).forEach(s->System.out.println(s));
		
		customerList.stream().map(c->c.getName()).map(name -> name.substring(0, 1)).forEach(s->System.out.println(s));
		
		
		int total = customerList.stream().mapToInt(c->c.getPrice()).sum();
		System.out.println("총 여행 비용은 :" + total + "입니다");
		
		double totalAvg = customerList.stream().mapToInt(c->c.getPrice()).average().orElse(0.0);
		System.out.printf("총 여행 비용 평균은 : %.2f원 입니다\n" , totalAvg  );
		
		
		
		System.out.println("== 20세 이상 고객 명단 정렬하여 출력 ==");
		customerList.stream().filter(c->c.getAge() >= 20)
								.map(c->c.getName())
								.sorted()
								.forEach(s->System.out.println(s));
	}
//map : 요소 하나에 똑같은 작업 처리
}
