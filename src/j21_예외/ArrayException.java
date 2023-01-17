package j21_예외;

//예외처리
//프로그램의 오류를 예외라고 한다.
//
public class ArrayException {

	public static void main(String[] args) {
		
		
		Integer[] nums = { 1, 2, 3, 4, 5 };

		try {// if else와 비슷 try -> 예외가 일어날수도 있는 부분
			throw new NullPointerException();// 강제로 예외를 일어나게 하는 것.
//			for (int i = 0; i < 6; i++) {
//				System.out.println(nums[i]);
//			}
		} catch (IndexOutOfBoundsException e) {// 예외가 일어난 부분을 받는 부분
			System.out.println("예외 처리함");
		} catch (NullPointerException e) {
			System.out.println("빈값 처리함");
		} catch (Exception e) {// 마지막에는 Exception을 해주는게 좋다.(모든 예외처리를 다 예상 못하기 때문에)
			System.out.println("예상 못한 예외 처리함");
		}

		System.out.println("프로그램 정상 종료");

	}

}
