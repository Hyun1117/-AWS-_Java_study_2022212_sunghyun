package j07_반복;

import java.util.Scanner;

public class Loop3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int count = 0;
		int sum = 0;
		int total = 0;
		System.out.print("반복횟수 : ");
		count = scanner.nextInt();
		
		for(int i = 0; i < count; i++) {
			int num1 = 0;
			int num2 = 0;
			sum = 0;
			System.out.println( i + 1+"번 반복");
			System.out.print("a : ");
			num1 = scanner.nextInt();
			System.out.print("b : ");
			num2 = scanner.nextInt();
			sum = num1 + num2;
			System.out.println(i + 1 + "번 합 : " + sum);
			System.out.println();
			total += sum;
		}
		System.out.println("총합 : " + total);
	}

}
