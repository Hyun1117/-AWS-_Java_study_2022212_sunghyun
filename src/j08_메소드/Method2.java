package j08_메소드;

public class Method2 {
	
	//클래스 안에서 정의한것을 메소드라 부르고 바깥에서 정의한 것을 함수라고 한다.
	// 매개변수 : x, 반환 x
	// 매개변수 -> 입력
	// void -> 반환이 없다.
	// 호이스팅 -> 실행전에 소스코드를 분석하고 정의한다.
	public static void method1() {
		System.out.println("단순 실행");
		System.out.println();
	}
	
	//매개변수: int 하나 입력, 반환 x
	public static void method2(int num) {
		System.out.println("num: " + num);
		System.out.println();
	}
	
	//매개변수 : 매개변수 두개 입력, 반환 x
	public static void method3(int num, int num2) {
		System.out.println("num : " +num);
		System.out.println("num2 : " +num2);
		System.out.println();
	}
	
	//반환값은 하나만 가능하다.
	public static String method4() {
		return "데이터 반환";
	}
	
	public static String method5(int age) {
		return age + "살";
	}
	
	public static void main(String[] args) {
		method1();//함수 호출
		method2(100);
		method3(200,300);
		System.out.println(method4());
		System.out.println();
		
		String data1 = method4();
		System.out.println(data1);
		System.out.println();
		
		System.out.println(method5(29));
		System.out.println();
	}
}
