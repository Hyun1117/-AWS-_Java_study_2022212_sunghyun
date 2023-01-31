package j24_람다;

public class Lamda1 {

	public static void main(String[] args) {
		Instrument instrument = new Instrument() {

			@Override
			public String play(String instrument) {

				return instrument + "를 연주합니다.";
			}
		};

		Instrument instrument2 = (String item) -> {
			return item + "을(를) 연주합니다";
		};

		// 매개변수 자료형을 생략할 수 있다.
		// 매개변수의 이름을 바꿀 수 있다.
		Instrument instrument3 = (item) -> {
			return item + "을(를) 부순다";
		};

		// 매개변수가 하나이면 감싸는 괄호를 생략할 수 있다.
		Instrument instrument4 = item -> {
			return item + "을(를) 부순다";
		};

		// 구현부의 명령이 하나일 때 중괄호를 생략할 수 있다.
		// 이때 return자료형이 정해져있으면 리턴값으로 사용이 된다.
		// 중괄호를 생략하는 것은 람다식에서 return반드시 생략을 해야한다.
		Instrument instrument5 = item -> item + "을(를) 부순다";

		int result = 10 + 20;
		Instrument instrument6 = item -> item + "을(를) 부순다" + result;

		System.out.println(instrument.play("기타"));
		// System.out.println(instrument1.play("기타"));
		System.out.println(instrument2.play("트럼펫"));
		System.out.println(instrument6.play("피아노"));

	}

}
