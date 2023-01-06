package j07_반복;

import java.util.Scanner;

public class Loop2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int startNumber = 0;
		int endNumber = 0;
		int sum = 0;
		
		System.out.print("시작 : ");
		startNumber = scanner.nextInt();
		
		System.out.println("끝 : ");
		endNumber = scanner.nextInt();
		
		//내 코드
		for(int i = 0; i < endNumber + 1; i++) {
				if(i > startNumber - 1) {
					sum += i;
				}
		}
		
		
		//강사코드
		for(int i = 0; i < endNumber - startNumber + 1; i++)
		{
			sum += i + startNumber;
		}
		System.out.println("startNumber ~ endNumber까지 총합: " + sum);
		//반복횟수를 생각해보자.

	}

}
