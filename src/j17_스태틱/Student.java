package j17_스태틱;

public class Student {

		private static final int CODE = 20230000;
		
		private static int ai = 1; //auto_increment
		
		private int studentCode;
		private String name;
		
		public Student(String name) {
			studentCode = CODE + ai;
			ai++;
			this.name = name;
		}
		
		public static int getAutoIncrement() {
			System.out.println("현재 AI : " + 6);
			
			//static 메소드에 꼭 생성이 되어야지만 쓸 수 있는 변수들은 쓸 수 가 없다.
			//static은 class를 선연하고 컴파일 됐을 때 이미 메모리에 할당이 되어 있기 때문에
			//static 메소드 안에서는 static 변수만 가능 단 메소드 안에 있는 변수는 사용가능하다.
//			System.out.println("학생이름 : " + name);
			return ai;
		}
		
		@Override
		public String toString() {//생략가능 단 String 변수에 대입할 때는 toString을 붙여야한다.
			return "Student [studentCode=" + studentCode + ", name=" + name + "]";
		}
		
		
		
		
}
