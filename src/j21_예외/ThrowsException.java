package j21_예외;

import java.util.Arrays;
import java.util.List;

//throws -> 메소드에 붙이면 해당 메소드를 호출 할 때마다 무조건 예외처리를 해야한다. 예외 떠넘기기
//throws Exception -> checked Exception이라서 해당 메소드를 예외처리를 안하면 빨간줄이 뜬다.(강제성 O)
//throws RuntimeException -> unchecked Exception이라서 해당 메소드가 빨간줄이 안 뜬다.(강제성 X)
//throws는 checked Exception를 해야함
public class ThrowsException {

	public static void printList(List<String> list, int size) throws Exception {
		for (int i = 0; i < size; i++) {
			System.out.println("[" + i + "]" + list.get(i));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String[] names = { "김수현", "이종현", "박성진", "김동민" };
		
		try {
			throw new ClassCastException();
			//printList(Arrays.asList(names), 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//현재 발생한 예외가 어떤 것인지 보여줌
		} finally {//예외가 떠도 안떠도 무조건 실행된다.(임시저장소로 많이 이용한다.)
			System.out.println("무조건 실행");
		}
		
		System.out.println("프로그램 정상종료");
	}

}
