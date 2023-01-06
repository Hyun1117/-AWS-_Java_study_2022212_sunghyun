package J12_배열;

import java.util.Scanner;
/*	
 * 프로세서 => cpu
 * 프로세스는 여러개의 쓰레드를 가지고 있음
 */
public class J12_UserService {

	private Scanner scanner;

	public J12_UserService() {//초기값을 지정할 때는 생성자에 한다. 메모리 절약
	 scanner = new Scanner(System.in);
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
	
	private boolean mainMenu(char select) {
		boolean flag = true;
		
		if(isExit(select)) {
			flag = false;
		}else {
			if(select == '1') {
				
			}else if(select == '2') {
				
			}else if(select == '3') {
				
			}else if(select == '4') {
				
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
	
	
	//코드의 확장성을 위해 void가 아닌 String으로 잡음
	private String getSelectErrorMessage() {
		return "###<< 잘못된 입력입니다. 다시 입력하세요. >>###";
	}
}
