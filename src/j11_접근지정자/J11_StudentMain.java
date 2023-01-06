package j11_접근지정자;

import j11_접근지정자.default1.J11_StudentDefault; //다른 패키지의 자료형을 쓸려면 import를 해줘야  한다.

public class J11_StudentMain {
		
	
	public static void main(String[] args) {
		J11_Student s1 = new J11_Student("김준일", 30);
		
		s1.name = "정성현";
		s1.age = 29;
		
		s1.printInfo();
		
		J11_StudentDefault s2 = new J11_StudentDefault();
		
//		s2.name = "김준이";
//		System.out.println("이름: " + s2.name);
		System.out.println("이름: " + s2.getName());
		
		
	}
	
}
