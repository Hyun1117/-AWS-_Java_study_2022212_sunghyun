package j18_제네릭;

public class Main {

	public static void main(String[] args) {
		TestData<String, Integer> td = new TestData<String, Integer>("jsh", 100);
		TestData<String, Double> td2 = new TestData<String, Double>("jsh", 100.05);// 제네릭은 생성될 때 타입을 결정한다.

		System.out.println(td);
		System.out.println(td2);
	}

}
