package day0409.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkEx1 {

	public static void main(String[] args) {
		InetAddress ip = null;
		InetAddress[] ipArr = null;
		
		try {
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName : "+ ip.getHostName());
			System.out.println("getHostAddress : "+ ip.getHostAddress());
			System.out.println("toString() : "+ip);
		System.out.println();
		
		ipArr = InetAddress.getAllByName("www.naver.com");
		for(InetAddress i : ipArr) {
			System.out.println(i);
		}
				
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}
	}
	}


