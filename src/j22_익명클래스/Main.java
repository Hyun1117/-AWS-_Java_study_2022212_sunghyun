package j22_익명클래스;

public class Main {
	
	public static void main(String[] args) {
		Calculator c1 = new Addition();
		
		System.out.println(c1.calc(10, 20));
		
		
		
		/////////////////////////////////////
		
		//임시적으로 구현된 객체 -> 익명클래스라고 함 (한번만 쓰는 경우 익명클래스를 이용한다)
		//다른 곳에서는 쓰지 못함 딱 여기서만 쓸 수 있다. 1회성
		//인터페이스와 추상클래스 또한 익명클래스를 쓸 수 있다.
		Calculator c2 = new Calculator() { 
			
			@Override
			public int calc(int x, int y) {
				// TODO Auto-generated method stub
				return x - y;
			}
		};
		System.out.println(c2.calc(200, 100));
	}
}
