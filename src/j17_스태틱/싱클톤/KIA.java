package j17_스태틱.싱클톤;


//싱글톤은 하나만 존재하여야 하기 때문에 생성자가 private으로 생성한다.
//싱글톤으로 생성된 객체는 모든 곳에서 접근이 가능하다.
//같은 객체를 써야하고 or 하나의 객체로 기능을 조작할 때 쓴다.
//하나의 객체로 공유를 해야할 때 쓴다.
public class KIA {
	private static KIA instance = null;

	private KIA() {
	}

	public static KIA getInstance() {//두번은 생성안한다. 한번 생성한 객체를 계속 리턴해준다.
		if (instance == null) {
			instance = new KIA();
		}
		return instance;
	}//여기Line까지 싱글톤은 항상 이렇게 만들어 준다.

	public void printCompanyName() {
		System.out.println(getClass().getSimpleName());
	}
}
