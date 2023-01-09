package J12_배열.di;

public class Main {
	//dependency injection DI
	public static void main(String[] args) {
		//Test_C tc = new Test_C();
		Test_C tc2 = new Test_C();
		Test_B tb = new Test_B(tc2);//결합도와 의존도를 낮추기 위해 Test_B를 생성
		
		Test_A ta = new Test_A(tb);//객체 주입은 항상 외부에서 해야함
		
				
		ta.testA1();
		ta.testA2();
		tb.testB1();
		
		
	}
}
