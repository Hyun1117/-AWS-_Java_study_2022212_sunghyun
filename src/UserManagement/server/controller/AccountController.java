package UserManagement.server.controller;

import java.util.Map;

import UserManagement.dto.ResponseDto;
import UserManagement.service.UserService;

public class AccountController {
	private static AccountController instance;
	private UserService userService;

	private AccountController() {
		userService = UserService.getInstance();
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

	public ResponseDto<?> register(String userJson) {
		
		Map<String,String> resultMap = userService.register(userJson);
		
		if(resultMap.containsKey("error")) {
			return new ResponseDto<String>("error",resultMap.get("error"));
		}
		
		return new ResponseDto<String>("ok", resultMap.get("ok"));
	}
}
