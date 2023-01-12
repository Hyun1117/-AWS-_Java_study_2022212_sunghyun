package j17_스태틱;

public class StaticMain {
	
	public static void main(String[] args) {
		
		
//		TestA ta = new TestA();
//		TestA ta2 = new TestA();
//		
//		System.out.println(ta.getNum());
//		ta.setNum(100);
//		System.out.println(ta2.getNum());
		
		//객체가 생성을 안했는데 메소드를 호출하고 있다.
		System.out.println("출력 1 : " + TestA.getNum());
		System.out.println();
		
		TestA.setNum(100);
		System.out.println("출력 2 : " + TestA.getNum());
		
		
	}

}
