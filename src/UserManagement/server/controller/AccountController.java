package UserManagement.server.controller;

import UserManagement.dto.ResponseDto;
import UserManagement.entity.User;

public class AccountController {
	private static AccountController instance;

	private AccountController() {
	}

	public static AccountController getInstance() {

		// 각각의 스레드를 쓰고 있기 때문에 하나의 스레드가 AccountController를 쓰고 있으면 다른 스레드가 쓰지 못하게 하는 것
		// 동기화.
		// synchronized (instance) { }//synchronized 동기화
		if (instance == null) {
			instance = new AccountController();
		}

		return instance;
	}

	public ResponseDto<?> register(User user) {

		return new ResponseDto<String>("ok", "회원가입 성공");
	}
}
