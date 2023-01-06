package j09_클래스;

public class J09_UserMain {
	
	
	
	public static void main(String[] args) {
		J09_User u1 = new J09_User();
		J09_User u2 = new J09_User();
		J09_User u3 = new J09_User();
		
		u1.username = "user1";
		u1.password = 1234;
		u1.name = "홍길동";
		u1.email = "useremail1@naver.com";
		
		u2.username = "user2";
		u2.password = 123456; 
		u2.name = "김민수";
		u2.email = "useremail2@gmail.com";
		
		u3.username = "user3";
		u3.password = 1234567;
		u3.name = "황철수";
		u3.email = "useremail3@naver.com";
		
		u1.printUserInfo();
		System.out.println();
		u2.printUserInfo();
		System.out.println();
		u3.printUserInfo();
		
	}
	
}
