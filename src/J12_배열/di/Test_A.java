package J12_배열.di;

public class Test_A {
	//값을 주는 방법은 두 가지 생성자의 매개변수와 Setter
	
	private final Test_B tb;//final은 상수 그리고 초기화를 무조건 해야함. 프로그램이 돌아가는 와중에 값이 변하지 않아야 하는 값에 final을 붙여준다.
	
	
//	public Test_A() {      Test_B는 Test_A에 의존성이 높고 결합도도 높다.
//		tb = new Test_B();
//	}
	
	public Test_A(Test_B tb) {//생성자에서 변수를 초기화 하거나 생성을 해야하는 것이 좋다. 
		this.tb = tb;		  //final을 붙이면 필수 매개변수 생성자 
	}
	
//	public void setTb(Test_B tb) {
//		this.tb = tb;
//	}
	
	public void testA1() {
		System.out.println("Test_A1 메소드 호출!");
		//Test_B tb = new Test_B();

		tb.testB1();
	}

	public void testA2() {
		System.out.println("Test_A2 메소드 호출!");
		//Test_B tb = new Test_B();

		tb.testB1();

	}

}
