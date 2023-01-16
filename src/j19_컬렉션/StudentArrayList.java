package j19_컬렉션;

import java.util.ArrayList;
import java.util.List;

//return -> 함수의 값을 리턴하거나 ,void 형에서 return ->함수가 종료

public class StudentArrayList {

	public static void updateYear(
			List<Student> students,//제네릭을 꼭 해줘야함
			String searchName,
			int newyear) {
		for(Student student : students) {
			if(student.getName().equals(searchName)) {
				student.setYear(newyear);
				return;
			}
		}
		System.out.println("검색실패");
	}
	
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("김종환", 1));
		students.add(new Student("고병수", 1));
		students.add(new Student("손민재", 1));
		students.add(new Student("황창욱", 1));

		System.out.println(students);

		//System.out.println(students.get(0).getName());

		String searchName = "황창욱";
		// 이름이 searchName인 학생을 찾아서 학년을 4학년으로 바꿔라
		// 만약 searchName 동일한 이름이 없으면 "검색실패" 메세지를 출력
		
		
		//선형 탐색 방법
		boolean flag = true;
		
		for(int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
			if(student.getName().equals(searchName)) {
				student.setYear(4);
				flag = false;
				break;
			}
		}
		if(flag) {
			System.out.println("검색실패");
		}
		System.out.println(students);
		
		
		//forEach
//		for(Student st : students) {
//			
//			if(st.getName().equals(searchName)) {
//				st.setYear(4);
//				flag = false;
//				break;
//			}
//		}
//		if(flag) {
//			System.out.println("검색실패");
//		}
//		System.out.println(students);
		
		updateYear(students,"황창욱", 2);
		System.out.println(students);
		
		
		
	}

}


//내 코드 반복문 안에 if문이 두개면 일을 두번하는 게 된다. 별로 좋지 않음
//for(int i = 0; i < students.size(); i++) {
//	
//	boolean flag = false;
//	if(students.get(i).getName() == searchName) {
//		students.get(i).setYear(4);
//		System.out.println(students.get(i).toString());
//		flag = true;
//	}
//	if(!flag) {
//		System.out.println("검색실패");
//		break;
//	}
//}

