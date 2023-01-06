package j06_조건;

import java.util.Scanner;

public class Conditional3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int score = 0;
		String grade = null;
		
		System.out.print("점수 입력 : ");
		score = scanner.nextInt();
		
		//0점보다 작거나 100점보다 크면 계산불가
		//90 ~ 100 A
		//80 ~ 89 B
		//70 ~ 79 C
		//60 ~ 69 D
		//0 ~ 59 F
		
		//내 코드
		if(score > 89) {
			//if(score > 94) grade = "A+";
			 grade = "A";
		}
		else if(score > 79) {
			//if(score > 84) grade = "B+";
			 grade = "B";
		}
		else if(score > 69) {
			//if(score > 74) grade = "C+";
			 grade = "C";
		}
		else if(score > 59) {
			//if(score > 64) grade = "D+";
			 grade ="D";
		}
		else {
			//if(score > 54) grade = "F+";
			 grade ="F";
		}
		
		if(score % 10 > 4 || score == 100) {//F학점은 +가 없다라는 조건을 추가 안함
			grade = grade + "+";
		}
		
		if(score > 0 && score < 101)
		System.out.print("점수(" + score + "): " + grade + "학점");
		else System.out.println("계산 불가");
		
		//강사코드
		if(score < 0 || score > 100) {
			grade = null;
		}else if(score > 89) {
			grade = "A";
		}else if(score > 89) {
			grade = "B";
		}else if(score > 89) {
			grade = "C";
		}else if(score > 89) {
			grade = "D";
		}else {
			grade = "F";
		}
		
		if((score > 59 && score < 101) && (score % 10 > 4 || score == 100)) {
			grade += "+";
		}
		
		if(grade == null) {
			System.out.println("계산불가");
		}else {
			System.out.print("점수(" + score + "): " + grade + "학점");
		}
		
	}

}
