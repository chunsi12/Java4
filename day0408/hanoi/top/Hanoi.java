package day0408.hanoi.top;

import java.util.Scanner;

public class Hanoi {
	static int count=0;
	static void move(int n, int x, int y) {
		
		if(n>1) {
			move(n-1,x,6-x-y);
		}
		System.out.println("원반["+n+"]을 "+x+"기둥에서 "+y+"기둥으로 옮김");
		count++;
		if(n>1) {
			move(n-1,6-x-y,y);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("하노이의 탑");
		System.out.print("원반의 수 : ");
		int n = scan.nextInt();
		
		move(n,1,3);
		
		System.out.println(count);
		
	}

}
