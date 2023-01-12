package j17_스태틱.싱클톤;

import java.util.Scanner;

public class B {
	
	//private A a = A.getInstance();
	
	public B() {
		
	}
	
	public void insertStudent() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("학생이름 입력 : ");
		String name = scanner.nextLine();

		Student student = new Student(name);
		A.getInstance().addStudent(student);
		A.getInstance().showStudents();

	}

}
