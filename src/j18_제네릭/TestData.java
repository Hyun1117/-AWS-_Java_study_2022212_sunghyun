package j18_제네릭;

public class TestData<T,E> {
	
	//제네릭은 래퍼 클래스 자료형만 쓸 수 있다. ->일반 자료형은 쓸 수 없다.
	//자료형을 바꾸고 싶을 때 쓴다.
	//자료형을 클래스화 시킨 것을 wrapper Class라고 한다.
	private T data1;//char
	private E data2;//int
	
	public  TestData(T data1, E data2) {
		this.data1 = data1;
		this.data2 = data2;
	}

	@Override
	public String toString() {
		return "TestData [data1=" + data1 + ", data2=" + data2 + "]";
	}
	

}
