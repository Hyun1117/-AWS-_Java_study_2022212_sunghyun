package j15_인터페이스;


//interface == class
//메소드 전부 abstract 메소드이다.
//일반메소드를 쓸러면 default를 써줘야한다.
//멤버 변수들은 가질수 없지만, 상수는 가질 수 있다.
public interface Calculator {

	public int ERROR = -9999999;
	
	public double plus(double x, double y);
	
	public double minus(double x, double y);
	
	public default double multiplication(double x, double y) {
		return x * y;
	}
	
	public double division(double x, double y);
}
