package j15_인터페이스;

public class Main {

	public static void main(String[] args) {
		Equipment[] equipments = new Equipment[2];

		equipments[0] = new GeneralCalculator(); //eq랑 gen 같이 생성
		equipments[1] = new SmartPhone(); //

		Calculator[] calculators = new Calculator[2];
		
		calculators[0] = new GeneralCalculator();
		calculators[1] = new SmartPhone();
		
		System.out.println("모든 장비 전원 켜기");
		for (Calculator c : calculators) {
			Equipment eq = (Equipment) c;
			eq.powerOn();
		}//반대로 가능
		System.out.println();

		System.out.println("모든 장비 전원 켜기");
		for (Equipment eq : equipments) {
			eq.powerOn();
		}
		System.out.println();

		System.out.println("모든 장비에서 10과 20을 더하기");

		for (Equipment eq : equipments) {
			Calculator c = (Calculator) eq;//다운캐스팅을 한후 업캐스팅을 한다.
			double result = c.plus(10, 20);
			System.out.println("결과 : " + result);
		}

		System.out.println("모든 장비에서 10과 0을 나누기");

		for (Equipment eq : equipments) {
			Calculator c = (Calculator) eq;
			double result = c.division(10, 2);
			System.out.println("결과 : " + result);
		}

		System.out.println("모든 장비 전원 끄기");
		for (Equipment eq : equipments) {
			eq.powerOff();
		}
		System.out.println();
	}
}
