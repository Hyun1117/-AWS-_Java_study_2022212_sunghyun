package j01_출력;

public class OutPut1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("이름 : ");
		System.out.println("정성현");
		System.out.print("나이 : ");
		System.out.println(28 + "1"); //28과 "28"의 차이는 숫자와 문자열의 차이다. 문자열은 " "안에 넣어야함
		System.out.println("이름 : " + "정성현");
		//"문자" + 1은 하면 자동으로 숫자 1이 문자열로 바뀜
	}

}
