package j14_추상;


//추상클래스
//공통된 것들을 모아두는 것을 추상화라고 한다.
//추상 메소드가 하나라도 있으면 추상클래스라고 정의함.
//생성이 불가능하다.
//설계도 역할
//그 외에는 일반클래스와 동일한 기능을 가진다.
public abstract class Transportation {

	
	
	// 추상 메소드
	public abstract void go();
	
	public abstract void stop();
	
}
