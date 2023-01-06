package j08_메소드;

public class Method3 {
	
	
	//메소드 오버로딩 : 메소드의 이름을 똑같지만 매개변수의 갯수와 순서가 다름, 호출 할 떄 달라짐
	//메소드의 자료형이 달라도 오버로딩이 안된다
	public static void ov1() {
		System.out.println("매개변수 없음");
	}
	
	public static void ov1(int x) {
		System.out.println("int 매개변수 하나 매개변수 x: " + x);
	}
	
	public static void ov1(int a, String b) {
		System.out.println("int 먼저 그다음 String");
	}
	
	public static void ov1(String a, int b) {
		System.out.println("String 먼저 그 다음  int");
	}
	
	public static void main(String[] args) {
		ov1();
		ov1(100);
		ov1(100,"b");
		ov1("a",100);

	}

}
