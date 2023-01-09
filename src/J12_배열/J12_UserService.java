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
	
	private void showUpdateMenu() {
		System.out.println("========<< 수정메뉴 >>========");
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
	
	private void UsernameSearch() {
		
		J12_User user = new J12_User();
		System.out.println("=====<회원 조회(사용자 이름)>=====");
		System.out.print("사용자 이름 입력: ");
		user.setName(scanner.nextLine());
		user = userRepositoty.findUserByUsername(user.getName());
		System.out.println(user.toString());
	}
	private void UserUpdate() {
		J12_User user = new J12_User();
		boolean loopFlag = true;
		char select = '\0';
		while(loopFlag) {
			System.out.println("수정할 사용자 이름을 입력하세요.");
			user.setName(scanner.nextLine());
			user = userRepositoty.findUserByUsername(user.getName());
			if(user == null) {
				System.out.println("해당 사용자는 존재하지 않는 사용자 이름입니다.");
				break;
			}
			showUpdateMenu();
			select = inputSelect("수정");
			loopFlag = UpdateMenu(select);
			
		}
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
				UsernameSearch();
			}else if(select == '4') {
				UserUpdate();
			}else {
				System.out.println(getSelectErrorMessage());
				
			}
		}
		System.out.println();
		
		return flag;
	}
	private boolean UpdateMenu(char select) {
		boolean flag = true;
		
		if(isUpdateExit(select)) {
			flag = false;
		}else {
			if(select == '1') {
				UpdateUserPassword();
				
			}else if(select == '2') {
				
				
			}else if(select == '3') {
				
			}else {
				System.out.println(getSelectErrorMessage());
				
			}
		}
		System.out.println();
		
		return flag;
	}
	
	private void UpdateUserPassword() {
		J12_User user = new J12_User();
		String password;
		System.out.println("=======<<비밀번호 변경>>=======");
		System.out.println("기존 비밀번호을 입력하세요 : ");
		user.setPassword(scanner.nextLine());
		user = userRepositoty.findUserByUsername(user.getPassword());
		if(user == null) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}else {
			System.out.println("새로운 비밀번호을 입력하세요 : ");
			user.setPassword(scanner.nextLine());
			System.out.println("새로운 비밀번호을 확인하세요 : ");
			password = scanner.nextLine();
			if(user.getPassword().equals(password)) {
				System.out.println("비밀번호 변경 완료!!");
				userRepositoty.saveUser(user);
			}else {
				System.out.println("비밀번호가 일치하지 않습니다.");
				return;
			}
			
		}
		
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
}

