package j13_상속.casting2;

public class Taxi extends Transportation {
	
	//@ 시작하는 문법을 어노테이션이라 한다.
	//어노테이션은 라이브러리를 만들거나 기능을 축약할 때 쓰임.
	
	//재정의 되었다는 표시용
	@Override
	public void go() {  
		
		System.out.println("택시를 타고 출발");
	
	}
	
	@Override
	public void stop() {
	
		System.out.println("택시를 타고 도착");
		
	}
	
	public void checkTaxiNumber( ) {
		System.out.println("택시 번호 확인");
	}

}
