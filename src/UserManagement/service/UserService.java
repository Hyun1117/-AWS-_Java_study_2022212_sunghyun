package UserManagement.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.mindrot.jbcrypt.BCrypt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import UserManagement.entity.RoleDtl;
import UserManagement.entity.User;
import UserManagement.repository.UserRepository;
import UserManagement.repository.UserRepositoryArrayList;


public class UserService {
	
	private Gson gson;
	
	private UserRepository userRepository;
	
	private static UserService instance;
	
	public static UserService getInstance() {
		if(instance == null) {
			instance = new UserService();
		}
		return instance;
	}
	
	private UserService() {
		userRepository = UserRepository.getInstance();
		gson = new GsonBuilder().setPrettyPrinting().create();
	}
	
	public Map<String,String> register(String userJson) {
		
		//response : 응답
		
		//isBlank -> 스페이스바도 빈값으로 봄
		Map<String,String> response = new HashMap<>();
		
		Map<String,String> userMap = gson.fromJson(userJson, Map.class);
		
		//회원가입을 하면 JSON으로 저장을 함 -> 그리고 JSON을 Map으로 반복을 하기 위해 변환 시킨후 Entry는 key,value를 한쌍으로 가짐
		//for Each을 이용해 value가 비었니 확인 하고 해당하는 Key값을 꺼내어 error를 보낸다.
		for(Entry<String, String> userEntry : userMap.entrySet()) {
			if(userEntry.getValue().isBlank()) {
				response.put("error", userEntry.getKey() + "은(는) 공백 일 수 없습니다.");
				return response;
			}
		}
		
		User user = gson.fromJson(userJson, User.class);
		System.out.println("서비스에 넘어옴 !! User 객체로 변환");
		System.out.println(user);
		
		if(dublicatedUsername(user.getUsername())) {
			response.put("error","이미 사용중인 사용자 이름입니다.");
			return response;
		}
		
		if(dublicatedEmail(user.getEmail())) {
			response.put("error","이미 사용중인 이메일 입니다.");
			return response;
		}
		//hashpw로 비밀번호를 암호화한다.
//		String pw = BCrypt.hashpw("1234", BCrypt.gensalt());
//		checkpw로 암호화 된 비밀번호와 입력된 비밀번호가 같은지 검사.
//		System.out.println(BCrypt.checkpw("1234", pw));
//		
		//user를 저장하기전에 비밀번호를 암호화 한다음 저장을 해야한다.
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		System.out.println("암호화 후 ");
		System.out.println(user);
		
		userRepository.saveUser(user);
		
		RoleDtl roleDtl = RoleDtl.builder()
				.roleId(3)
				.userId(user.getUserId())
				.build();

		userRepository.saveRoleDtl(roleDtl);
		response.put("ok","회원가입 성공");
		
		return response;
	}
	private boolean dublicatedUsername(String username) {
		return userRepository.findUserByUsername(username) != null;
	}
	
	private boolean dublicatedEmail(String email) {
		return userRepository.findUserByemail(email) != null;
	}
	
	public Map<String, String> authorize(String loginUserJson){
		
		Map<String,String> loginUser = gson.fromJson(loginUserJson, Map.class);
		
		Map<String,String> response = new HashMap<>();
		
		for(Entry<String, String> entry : loginUser.entrySet()) {
			if(entry.getValue().isBlank()){
				response.put("error", entry.getKey() + "은(는) 공백일 수 없습니다.");
				return response;
			}
		}
		
		String usernameAndEmail = loginUser.get("usernameAndEmail");
		
		User user = userRepository.findUserByUsername(usernameAndEmail);
		
		if(user == null) {
			user = userRepository.findUserByUsername(usernameAndEmail);
			if(user == null) {
				response.put("error", "사용자 정보를 확인해주세요");
				return response;
			}
		}
		
		if(!BCrypt.checkpw(loginUser.get("password"), user.getPassword())) {
			response.put("error", "사용자 정보를 확인해주세요");
			return response;
		}
		response.put("ok", user.getName() + "님 환영합니다");
		return response;
	}
	
}
