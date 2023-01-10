package j13_상속;

public class KiaCar extends Car{
	
	public KiaCar() {
		super();//나의 상위 객체를 의미한다. kiaCar -> Car의 생성자가 호출됨 super는 생성자 제일 상위에 있어야함
		//부모클래스가 먼저 생성 되어야 함
		System.out.println("자식");
		
	}
	
	
	@Override//오버라이드를 하지 않는다면 부모 클래스에서 바로 들고오고,
	//한다면 자식 클래스 메소드를 통해서 가져오는 것 -> 주소가 다르기 때문에 오버로딩과는 다른 개념이다.
	public int discountPrice(int percentage) {
		
		return super.discountPrice(percentage);
	}
	
	public void test() {
		KiaCar kc = this;//자신의 주소를 변수로 쓰고 싶을 때
	}
}
