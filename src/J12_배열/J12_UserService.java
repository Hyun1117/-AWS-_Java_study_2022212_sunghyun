package J12_배열;

import java.util.Scanner;
/*	
 * 프로세서 => cpu
 * 프로세스는 여러개의 쓰레드를 가지고 있음
 */
public class J12_UserService {

	private Scanner scanner;
	private J12_UserRepositoty userRepositoty;

	public J12_UserService(J12_UserRepositoty userRepositoty) {//초기값을 지정할 때는 생성자에 한다. 메모리 절약
	 scanner = new Scanner(System.in);
	 this.userRepositoty = userRepositoty;
	}

	public void run() {
		boolean loopFlag = true;
		char select = '\0';
		while (loopFlag) {
			showMainMenu();
			select = inputSelect("메인");
			loopFlag = mainMenu(select);
		}
	}

	public void stop() {
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
				System.out.println("프로그램 종료중....(" + ( i + 1 ) +"/10)");
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료");
	}
	
	private void UpdateUser() {
		J12_User user = verifyUsername();
		if(user == null) {
			System.out.println("존재하지 않는 사용자 이름입니다.");
			return;
		}
		boolean loopFlag = true;
		char select = '\0';
		
		while(loopFlag) {
			showUpdateMenu(user);
			select = inputSelect("수정");
			loopFlag = UpdateMenu(user, select);
		}
	}
	
	private char inputSelect(String menuName) {
		System.out.print(menuName + " 메뉴선택 : ");
		char select = scanner.next().charAt(0);
		scanner.nextLine();// 버퍼를 비워주기
		return select;
	}

	private void showMainMenu() {
		System.out.println("========<< MainMenu >>========");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 등록");
		System.out.println("3. 사용자이름으로 회원 조회");
		System.out.println("4. 회원 정보 수정");
		System.out.println("==============================");
		System.out.println("q. 프로그램 종료");
		System.out.println();
	}
	
	private void showUpdateMenu(J12_User user) {
		System.out.println("========<< 수정메뉴 >>========");
		System.out.println("사용자이름: " + user.getUsername());
		System.out.println("1. 비밀번호 변경 ");
		System.out.println("2. 이름 변경");
		System.out.println("3. 이메일 변경");
		System.out.println("==============================");
		System.out.println("b. 뒤로가기");
		System.out.println();
	}
	
	private void showUsers() {
		J12_User[] users = userRepositoty.getUserTable();
		
		System.out.println("========<회원 전체 조회>========");
		
		for(J12_User user : users) {
			System.out.println(user.toString());
		}
		System.out.println("================================");
	}
	
	private void registerUser() {
		J12_User user = new J12_User();
		System.out.println("========<회원 등록>========");
		System.out.println("사용자 이름 : ");
		user.setUsername(scanner.nextLine());
		
		System.out.println("비밀번호 : ");
		user.setPassword(scanner.nextLine());
		
		System.out.println("성명 : ");
		user.setName(scanner.nextLine());		
		
		System.out.println("이메일 : ");
		user.setEmail(scanner.nextLine());
		
		userRepositoty.saveUser(user);
	}
	

	
	
	private boolean mainMenu(char select) {
		boolean flag = true;
		
		if(isExit(select)) {
			flag = false;
		}else {
			if(select == '1') {
				showUsers();
				
			}else if(select == '2') {
				registerUser();
				
			}else if(select == '3') {
				//UsernameSearch();
				showUser();
			}else if(select == '4') {
				//UserUpdate();
				UpdateUser();
			}else {
				System.out.println(getSelectErrorMessage());
				
			}
		}
		System.out.println();
		
		return flag;
	}
	
	private boolean isExit(char select) {
		return select == 'q' || select == 'Q';
	}
	private boolean isUpdateExit(char select) {
		return select == 'b' || select == 'B';
	}
	
	//코드의 확장성을 위해 void가 아닌 String으로 잡음
	private String getSelectErrorMessage() {
		return "###<< 잘못된 입력입니다. 다시 입력하세요. >>###";
	}
	
	private boolean UpdateMenu(J12_User user, char select) {
		boolean flag = true;
		
		if(isUpdateExit(select)) {
			flag = false;
		}else {
			if(select == '1') {
				//UpdateUserPassword();
				updatePassword(user);
			}else if(select == '2') {
				//이름 변경
				updateName(user);
			}else if(select == '3') {
				//이메일 변경
				updateEmail(user);
			}else {
				System.out.println(getSelectErrorMessage());
				
			}
		}
		System.out.println();
		
		return flag;
	}
	

	
	
	private void showUser() {
		J12_User user = null;
		System.out.println("=======<회원 조회>======");
		user = verifyUsername();
		
		if(user == null) {
			System.out.println("존재하지 않는 사용자이름입니다.");
			return;
		}
		System.out.println(user.toString());
		System.out.println("========================");
	}
	
	
	private J12_User verifyUsername() {
		String username = null;
		System.out.println("사용자 이름 : ");
		username = scanner.nextLine();
		return userRepositoty.findUserByUsername(username);
	}
	
	
	private void updatePassword(J12_User user) {
		
		String oldpassword = null;
		String newpassword = null;
		String confirmPassword = null;
		
		System.out.println("=====<< 비밀번호 변경 >>=====");
		
		System.out.println("기존 비밀번호 입력");
		oldpassword = scanner.nextLine();
		
		if(!comparePassword(user.getPassword(), oldpassword)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		
		System.out.print("새로운 비밀번호 입력: ");
		newpassword = scanner.nextLine();
		System.out.print("새로운 비밀번호 확인: ");
		confirmPassword = scanner.nextLine();
		
		if(!comparePassword(newpassword, confirmPassword)) {
			System.out.println("새로운 비밀번호가 일치하지 않습니다.");
			return;
		}
		user.setPassword(newpassword);
		System.out.println("비밀번호 변경 완료");
	}
	
	private void updateName(J12_User user) {
		
		String newName = null;
		String password = null;
		
		System.out.println("=====<< 이름 변경 >>=====");
		
		System.out.print("비빌번호 입력 : ");
		password = scanner.nextLine();
		
		if(!comparePassword(user.getPassword(), password)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		System.out.print("새로운 이름 입력 : ");
		newName = scanner.nextLine();
		
		user.setName(newName);
		System.out.println("이름 변경 완료");
	}
	
	private void updateEmail(J12_User user) {
		
		String newEmail = null;
		String password = null;
		
		System.out.println("=====<< 이메일 변경 >>=====");
		
		System.out.print("비밀번호 입력 : ");
		password = scanner.nextLine();
		
		if(!comparePassword(user.getPassword(), password)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		
		System.out.print("새로운 이메일 입력 : ");
		newEmail = scanner.nextLine();
		
		user.setEmail(newEmail);
		System.out.println("이메일 변경완료");
		
	}
	
	private boolean comparePassword(String prePassword, String nextPassword) {
		return prePassword.equals(nextPassword);
	}

	
	

}

//내코드
//private void UsernameSearch() {
//	
//	J12_User user = null;
//	String username = null;
//	System.out.println("=====<회원 조회(사용자 이름)>=====");
//	System.out.print("사용자 이름 입력: ");
//	user.setName(scanner.nextLine());
//	user = userRepositoty.findUserByUsername(user.getName());
//	System.out.println(user.toString());
//}
//private void UserUpdate() {
//	
//	J12_User user = null;
//	boolean loopFlag = true;
//	char select = '\0';
//	
//	System.out.println("수정할 사용자 이름을 입력하세요.");
//	
//	user.setUsername(scanner.nextLine());
//	
//	user = userRepositoty.findUserByUsername(user.getName());
//	
//	if(user == null) {
//		System.out.println("해당 사용자는 존재하지 않는 사용자 이름입니다.");
//		return;
//	}
//	while(loopFlag) {
//		showUpdateMenu();
//		select = inputSelect("수정");
//		loopFlag = UpdateMenu(user, select);
//		
//	}
//}


//private void UpdateUserPassword(J12_User user) {
//String password;
//System.out.println("=======<<비밀번호 변경>>=======");
//System.out.println("기존 비밀번호을 입력하세요 : ");
//user.setPassword(scanner.nextLine());
//user = userRepositoty.findUserByUsername(user.getPassword());
//if(user == null) {
//	System.out.println("비밀번호가 일치하지 않습니다.");
//	return;
//}else {
//	System.out.println("새로운 비밀번호을 입력하세요 : ");
//	user.setPassword(scanner.nextLine());
//	System.out.println("새로운 비밀번호을 확인하세요 : ");
//	password = scanner.nextLine();
//	if(user.getPassword().equals(password)) {
//		System.out.println("비밀번호 변경 완료!!");
//		userRepositoty.saveUser(user);
//		return;
//	}else {
//		System.out.println("비밀번호가 일치하지 않습니다.");
//		return;
//	}
//	
//}
//
//}
