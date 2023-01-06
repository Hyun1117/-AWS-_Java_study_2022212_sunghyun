package j09_클래스;

public class J09_StudentMain {
	
	
	
	public static void main(String[] args) {
		//스택영역에서는 변수에 초기화를 반드시 해야함
		//클래스에는 초기화를 안해도 자동으로 초기화가 되어있음 클래스는 그냥 틀일뿐이다.
		
//		J09_Student student1 = new J09_Student(); // 생성자
//		J09_Student student2 = new J09_Student();
//		//자료형     변수명             값
//		
//		//생성자는 클래스명과 일치
//		//생성자는 기본적으로 생략되어있다.
//		System.out.println(student1);
//		System.out.println(student2);
		
		
		J09_Student s1 = new J09_Student();
		J09_Student s2 = new J09_Student();
		
		s1.name = "정성현";
		s1.age = 29;
		
		s1.printInfo();
		
		
		s2.printInfo();
		
	}
	
	
}
