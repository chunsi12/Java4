package day0409.io;

import java.io.Serializable;
//직렬화해서 객체를 다른 곳에 저장하겠다. 
//@SuppressWarnings("serial")
public class Person implements Serializable {

 private static final long serialVersionUID = 1L;//버전 관리
 
 String name;
 transient String job;

 Person(String name, String job) {
	this.name = name;
	this.job = job;
}

@Override
public String toString() {
	return "Person [name=" + name + ", job=" + job + "]";
}


 
}


