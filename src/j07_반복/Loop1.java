package j07_반복;

public class Loop1 {

	public static void main(String[] args) {
		//지역 변수 = 지역 내에서만 사용가능
		//전역 변수 = 전역으로 사용가능
		int sum = 0;
		
		for(int i = 0; i < 100; i++) {
			sum += i + 1; 
		}
		System.out.println("1 ~ 100까지 총합: " + sum);

	}

}
