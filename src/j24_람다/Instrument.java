package j24_람다;


@FunctionalInterface//람다를 명시하는 어노테이션, 추가적인 메소드를 막아준다.

//default함수는 상관없다 왜냐하면 이미 구현된 함수이기 때문인다.
public interface Instrument {

	public String play(String instrument);
	
	public default void testPring() {
		System.out.println("테스트");
	}
	
}
