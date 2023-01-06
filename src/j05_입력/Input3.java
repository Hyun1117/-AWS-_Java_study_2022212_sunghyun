package j05_입력;

import java.util.Scanner;

public class Input3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in); //system => 운영체제를 뜻함
		
		String str1 = null;
		int age = 0;
		String str2 = null;
		String str3 = null;
		
		System.out.print("이름 : ");
		str1 = scanner.next();//nextLine() 함수를 제외하고 엔터와 스페이스바를 포함하지 않는다. 그러므로
		//버퍼안에 문자열이나 스페이스바 엔터가 남아있기 때문에 한번더 nextLine()해준다.
		System.out.print("나이 :  ");
		age = scanner.nextInt();
		scanner.nextLine();
		System.out.print("주소 : ");
		str2 = scanner.nextLine();
		System.out.print("연락처 : ");
		str3 = scanner.next();
		
		System.out.println("사용자의 이름은 " + str1 +"이고 "+ "나이는 " + age +"살입니다.");
		System.out.println("주소는 " + str2 + "에 거주중입니다.");
		System.out.println("연락처는 " + str3 + " 입니다");
		
	}

}
