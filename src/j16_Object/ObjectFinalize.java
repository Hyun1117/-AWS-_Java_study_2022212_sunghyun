package j16_Object;

// 이 패키지 안에서만 참조가 가능 하지만 이렇게 쓰지 말 것.
class Test {
	private int num;

	public Test(int num) {
		super();
		this.num = num;
		System.out.println(num + "생성");
	}

	@Override
	protected void finalize() throws Throwable {// 가비지 콜렉터로 소멸이 됐을 때 호출이 된다.
		// 이것을 언제 써야하는가. 데이터를 보존하고 싶을 때
		System.out.println(num + "객체 소멸");
	}
}

public class ObjectFinalize {

	public static void main(String[] args) {

		Test test = null;

		for (int i = 0; i < 10; i++) {
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				
//				e.printStackTrace();
//			}

			test = new Test(i);

			test = null;

			System.gc();// 강제로 가비지 컬렉터를 호출하는 것 , JVM이 여유가 있을 떄 호출됨
		}
	}

}

//얕은 복사
//같은 놈
//user u = new user()
//user u1 = u;
//스텍 메모리에 변수를 만들어 복사를 한 것

//깊은 복사
//다른 놈
//객체를 새로 만들어 객체 안에 있는 데이터까지 복사를 하는 것

/* finalize를 쓰는 이유 (오버라이드)
 * 소멸한 데이터가 나중에 쓰기 위해 만들었는데 가비지 콜렉터가 소멸을 하였을 때
 * finalize를 이용해 옮기기 위해 쓰인다.
 * */
 